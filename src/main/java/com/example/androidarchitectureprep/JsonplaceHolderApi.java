package com.example.androidarchitectureprep;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceHolderApi {

    @GET("posts")
    Call<List<Post>> getposts();


}
