package com.example.rudapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rudapplication.rudlogin.LoginRepository;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavigationView navigationView;
    private Menu menu;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                if (item.getTitle().equals("Login")) {
                    startLoginActivity();
                } else {
                    item.setTitle("Login");
                    doLogout();
                }

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

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void doLogout() {
        LoginRepository.getInstance().logout();
        TextView navHeaderName = findViewById(R.id.nav_header_name);
        TextView navHeaderEmail = findViewById(R.id.nav_header_email);

        navHeaderName.setText("Ospite");
        navHeaderEmail.setText("Effettua il Login");

        Toast.makeText(getApplicationContext(), "Hai effettuato il Logout", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        TextView navHeaderName = findViewById(R.id.nav_header_name);
        TextView navHeaderEmail = findViewById(R.id.nav_header_email);
        LoginRepository loginRepository = LoginRepository.getInstance();
        if (loginRepository.isLoggedIn()) {
            navHeaderName.setText(loginRepository.getLoggedIndUser().getName());
            navHeaderEmail.setText(loginRepository.getLoggedIndUser().getEmail());

            MenuItem menuItem = this.menu.findItem(R.id.action_settings);
            menuItem.setTitle("Logout");
        }
        super.onRestart();
    }
}
