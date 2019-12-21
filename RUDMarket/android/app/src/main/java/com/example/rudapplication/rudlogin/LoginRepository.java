package com.example.rudapplication.rudlogin;

import com.example.rudapplication.model.User;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRepository {

    private static volatile LoginRepository instance;
    private User user;
    private Retrofit retrofit;

    public LoginRepository() {
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

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        //dataSource.logout();
    }

    public User getLoggedIndUser() {
        return this.user;
    }

    public void setLoggedInUser(User user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }
}
