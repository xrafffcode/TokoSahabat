package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityDetailUserBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailUserActivity extends AppCompatActivity {

    private int xid;

    private ImageView etGambarItem;
    private String xgambar_item, xkode_item, xbarcode, xnama_item, xjenis_item, xstok_item, xkonversi, xtipe_item, xsatuan, xharga_pokok, xharga_level;
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
        xid = terima.getIntExtra("xid_item", -1);
        xgambar_item = terima.getStringExtra("xgambar_item");
        xnama_item = terima.getStringExtra("xnama_item");
        xstok_item = terima.getStringExtra("xstok_item");
        xharga_pokok = terima.getStringExtra("xharga_pokok");


        etGambarItem = binding.ivGoodDay;
        etNamaItem = binding.tvNameProduk;
        etStokItem = binding.tvPcs;
        etHargaPokok = binding.tvHarga;



        Glide.with(this)
                .load(xgambar_item)
                .into(etGambarItem);

        etNamaItem.setText(xnama_item);
        etStokItem.setText(xstok_item);

        etHargaPokok.setText(formatRupiah(Double.parseDouble(xharga_pokok)));


    }
}