package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityAddDataAdminBinding;
import com.example.tokosahabat.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDataAdminActivity extends AppCompatActivity {
    private EditText etGambarItem, etKodeItem, etBarcode, etNamaItem, etStokItem, etJenisItem, etKonversi, etTipeItem, etSatuan, etHargaPokok, etHargaLevel;
    private AppCompatButton btnSimpan;
    private String gambar_item, kode_item, barcode, nama_item, stok_item, jenis_item, konversi, tipe_item, satuan, harga_pokok, harga_level;

    ActivityAddDataAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDataAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        etGambarItem = findViewById(R.id.edt_gambar_item);
        etKodeItem = findViewById(R.id.edt_kode_item);
        etBarcode = findViewById(R.id.edt_barcode);
        etNamaItem = findViewById(R.id.edt_nama_item);
        etStokItem = findViewById(R.id.edt_stok_item);
        etJenisItem = findViewById(R.id.edt_jenis);
        etKonversi = findViewById(R.id.edt_konversi);
        etTipeItem = findViewById(R.id.edt_tipe_item);
        etSatuan = findViewById(R.id.edt_satuan);
        etHargaPokok = findViewById(R.id.edt_harga_pokok);
        etHargaLevel = findViewById(R.id.edt_harga_level);
        btnSimpan = findViewById(R.id.btn_add_produk);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gambar_item = etGambarItem.getText().toString();
                kode_item = etKodeItem.getText().toString();
                barcode = etBarcode.getText().toString();
                nama_item = etNamaItem.getText().toString();
                stok_item = etStokItem.getText().toString();
                jenis_item = etJenisItem.getText().toString();
                konversi = etKonversi.getText().toString();
                tipe_item = etTipeItem.getText().toString();
                satuan = etSatuan.getText().toString();
                harga_pokok = etHargaPokok.getText().toString();
                harga_level = etHargaLevel.getText().toString();

                if(gambar_item.trim().equals("")){
                    etGambarItem.setError("Gambar Item tidak boleh kosong");
                }else if(kode_item.trim().equals("")) {
                    etKodeItem.setError("Kode Item tidak boleh kosong");
                }else if(barcode.trim().equals("")) {
                    etBarcode.setError("Barcode tidak boleh kosong");
                }else if(nama_item.trim().equals("")) {
                    etNamaItem.setError("Nama Item tidak boleh kosong");
                }else if(stok_item.trim().equals("")) {
                    etStokItem.setError("Stok Item tidak boleh kosong");
                }else if(jenis_item.trim().equals("")) {
                    etJenisItem.setError("Jenis Item tidak boleh kosong");
                }else if(konversi.trim().equals("")) {
                    etKonversi.setError("Konversi tidak boleh kosong");
                }else if(tipe_item.trim().equals("")) {
                    etTipeItem.setError("Tipe Item tidak boleh kosong");
                }else if(satuan.trim().equals("")) {
                    etSatuan.setError("Satuan tidak boleh kosong");
                }else if(harga_pokok.trim().equals("")) {
                    etHargaPokok.setError("Harga Pokok tidak boleh kosong");
                }else if(harga_level.trim().equals("")) {
                    etHargaLevel.setError("Harga Level tidak boleh kosong");
                }else{
                    createData();
                }
            }
        });
    }

    private void createData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(gambar_item, kode_item, barcode, nama_item, stok_item, jenis_item, konversi, tipe_item, satuan, harga_pokok, harga_level);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(AddDataAdminActivity.this, "Kode : "+kode+"Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(AddDataAdminActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}