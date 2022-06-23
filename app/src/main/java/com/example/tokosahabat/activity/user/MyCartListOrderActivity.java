package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityMyCartListOrderBinding;
import com.example.tokosahabat.fragment.CartFragment;
import com.example.tokosahabat.fragment.user.CartUserFragment;
import com.example.tokosahabat.fragment.user.HomeUserFragment;

public class MyCartListOrderActivity extends AppCompatActivity {

    ActivityMyCartListOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCartListOrderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_detail_cart, new CartUserFragment()).commit();


    }
}