package com.example.rudapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rudapplication.api.SezioniAPI;
import com.example.rudapplication.model.Sezione;
import com.example.rudapplication.rudlogin.LoginRepository;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView textView;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_catalogo, R.id.nav_promozioni,
                R.id.nav_doveSiamo, R.id.nav_myrud, R.id.nav_registrazione)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        final Retrofit retrofit = new Retrofit.Builder()
                /*
                    Questo URL è da inserire se ci si vuole connettere al localhost del proprio
                    PC da una macchina virtuale. Se si prova a sostituire con "localhost", ci si
                    starà riferendo all'indirizzo di loopback dell'emulatore stesso
                 */
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SezioniAPI sezioniAPI = retrofit.create(SezioniAPI.class);
        Call<List<Sezione>> call = sezioniAPI.getSezioni();

        call.enqueue(new Callback<List<Sezione>>() {
            @Override
            public void onResponse(Call<List<Sezione>> call, Response<List<Sezione>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                List<Sezione> sezioneList = response.body();

                for (Sezione s : sezioneList) {
                    String content = "";
                    content += "ID: " + s.getId() + "\n";
                    content += "Nome: " + s.getNome() + "\n";
                    System.out.println(content);
                }
            }

            @Override
            public void onFailure(Call<List<Sezione>> call, Throwable t) {
                try {
                    throw t;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                //Toast.makeText(getApplicationContext(), "Hello, world!", Toast.LENGTH_LONG).show();
                startLoginActivity();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    protected void onRestart() {
        Toast.makeText(getApplicationContext(), "Rieccomi", Toast.LENGTH_LONG).show();
        TextView navHeaderName = findViewById(R.id.nav_header_name);
        TextView navHeaderEmail = findViewById(R.id.nav_header_email);
        LoginRepository loginRepository = LoginRepository.getInstance();
        if (loginRepository.isLoggedIn()) {
            navHeaderName.setText(loginRepository.getLoggedIndUser().getName());
            navHeaderEmail.setText(loginRepository.getLoggedIndUser().getEmail());
        }
        super.onRestart();
    }
}
