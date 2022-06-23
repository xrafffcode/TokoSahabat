package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.activity.user.DashboardUserActivity;
import com.example.tokosahabat.activity.user.SignUpUserActivity;
import com.example.tokosahabat.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // intent button sign in ke dashboard admin
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke dashboard activity
                startActivity(new Intent(SignInActivity.this, DashboardUserActivity.class));
            }
        });

        // intent button login as admin
        binding.btnLoginAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke login in admin activity
                startActivity(new Intent(SignInActivity.this, LogInAdminActivity.class));
            }
        });

        // intent sign up ke user
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke activity_detail
                startActivity(new Intent(SignInActivity.this, SignUpUserActivity.class));
            }
        });

    }
}