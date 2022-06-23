package com.example.tokosahabat.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.AllOrderModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AllOrderAdapter extends RecyclerView.Adapter<AllOrderAdapter.orderholder>{

    ArrayList<AllOrderModel> orderhordel;

    public AllOrderAdapter(ArrayList<AllOrderModel> orderhordel) {
        this.orderhordel = orderhordel;
    }

    @NonNull
    @Override
    public orderholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_list_order_admin, parent, false);
        return new orderholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderholder holder, int position) {
        holder.img.setImageResource(orderhordel.get(position).getImage());
        holder.id.setText(orderhordel.get(position).getId());
        holder.name.setText(orderhordel.get(position).getName());
        holder.waktu.setText(orderhordel.get(position).getWaktu());
    }

    @Override
    public int getItemCount() {
        return orderhordel.size();
    }

    class orderholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView id, name, waktu;

        public orderholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ib_delivered);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name_user);
            waktu = itemView.findViewById(R.id.tv_waktu);
        }
    }
}
