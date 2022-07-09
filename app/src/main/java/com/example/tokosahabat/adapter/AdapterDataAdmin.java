package com.example.tokosahabat.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.MainActivity;
import com.example.tokosahabat.R;
import com.example.tokosahabat.activity.EditProductActivity;
import com.example.tokosahabat.fragment.HomeFragment;
import com.example.tokosahabat.model.DataModel;
import com.example.tokosahabat.model.ResponseModel;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterDataAdmin extends RecyclerView.Adapter<AdapterDataAdmin.HolderData>{
    private Context ctx;
    private List<DataModel> listProduk;
    private int id_item;

    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    public AdapterDataAdmin(Context ctx, List<DataModel> listProduk) {
        this.ctx = ctx;
        this.listProduk = listProduk;
    }

    @NonNull
    @Override
    public AdapterDataAdmin.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_admin, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listProduk.get(position);

        holder.tvId.setText(String.valueOf(dm.getId_item()));
        holder.tvNamaItem.setText(dm.getNama_item());
        Glide.with(ctx)
                .load(listProduk.get(position).getGambar_item())
                .into(holder.ivItem);
        holder.tvStokItem.setText(dm.getStok_item());
        holder.tvHargaPokok.setText(formatRupiah(Double.parseDouble(dm.getHarga_pokok())));
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId, tvKodeItem, tvBarcode, tvNamaItem, tvStokItem, tvJenisItem, tvKonversi, tvTipeItem, tvSatuan, tvHargaPokok, tvHargaLevel;
        ImageView ivItem;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id_admin);
            tvNamaItem = itemView.findViewById(R.id.tv_name_produk);
            ivItem = itemView.findViewById(R.id.iv_produk);
            tvStokItem = itemView.findViewById(R.id.tv_stok);
            tvHargaPokok = itemView.findViewById(R.id.tv_price);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Aksi yang akan dilakukan");
                    dialogPesan.setTitle("Perhatian");
                    dialogPesan.setCancelable(true);
//                    Handler hand = new Handler();
//                    hand.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            HomeFragment hf = new HomeFragment();
//                            hf.retrieveData();
//                        }
//                    }, 1000);


                    id_item = Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogPesan.setNegativeButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogPesan.show();

                    return false;
                }
            });
        }

        private void deleteData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(id_item);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    Toast.makeText(ctx, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Hapus Data", Toast.LENGTH_SHORT).show();
                }
            });
        }


        private void editData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> editData = ardData.ardEditData(id_item);

            editData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    listProduk = response.body().getData();

                    int varIdItem = listProduk.get(0).getId_item();
                    String gambarItem = listProduk.get(0).getGambar_item();
                    String kodeItem = listProduk.get(0).getKode_item();
                    String barcode = listProduk.get(0).getBarcode();
                    String namaItem = listProduk.get(0).getNama_item();
                    String jenisItem = listProduk.get(0).getJenis_item();
                    String stokItem = listProduk.get(0).getStok_item();
                    String konversi = listProduk.get(0).getKonversi();
                    String tipeItem = listProduk.get(0).getTipe_item();
                    String satuan = listProduk.get(0).getSatuan();
                    String hargaPokok = listProduk.get(0).getHarga_pokok();
                    String hargaLevel = listProduk.get(0).getHarga_level();

                    Intent kirim = new Intent(ctx, EditProductActivity.class);
                    kirim.putExtra("xid_item", varIdItem);
                    kirim.putExtra("xgambar_item", gambarItem);
                    kirim.putExtra("xkode_item", kodeItem);
                    kirim.putExtra("xbarcode", barcode);
                    kirim.putExtra("xnama_item", namaItem);
                    kirim.putExtra("xjenis_item", jenisItem);
                    kirim.putExtra("xstok_item", stokItem);
                    kirim.putExtra("xkonversi", konversi);
                    kirim.putExtra("xtipe_item", tipeItem);
                    kirim.putExtra("xsatuan", satuan);
                    kirim.putExtra("xharga_pokok", hargaPokok);
                    kirim.putExtra("xharga_level", hargaLevel);
                    ctx.startActivity(kirim);

//                    Toast.makeText(ctx, "Kode : "+kode+" | Pesan : "+pesan+ " | Data : "+namaItem+" ", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Edit Data", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
