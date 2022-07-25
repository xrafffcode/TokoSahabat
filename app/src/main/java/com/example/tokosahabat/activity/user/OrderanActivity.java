package com.example.tokosahabat.activity.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.adapter.AdapterDataAdmin;
import com.example.tokosahabat.adapter.AllOrderAdapter;
import com.example.tokosahabat.model.AllOrderModel;
import com.example.tokosahabat.model.DataModel;
import com.example.tokosahabat.model.Order;
import com.example.tokosahabat.model.OrderData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderanActivity extends AppCompatActivity {

    public RecyclerView rvData;
    public RecyclerView.Adapter adData;
    public RecyclerView.LayoutManager lmData;
    public List<OrderData> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);

        rvData = findViewById(R.id.rv_all_order);

        lmData = new LinearLayoutManager(OrderanActivity.this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }

    private void retrieveData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Order> tampilData = ardData.ardRertrieveOderData();

        tampilData.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listData = response.body().getData();


                adData = new AllOrderAdapter(OrderanActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {

            }
        });
    }
}
