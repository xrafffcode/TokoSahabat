package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.DashboardUserModel;

import java.util.ArrayList;

public class DashboardUserAdapter extends RecyclerView.Adapter<DashboardUserAdapter.myviewholder> {

    ArrayList<DashboardUserModel> dasboarduserholder;

    public DashboardUserAdapter(ArrayList<DashboardUserModel> dasboarduserholder) {
        this.dasboarduserholder = dasboarduserholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_user, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.img.setImageResource(dasboarduserholder.get(position).getImage());
        holder.name.setText(dasboarduserholder.get(position).getName());
        holder.stock.setText(dasboarduserholder.get(position).getStock());
        holder.price.setText(dasboarduserholder.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return dasboarduserholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name, stock, price;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.iv_produk_user);
            name = itemView.findViewById(R.id.tv_name_produk_user);
            stock = itemView.findViewById(R.id.tv_stok_user);
            price = itemView.findViewById(R.id.tv_price_user);
        }
    }
}
