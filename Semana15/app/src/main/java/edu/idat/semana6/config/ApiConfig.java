package edu.idat.semana6.config;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import edu.idat.semana6.api.PostApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    private static String baseUrl;
    private static Retrofit client;

    private static PostApi postApi;

    static {
        baseUrl = "https://dummyapi.io/data/api/";
        client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClientBuilder().build())
                .build();
    }

    private static OkHttpClient.Builder getClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(log);

        builder.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("app-id", "6014597c989c2242753fe082")
                        .build();
                return chain.proceed(request);
            }
        });

        return builder;
    }

    public static PostApi getPostApi() {
        if (postApi == null) {
            postApi = client.create(PostApi.class);
        }
        return postApi;
    }
}
