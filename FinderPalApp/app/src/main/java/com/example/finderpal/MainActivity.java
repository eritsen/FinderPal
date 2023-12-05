package com.example.finderpal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finderpal.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button loginButton;

    private String[] acceptedUsernames = {"nzender", "fibrahim", "eritsen", "dverna"};

    private String acceptedPassword = "finderpal";

    private String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //hides top bar
        getSupportActionBar().hide();

        //creates bottom bar (This section of code is causing the constant "EGL_emulation" notification in LogCat
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_robotcontrol)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //hides bottom bar
        navView.setVisibility(View.GONE);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //detects button press and checks for correct username and password
                onLoginButtonPress(navController,navView);
            }
        });

    }

    private void onLoginButtonPress(NavController navController, BottomNavigationView navView)
    {
        //Get text from EditText box
        EditText editTextUsername = (EditText)findViewById(R.id.username_text);
        EditText editTextPassword = (EditText)findViewById(R.id.password_text);

        //Convert text to string
        String enteredUsername = editTextUsername.getText().toString();
        String enteredPassword = editTextPassword.getText().toString();

        for(int i = 0; i <= 3; i++)
        {
            currentUsername = acceptedUsernames[i];

            if ((i <= 3) && (enteredUsername.equals(currentUsername)) && (enteredPassword.equals(acceptedPassword)))
            {
                //Enable bottom navbar
                navView.setVisibility(View.VISIBLE);

                //Switch screens to dashboard
                navController.navigate(R.id.navigation_home);
                break;
            }
            else if (i == 3)
            {
                Log.i("Login Button","Wrong password or Username");
            }

        }
    }
}