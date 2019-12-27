package com.example.rudapplication.api;

import com.example.rudapplication.model.AuthResponse;
import com.example.rudapplication.model.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthAPI {

    @POST("auth/login")
    Call<AuthResponse> doLogin(@Body LoginRequest loginRequest);
}
