package com.example.rudapplication.api;

import com.example.rudapplication.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface UserAPI {

    @GET("user/me")
    Call<User> getMe(@HeaderMap Map<String, String> headerMap);
}
