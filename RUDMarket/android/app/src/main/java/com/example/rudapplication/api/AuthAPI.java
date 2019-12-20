package com.example.rudapplication.api;

import com.example.rudapplication.model.AuthResponse;
import com.example.rudapplication.model.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthAPI {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("auth/login")
    Call<AuthResponse> doLogin(@Body LoginRequest loginRequest);
}
