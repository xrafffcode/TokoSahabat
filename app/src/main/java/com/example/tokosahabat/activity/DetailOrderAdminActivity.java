package com.example.tokosahabat.activity;

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
import com.example.tokosahabat.adapter.MyCartListAdapter;
import com.example.tokosahabat.databinding.ActivityDetailOrderAdminBinding;
import com.example.tokosahabat.model.MyCartListModel;
import com.example.tokosahabat.model.Order;
import com.example.tokosahabat.model.price.Price;
import com.example.tokosahabat.model.price.PriceData;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailOrderAdminActivity extends AppCompatActivity {

    ActivityDetailOrderAdminBinding binding;
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private int id_item;
    private int id_user, id_transaksi;
    private AppCompatButton btnApprove;
    private List<MyCartListModel> listOrder = new ArrayList<>();
    private TextView subtotal;
    private TextView total_price;
    private TextView nama_pemesan;
    private String nama;
    private String total_harga;
    private List<PriceData> listPrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailOrderAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        rvData = binding.rvDetailProduk;
        total_price = binding.tvBayar;
        nama_pemesan = binding.tvNameCheckout;
        btnApprove = binding.btnAccept;



        Intent terima = getIntent();
        id_user = terima.getIntExtra("id_user", 0);
        nama = terima.getStringExtra("nama");
        id_transaksi = terima.getIntExtra("id_transaksi", 0);
        nama_pemesan.setText(nama);
        lmData=  new LinearLayoutManager(DetailOrderAdminActivity.this, LinearLayoutManager.VERTICAL, false);
        listOrder = (List<MyCartListModel>) terima.getSerializableExtra("listOrder");
        rvData.setLayoutManager(lmData);

        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                approve();
                id_transaksi = id_transaksi;
                id_user = id_user;
            }
        });

        adData = new MyCartListAdapter(DetailOrderAdminActivity.this, listOrder );
        rvData.setAdapter(adData);
        adData.notifyDataSetChanged();
    }

    private void approve() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Order> approveData = ardData.ardApproveData(id_transaksi, id_user);

        approveData.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                Toast.makeText(DetailOrderAdminActivity.this, pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Toast.makeText(DetailOrderAdminActivity.this, "Gagal Approve Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTotalPrice();
    }
    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    private void getTotalPrice() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Price> tampilHarga = ardData.ardTotalOrderPrice(id_user);

        tampilHarga.enqueue(new Callback<Price>() {
            @Override
            public void onResponse(Call<Price> call, Response<Price> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listPrice = response.body().getData();
                total_harga = formatRupiah(Double.parseDouble(listPrice.get(0).getTotalHarga()));
                total_price.setText(total_harga);
            }

            @Override
            public void onFailure(Call<Price> call, Throwable t) {
                Toast.makeText(DetailOrderAdminActivity.this, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}