package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.activity.SearchActivity;
import com.example.tokosahabat.adapter.FormPembayaranAdapter;
import com.example.tokosahabat.model.FormPembayaranModel;
import com.example.tokosahabat.model.Order;
import com.example.tokosahabat.model.OrderData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormPembayaranActivity extends AppCompatActivity {

    TextView harga_pembayaran;
    String total_harga;
    RecyclerView rvPay;
    AppCompatButton btnBayar;
    ArrayList<FormPembayaranModel> pembayaranholder;
    SessionManager sessionManager;
    private List<OrderData> listData = new ArrayList<>();
    private String nama_user;
    private int id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_form_pembayaran);

        Intent terima = getIntent();
        total_harga = terima.getStringExtra("total_harga");
        harga_pembayaran.setText(total_harga);
        sessionManager = new SessionManager(this);
        nama_user = sessionManager.getUserDetail().get(SessionManager.NAMA);
        id_user = Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.USER_ID));

        rvPay = findViewById(R.id.rv_form_pembayaran);
        rvPay.setLayoutManager(new LinearLayoutManager(FormPembayaranActivity.this));

        pembayaranholder = new ArrayList<>();
        FormPembayaranModel ob1 = new FormPembayaranModel("Ringkasan Pembayaran", "Total Tagihan", "Biaya Layanan", total_harga, "Rp. 0-");
        pembayaranholder.add(ob1);

        rvPay.setAdapter(new FormPembayaranAdapter(pembayaranholder));

        btnBayar = findViewById(R.id.btn_selesai);
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();

            }
        });

    }

    private void order() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Order> OrderData = ardData.ardOrderData(id_user, nama_user);

        OrderData.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                if (kode == 1) {
                    Intent i = new Intent(FormPembayaranActivity.this, SuccessActivity.class);
                    i.putExtra("total_harga", total_harga);
                    startActivity(i);
                } else {
                    Toast.makeText(FormPembayaranActivity.this, pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Intent i = new Intent(FormPembayaranActivity.this, SuccessActivity.class);
                i.putExtra("total_harga", total_harga);
                startActivity(i);
            }
        });


    }
}