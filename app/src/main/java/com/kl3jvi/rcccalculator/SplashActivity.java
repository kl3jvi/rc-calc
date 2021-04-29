package com.kl3jvi.rcccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.iccon);
        imageView.setImageResource(R.drawable.ic_splash);

        new Handler().postDelayed(() -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i); //start new activity
            finish();
        }, SPLASH_TIMEOUT); //time in milliseconds
    }
}