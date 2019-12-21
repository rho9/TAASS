package com.example.rudapplication;

import android.os.Bundle;

import com.example.rudapplication.api.AuthAPI;
import com.example.rudapplication.api.UserAPI;
import com.example.rudapplication.model.AuthResponse;
import com.example.rudapplication.model.LoginRequest;
import com.example.rudapplication.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private String token;

    private TextView loginText;
    private EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginText = findViewById(R.id.lin);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        user = (EditText) findViewById(R.id.usrusr);
        password = findViewById(R.id.pswrdd);
    }

    public void doLogin() {
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
        loginRequest.setEmail(user.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<AuthResponse> authResponseCall = authAPI.doLogin(loginRequest);
        authResponseCall.enqueue(new Callback<AuthResponse>() {
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
        });
    }

}
