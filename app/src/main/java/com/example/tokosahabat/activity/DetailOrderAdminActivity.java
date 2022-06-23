package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.databinding.ActivityDetailOrderAdminBinding;

public class DetailOrderAdminActivity extends AppCompatActivity {

    ActivityDetailOrderAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailOrderAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}