package com.example.rudapplication.api;

import com.example.rudapplication.model.Sezione;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SezioniAPI {

    @GET("sezione/getSezioni")
    Call<List<Sezione>> getSezioni();

    /* @POST()
    Call<Sezione> createSezione(@Body Sezione sezione);*/
}
