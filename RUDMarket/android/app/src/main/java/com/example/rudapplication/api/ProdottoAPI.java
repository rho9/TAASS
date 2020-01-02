package com.example.rudapplication.api;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ProdottoAPI {

    @POST("prodotto/getImageProdottoByProdottoId")
    Call<ResponseBody> getImageProdottoByProdottoId(@Body String idProdotto);
}
