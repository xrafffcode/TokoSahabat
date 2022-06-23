package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.DashboardAdminModel;

import java.util.ArrayList;

public class DashboardAdminAdapter extends RecyclerView.Adapter<DashboardAdminAdapter.adminviewholder> {

    ArrayList<DashboardAdminModel> adminholder;

    public DashboardAdminAdapter(ArrayList<DashboardAdminModel> adminholder) {
        this.adminholder = adminholder;
    }

    @NonNull
    @Override
    public adminviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_admin, parent, false);
        return new adminviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adminviewholder holder, int position)
    {
        holder.img.setImageResource(adminholder.get(position).getImage());
        holder.name.setText(adminholder.get(position).getName());
        holder.stock.setText(adminholder.get(position).getStock());
        holder.price.setText(adminholder.get(position).getPrice());
        holder.delete.setText(adminholder.get(position).getDelete());

    }

    @Override
    public int getItemCount() {
        return adminholder.size();
    }

    class adminviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name, stock, price, delete;

        public adminviewholder(@NonNull View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.iv_produk);
            name = itemView.findViewById(R.id.tv_name_produk);
            stock = itemView.findViewById(R.id.tv_stok);
            price = itemView.findViewById(R.id.tv_price);
            delete = itemView.findViewById(R.id.tv_delete);
        }
    }
}
