package com.example.rudapplication.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private Retrofit retrofit;
    private static volatile RetrofitUtil instance;

    private RetrofitUtil() {
        this.retrofit = new Retrofit.Builder()
                /*
                    Questo URL è da inserire se ci si vuole connettere al localhost del proprio
                    PC da una macchina virtuale. Se si prova a sostituire con "localhost", ci si
                    starà riferendo all'indirizzo di loopback dell'emulatore stesso
                 */
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
