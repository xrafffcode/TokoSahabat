package com.example.tokosahabat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tokosahabat.R;
import com.example.tokosahabat.model.DataModel;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterDataAdmin extends RecyclerView.Adapter<AdapterDataAdmin.HolderData>{
    private Context ctx;
    private List<DataModel> listProduk;

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
        }
    }
}
