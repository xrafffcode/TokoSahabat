package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityFormPembayaranBinding;
import com.example.tokosahabat.fragment.user.FormAlamatFragment;
import com.example.tokosahabat.fragment.user.FormPembayaranFragment;

public class FormPembayaranActivity extends AppCompatActivity {

    ActivityFormPembayaranBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormPembayaranBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_form_pembayaran, new FormPembayaranFragment()).commit();
    }
}