package edu.idat.semana6.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.semana6.api.PostApi;
import edu.idat.semana6.api.ResponseListApi;
import edu.idat.semana6.config.ApiConfig;
import edu.idat.semana6.config.DbConfig;
import edu.idat.semana6.dao.PostDao;
import edu.idat.semana6.entity.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private PostDao dao;
    private PostApi api;
    private boolean flagListApi;

    public PostRepository(Application application) {
        dao = DbConfig.getDbConfig(application).postDao();
        api = ApiConfig.getPostApi();
        flagListApi = false;
    }

    public LiveData<List<Post>> list() {
        if (!flagListApi) {
            listApi();
        }
        return dao.list();
    }

    private void listApi() {
        flagListApi = true;

        api.list().enqueue(new Callback<ResponseListApi<Post>>() {
            @Override
            public void onResponse(Call<ResponseListApi<Post>> call, Response<ResponseListApi<Post>> response) {
                List<Post> posts = response.body().getData();

                DbConfig.dbExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.clear();

                        for (Post post : posts) {
                            dao.create(post);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseListApi<Post>> call, Throwable t) {

            }

            @Override
            protected void finalize() throws Throwable {
                flagListApi = false;
            }
        });
    }

    public void save(Post post) {
        DbConfig.dbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (post.getDbId() == 0) {
                    dao.create(post);
                } else {
                    dao.update(post);
                }
            }
        });
    }
}
