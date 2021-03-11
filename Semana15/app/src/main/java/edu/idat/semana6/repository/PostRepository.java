package edu.idat.semana6.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.config.DbConfig;
import edu.idat.semana6.dao.PostDao;
import edu.idat.semana6.entity.Post;

public class PostRepository {
    private PostDao dao;

    public PostRepository(Application application) {
        dao = DbConfig.getDbConfig(application).postDao();
    }

    public LiveData<List<Post>> list() {
        return dao.list();
    }

    public void save(Post post) {
        DbConfig.dbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (post.getId() == 0) {
                    dao.create(post);
                } else {
                    dao.update(post);
                }
            }
        });
    }
}
