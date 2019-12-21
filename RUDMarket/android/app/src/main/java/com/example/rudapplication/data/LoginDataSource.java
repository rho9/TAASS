package com.example.rudapplication.data;

import com.example.rudapplication.api.AuthAPI;
import com.example.rudapplication.api.UserAPI;
import com.example.rudapplication.model.AuthResponse;
import com.example.rudapplication.model.LoginRequest;
import com.example.rudapplication.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<User> login(String username, String password) {

        try {
            User user = this.doLogin(username, password);
            /*LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");*/
            return new Result.Success<>(user);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    private User doLogin(String username, String password) {
        String token;
        final Retrofit retrofit = new Retrofit.Builder()
                /*
                    Questo URL è da inserire se ci si vuole connettere al localhost del proprio
                    PC da una macchina virtuale. Se si prova a sostituire con "localhost", ci si
                    starà riferendo all'indirizzo di loopback dell'emulatore stesso
                 */
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthAPI authAPI = retrofit.create(AuthAPI.class);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(username);
        loginRequest.setPassword(password);

        Call<AuthResponse> authResponseCall = authAPI.doLogin(loginRequest);
        AuthResponse authResponse = null;
        try {
            authResponse = authResponseCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        token = authResponse.getAccessToken();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        UserAPI userAPI = retrofit.create(UserAPI.class);
        Call<User> userCall = userAPI.getMe(headers);
        User user = null;
        try {
            user = userCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;

        /*authResponseCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                AuthResponse AuthResponse = response.body();
                token = AuthResponse.getAccessToken();
                System.out.println("TOKEN: " + token);

                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + token);
                UserAPI userAPI = retrofit.create(UserAPI.class);
                Call<User> userCall = userAPI.getMe(headers);
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getApplicationContext(), "Login effettuato!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {

            }
        });*/
    }
}
