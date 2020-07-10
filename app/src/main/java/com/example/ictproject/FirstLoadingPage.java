package com.example.ictproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.ictproject.activity.LoginActivity;

public class FirstLoadingPage extends AppCompatActivity {

    private final long splash_timeout = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_loading_page);
        (new Handler()).postDelayed((Runnable)(new Runnable() {
            public final void run() {
                FirstLoadingPage.this.startActivity(new Intent((Context)FirstLoadingPage.this, LoginActivity.class));
                FirstLoadingPage.this.finish();
            }
        }), this.splash_timeout);
    }

}
