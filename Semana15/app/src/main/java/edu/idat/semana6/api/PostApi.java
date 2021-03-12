package edu.idat.semana6.api;

import java.util.List;

import edu.idat.semana6.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("post")
    Call<ResponseListApi<Post>> list();
}
