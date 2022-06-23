package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityCheckoutUserBinding;
import com.example.tokosahabat.fragment.user.CheckoutUserFragment;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;

public class CheckoutUserActivity extends AppCompatActivity {

    ActivityCheckoutUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_checkout, new CheckoutUserFragment()).commit();

    }
}