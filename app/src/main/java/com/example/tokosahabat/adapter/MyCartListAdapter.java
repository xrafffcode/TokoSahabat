package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.MyCartListModel;

import java.util.ArrayList;

public class MyCartListAdapter extends RecyclerView.Adapter<MyCartListAdapter.mycartviewholder>
{
    ArrayList<MyCartListModel> cartholder;

    public MyCartListAdapter(ArrayList<MyCartListModel> cartholder) {
        this.cartholder = cartholder;
    }

    @NonNull
    @Override
    public mycartviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_detail_order_admin,parent,false);
        return new mycartviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mycartviewholder holder, int position)
    {
        holder.img.setImageResource(cartholder.get(position).getImage());
        holder.name.setText(cartholder.get(position).getName());
        holder.price.setText(cartholder.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return cartholder.size();
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
