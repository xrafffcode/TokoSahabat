package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.adapter.AdapterData;
import com.example.tokosahabat.adapter.MyCartListAdapter;
import com.example.tokosahabat.model.Cart;
import com.example.tokosahabat.model.MyCartListModel;
import com.example.tokosahabat.model.price.Price;
import com.example.tokosahabat.model.price.PriceData;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private int id_item;
    private int id_user;
    private AppCompatButton btnCheckout;
    private List<MyCartListModel> listProduk = new ArrayList<>();
    private List<PriceData> listPrice = new ArrayList<>();
    private TextView subtotal, total;
    private String total_harga;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        rvData = findViewById(R.id.rv_my_cart_list);
        subtotal = findViewById(R.id.tv_rp_subtotal);
        total = findViewById(R.id.tv_rp_total);
        btnCheckout = findViewById(R.id.btn_checkout);
        lmData=  new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false);
        btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutUserActivity.class);
            intent.putExtra("total_harga", total_harga);
            startActivity(intent);
        });

        Intent terima = getIntent();
        listProduk = (List<MyCartListModel>) terima.getSerializableExtra("listProduk");
        id_user = terima.getIntExtra("id_user", 0);
        rvData.setLayoutManager(lmData);

        adData = new MyCartListAdapter(CartActivity.this, listProduk );
        rvData.setAdapter(adData);
        adData.notifyDataSetChanged();

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

    public void getTotalPrice() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Price> tampilHarga = ardData.ardTotalPrice(id_user);

        tampilHarga.enqueue(new Callback<Price>() {
            @Override
            public void onResponse(Call<Price> call, Response<Price> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listPrice = response.body().getData();
                total_harga = formatRupiah(Double.parseDouble(listPrice.get(0).getTotalHarga()));
                subtotal.setText(total_harga);
                total.setText(total_harga);
            }

            @Override
            public void onFailure(Call<Price> call, Throwable t) {
                Toast.makeText(CartActivity.this, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }


}