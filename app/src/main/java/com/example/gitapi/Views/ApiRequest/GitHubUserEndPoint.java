package com.example.gitapi.Views.ApiRequest;

import com.example.gitapi.Views.model.GitHubUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserEndPoint {
    @GET("/users/{user}")
    Call<GitHubUsers> getUser(@Path("user") String user);
}
