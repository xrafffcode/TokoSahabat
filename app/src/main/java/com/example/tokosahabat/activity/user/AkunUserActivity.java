package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityAkunUserBinding;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;

public class AkunUserActivity extends AppCompatActivity {

    ActivityAkunUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAkunUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_akun, new ProfileUserFragment()).commit();
    }
}