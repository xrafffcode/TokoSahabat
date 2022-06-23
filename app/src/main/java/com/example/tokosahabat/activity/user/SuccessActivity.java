package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivitySuccessBinding;
import com.example.tokosahabat.fragment.user.FormSuccessFragment;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;

public class SuccessActivity extends AppCompatActivity {

    ActivitySuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_success, new FormSuccessFragment()).commit();

    }
}