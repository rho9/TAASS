package com.example.rudapplication.api;

import com.example.rudapplication.model.Prodotto;
import com.example.rudapplication.model.Sezione;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SezioniAPI {

    @GET("sezione/getSezioni")
    Call<List<Sezione>> getSezioni();

    @POST("sezione/getProdottiByIdSezione")
    Call<List<Prodotto>> getProdottiByIdSezione(@Body Long body);

    /* @POST()
    Call<Sezione> createSezione(@Body Sezione sezione);*/
}
