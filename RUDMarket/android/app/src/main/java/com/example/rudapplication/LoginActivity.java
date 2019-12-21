package com.example.rudapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rudapplication.api.AuthAPI;
import com.example.rudapplication.api.UserAPI;
import com.example.rudapplication.model.AuthResponse;
import com.example.rudapplication.model.LoginRequest;
import com.example.rudapplication.model.User;
import com.example.rudapplication.rudlogin.LoginRepository;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private String token;

    private TextView loginText;
    private EditText user, psw;
    private LoginRepository loginRepository;
    private LoginActivity loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginActivity = this;

        loginRepository = LoginRepository.getInstance();

        user = (EditText) findViewById(R.id.usrusr);
        psw = findViewById(R.id.pswrdd);

        loginText = findViewById(R.id.lin);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    public void doLogin() {
        String username = user.getText().toString();
        String password = psw.getText().toString();
        AuthAPI authAPI = loginRepository.getRetrofit().create(AuthAPI.class);
        LoginRequest loginRequest = new LoginRequest();
        System.out.println(username + " " + password);
        loginRequest.setEmail(username);
        loginRequest.setPassword(password);

        Call<AuthResponse> authResponseCall = authAPI.doLogin(loginRequest);
        authResponseCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                AuthResponse AuthResponse = response.body();
                System.out.println("TOKEN: " + AuthResponse.getAccessToken());

                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + AuthResponse.getAccessToken());
                UserAPI userAPI = loginRepository.getRetrofit().create(UserAPI.class);
                Call<User> userCall = userAPI.getMe(headers);
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        loginRepository.setLoggedInUser(response.body());
                        System.out.println("LOGGATO: " + response.body().getEmail());
                        loginActivity.finish();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {

            }
        });
    }

}
