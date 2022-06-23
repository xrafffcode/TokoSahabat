package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.databinding.ActivityLogInAdminBinding;

public class LogInAdminActivity extends AppCompatActivity {

    ActivityLogInAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // intent ke halaman Dashboard admin activity
        binding.btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke Dashboard admin activity
                startActivity(new Intent(LogInAdminActivity.this, DashboardAdminActivity.class));
            }
        });

    }
}