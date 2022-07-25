package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.adapter.FormAlamatAdapter;
import com.example.tokosahabat.databinding.ActivityFormAlamatBinding;
import com.example.tokosahabat.fragment.user.CheckoutUserFragment;
import com.example.tokosahabat.fragment.user.FormAlamatFragment;
import com.example.tokosahabat.model.FormAlamatModel;

import java.util.ArrayList;

public class FormAlamatActivity extends AppCompatActivity {


    RecyclerView rvData;
    ArrayList<FormAlamatModel> formholder;
    SessionManager sessionManager;
    String telepon, nama, total_harga;
    AppCompatButton btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_form_alamat);

        Intent terima = getIntent();
        total_harga = terima.getStringExtra("total_harga");

        rvData = findViewById(R.id.rv_form_alamat);
        rvData.setLayoutManager(new LinearLayoutManager(this));

        sessionManager = new SessionManager(FormAlamatActivity.this);
        telepon = sessionManager.getUserDetail().get(SessionManager.TELEPON);
        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);

        formholder = new ArrayList<>();

        FormAlamatModel ob1 = new FormAlamatModel("Nama Penerima", nama);
        formholder.add(ob1);

        FormAlamatModel ob2 = new FormAlamatModel("Alamat", "Perum Abdi Negara D1/27, Padamara, Kab. Purbalingga, Jawa Tengah");
        formholder.add(ob2);

        FormAlamatModel ob3 = new FormAlamatModel("Kode Pos", "53372");
        formholder.add(ob3);

        FormAlamatModel ob4 = new FormAlamatModel("Nomor Telepon Penerima", telepon);
        formholder.add(ob4);

        rvData.setAdapter(new FormAlamatAdapter(formholder));

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormAlamatActivity.this, PilihanPembayaranActivity.class);
                intent.putExtra("total_harga", total_harga);
                startActivity(intent);
            }
        });
    }
}