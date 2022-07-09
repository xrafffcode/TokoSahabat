package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.databinding.ActivityEditProductBinding;
import com.example.tokosahabat.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProductActivity extends AppCompatActivity {

    private int xid;
    private AppCompatButton btnUpdate;
    private String xgambar_item, xkode_item, xbarcode, xnama_item, xjenis_item, xstok_item, xkonversi, xtipe_item, xsatuan, xharga_pokok, xharga_level;
    private EditText etGambarItem, etKodeItem, etBarcode, etNamaItem, etStokItem, etJenisItem, etKonversi, etTipeItem, etSatuan, etHargaPokok, etHargaLevel;
    private String ygambar_item, ykode_item, ybarcode, ynama_item, yjenis_item, ystok_item, ykonversi, ytipe_item, ysatuan, yharga_pokok, yharga_level;
    ActivityEditProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent terima = getIntent();
        xid = terima.getIntExtra("xid_item", -1);
        xgambar_item = terima.getStringExtra("xgambar_item");
        xkode_item = terima.getStringExtra("xkode_item");
        xbarcode = terima.getStringExtra("xbarcode");
        xnama_item = terima.getStringExtra("xnama_item");
        xjenis_item = terima.getStringExtra("xjenis_item");
        xstok_item = terima.getStringExtra("xstok_item");
        xkonversi = terima.getStringExtra("xkonversi");
        xtipe_item = terima.getStringExtra("xtipe_item");
        xsatuan = terima.getStringExtra("xsatuan");
        xharga_pokok = terima.getStringExtra("xharga_pokok");
        xharga_level = terima.getStringExtra("xharga_level");

        etGambarItem = binding.edtGambarItem;
        etKodeItem = binding.edtKodeItem;
        etBarcode = binding.edtBarcode;
        etNamaItem = binding.edtNamaItem;
        etStokItem = binding.edtStok;
        etJenisItem = binding.edtJenisItem;
        etKonversi = binding.edtKonversi;
        etTipeItem = binding.edtTipeItem;
        etSatuan = binding.edtSatuan;
        etHargaPokok = binding.edtHargaPokok;
        etHargaLevel = binding.edtHargaLevel;
        btnUpdate = binding.btnEditProduk;

        etGambarItem.setText(xgambar_item);
        etKodeItem.setText(xkode_item);
        etBarcode.setText(xbarcode);
        etNamaItem.setText(xnama_item);
        etStokItem.setText(xstok_item);
        etJenisItem.setText(xjenis_item);
        etKonversi.setText(xkonversi);
        etTipeItem.setText(xtipe_item);
        etSatuan.setText(xsatuan);
        etHargaPokok.setText(xharga_pokok);
        etHargaLevel.setText(xharga_level);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ygambar_item = etGambarItem.getText().toString();
                ykode_item = etKodeItem.getText().toString();
                ybarcode = etBarcode.getText().toString();
                ynama_item = etNamaItem.getText().toString();
                ystok_item = etStokItem.getText().toString();
                yjenis_item = etJenisItem.getText().toString();
                ykonversi = etKonversi.getText().toString();
                ytipe_item = etTipeItem.getText().toString();
                ysatuan = etSatuan.getText().toString();
                yharga_pokok = etHargaPokok.getText().toString();
                yharga_level = etHargaLevel.getText().toString();
                updateData();
            }
        });
    }

    private void updateData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> ubahData = ardData.ardUpdateData(xid, ygambar_item, ykode_item, ybarcode, ynama_item,  ystok_item, yjenis_item, ykonversi, ytipe_item, ysatuan, yharga_pokok, yharga_level);

        ubahData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(EditProductActivity.this, "Kode : "+kode+"Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(EditProductActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}