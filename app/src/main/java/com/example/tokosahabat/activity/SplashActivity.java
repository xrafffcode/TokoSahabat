package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tokosahabat.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void  run() {
                try {
                    sleep(2000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                }
            }
        };
        thread.start();

    }
}