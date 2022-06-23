package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityFormAlamatBinding;
import com.example.tokosahabat.fragment.user.CheckoutUserFragment;
import com.example.tokosahabat.fragment.user.FormAlamatFragment;

public class FormAlamatActivity extends AppCompatActivity {

    ActivityFormAlamatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormAlamatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_form_alamat, new FormAlamatFragment()).commit();
    }
}