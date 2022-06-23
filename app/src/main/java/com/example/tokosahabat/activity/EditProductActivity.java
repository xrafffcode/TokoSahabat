package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.databinding.ActivityEditProductBinding;

public class EditProductActivity extends AppCompatActivity {

    ActivityEditProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}