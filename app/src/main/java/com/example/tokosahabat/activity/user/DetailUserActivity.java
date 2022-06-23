package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityDetailUserBinding;

public class DetailUserActivity extends AppCompatActivity {

    ActivityDetailUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
}