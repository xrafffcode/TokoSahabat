package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.databinding.ActivityAddDataAdminBinding;

public class AddDataAdminActivity extends AppCompatActivity {

    ActivityAddDataAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDataAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}