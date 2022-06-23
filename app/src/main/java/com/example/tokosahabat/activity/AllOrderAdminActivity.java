package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityAllOrderAdminBinding;
import com.example.tokosahabat.fragment.CartFragment;
import com.example.tokosahabat.fragment.HomeFragment;

public class AllOrderAdminActivity extends AppCompatActivity {

    ActivityAllOrderAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityAllOrderAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_all_order, new CartFragment()).commit();
    }
}