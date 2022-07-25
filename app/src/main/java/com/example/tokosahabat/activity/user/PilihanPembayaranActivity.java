package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityPilihanPembayaranBinding;
import com.example.tokosahabat.fragment.user.PilihanPembayaranFragment;

public class PilihanPembayaranActivity extends AppCompatActivity {

    ActivityPilihanPembayaranBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPilihanPembayaranBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_pilihan_pembayaran, new PilihanPembayaranFragment()).commit();
    }
}