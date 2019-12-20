package com.example.rudapplication.api;

import com.example.rudapplication.model.User;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("user/me")
    Call<User> getMe();
}
