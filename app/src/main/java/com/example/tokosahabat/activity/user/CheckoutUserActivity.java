package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.databinding.ActivityCheckoutUserBinding;
import com.example.tokosahabat.databinding.FragmentCheckoutUserBinding;
import com.example.tokosahabat.fragment.user.CheckoutUserFragment;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;

public class CheckoutUserActivity extends AppCompatActivity {


    private String total_harga, nama;
    private TextView total, eTnama;
    private AppCompatButton btnOrder;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_checkout_user);
        Intent terima = getIntent();
        sessionManager = new SessionManager(CheckoutUserActivity.this);
        total_harga = terima.getStringExtra("total_harga");
        eTnama = findViewById(R.id.tv_name_checkout);
        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        eTnama.setText(nama);


        total = findViewById(R.id.tv_total_cod);
        btnOrder = findViewById(R.id.btn_order);
        total.setText(total_harga);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutUserActivity.this, FormAlamatActivity.class);
                intent.putExtra("total_harga", total_harga);
                startActivity(intent);
            }
        });



    }
}