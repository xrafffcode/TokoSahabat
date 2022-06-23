package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.activity.DashboardAdminActivity;
import com.example.tokosahabat.activity.LogInAdminActivity;
import com.example.tokosahabat.databinding.ActivitySignUpUserBinding;

public class SignUpUserActivity extends AppCompatActivity {

    ActivitySignUpUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // intent ke halaman Dashboard admin activity
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke Dashboard admin activity
                startActivity(new Intent(SignUpUserActivity.this, DashboardUserActivity.class));
            }
        });
    }
}