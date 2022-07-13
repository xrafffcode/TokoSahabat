package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.adapter.SuccessAdapter;
import com.example.tokosahabat.databinding.ActivitySuccessBinding;
import com.example.tokosahabat.fragment.user.FormSuccessFragment;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;
import com.example.tokosahabat.model.Cart;
import com.example.tokosahabat.model.SuccessModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuccessActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SuccessModel> successholder;
    AppCompatButton btnDone;
    int id_user;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.fragment_form_success);
       Intent terima = getIntent();
         String total_harga = terima.getStringExtra("total_harga");

        recyclerView = findViewById(R.id.rv_cod);
        recyclerView.setLayoutManager(new LinearLayoutManager(SuccessActivity.this));

        successholder = new ArrayList<>();

        SuccessModel ob1 = new SuccessModel("COD (Bayar di Tempat)", total_harga);
        successholder.add(ob1);

        recyclerView.setAdapter(new SuccessAdapter(successholder));

        sessionManager = new SessionManager(this);
        id_user = Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.USER_ID));

        btnDone = findViewById(R.id.btn_selesai);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Selesai();
            }
        });

    }

    private void Selesai() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Cart> coData = ardData.ardCheckoutData(id_user);

        coData.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                if (kode == 1) {
                    Intent selesai = new Intent(SuccessActivity.this, DashboardUserActivity.class);
                    startActivity(selesai);
                } else {
                    Toast.makeText(SuccessActivity.this, pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });
    }
}