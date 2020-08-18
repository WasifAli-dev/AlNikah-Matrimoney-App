package com.samtech.dev.alnikah_matchfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN  );
        setContentView(R.layout.activity_login);


    }

    public void openRegistrationScreen(View view) {
        Intent intent  = new Intent(LoginActivity.this , RegisterActivity.class);
        startActivity(intent);
    }
}