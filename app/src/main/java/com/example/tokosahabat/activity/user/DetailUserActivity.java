package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.activity.EditProductActivity;
import com.example.tokosahabat.activity.SignInActivity;
import com.example.tokosahabat.databinding.ActivityDetailUserBinding;
import com.example.tokosahabat.model.ResponseModel;
import com.example.tokosahabat.model.keranjang.Keranjang;

import java.text.NumberFormat;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserActivity extends AppCompatActivity implements View.OnClickListener {

    private int xid;

    private ImageView etGambarItem;
    private AppCompatButton btnAdd;
    SessionManager sessionManager;
    private int user_id, id_item;
    private String gambar_item, xkode_item, xbarcode, nama_item, xjenis_item, stok_item, xkonversi, xtipe_item, xsatuan,harga_pokok, xharga_level;
    private TextView etKodeItem, etBarcode, etNamaItem, etStokItem, etJenisItem, etKonversi, etTipeItem, etSatuan, etHargaPokok, etHargaLevel;
    private String ygambar_item, ykode_item, ybarcode, ynama_item, yjenis_item, ystok_item, ykonversi, ytipe_item, ysatuan, yharga_pokok, yharga_level;
    ActivityDetailUserBinding binding;

    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent terima = getIntent();
        sessionManager = new SessionManager(DetailUserActivity.this);
        user_id = Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.USER_ID));
        id_item = terima.getIntExtra("xid_item", -1);
        gambar_item = terima.getStringExtra("xgambar_item");
        nama_item = terima.getStringExtra("xnama_item");
        stok_item = terima.getStringExtra("xstok_item");
        harga_pokok = terima.getStringExtra("xharga_pokok");


        etGambarItem = binding.ivGoodDay;
        etNamaItem = binding.tvNameProduk;
        etStokItem = binding.tvPcs;
        etHargaPokok = binding.tvHarga;
        btnAdd = binding.btnAddToCart;

        btnAdd.setOnClickListener(this);

        Glide.with(this)
                .load(gambar_item)
                .into(etGambarItem);

        etNamaItem.setText(nama_item);
        etStokItem.setText(stok_item);

        etHargaPokok.setText(formatRupiah(Double.parseDouble(harga_pokok)));


    }

    @Override
    public void onClick(View view) {

        addToCart(user_id, id_item, gambar_item, nama_item, stok_item, harga_pokok);
    }

    private void addToCart(int user_id, int id_item, String gambar_item, String nama_item, String stok_item, String harga_pokok) {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Keranjang> simpanData = ardData.ardKeranjangData(user_id, id_item, gambar_item, nama_item, harga_pokok);
        simpanData.enqueue(new Callback<Keranjang>() {
            @Override
            public void onResponse(Call<Keranjang> call, Response<Keranjang> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(DetailUserActivity.this, pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Keranjang> call, Throwable t) {
                Toast.makeText(DetailUserActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}