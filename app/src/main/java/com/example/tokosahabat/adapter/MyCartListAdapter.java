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
import com.example.tokosahabat.model.MyCartListModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartListAdapter extends RecyclerView.Adapter<MyCartListAdapter.mycartviewholder> {
    private Context ctx;
    private List<MyCartListModel> listProduk;
    private int id_user;

    public MyCartListAdapter(Context ctx, List<MyCartListModel> listProduk) {
        this.ctx = ctx;
        this.listProduk = listProduk;
    }

    @NonNull
    @Override
    public mycartviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_detail_order_admin, parent, false);
        mycartviewholder holder = new mycartviewholder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull mycartviewholder holder, int position) {
        MyCartListModel dm = listProduk.get(position);

        holder.name.setText(dm.getNama_item());
        holder.price.setText(dm.getHarga_pokok());
        Glide.with(ctx)
                .load(listProduk.get(position).getGambar_item())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    class mycartviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name, price;

        public mycartviewholder(@NonNull View itemView)
        {
            super(itemView);
            img =itemView.findViewById(R.id.iv_produk);
            name =itemView.findViewById(R.id.tv_name_produk);
            price =itemView.findViewById(R.id.tv_price);
        }
    }
}
