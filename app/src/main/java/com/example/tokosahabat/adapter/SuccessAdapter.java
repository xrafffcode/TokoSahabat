package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.SuccessModel;

import java.util.ArrayList;

public class SuccessAdapter extends RecyclerView.Adapter<SuccessAdapter.successviewholder>{

    ArrayList<SuccessModel> successholder;

    public SuccessAdapter(ArrayList<SuccessModel> successholder) {
        this.successholder = successholder;
    }

    @NonNull
    @Override
    public successviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_success, parent, false);
        return new successviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull successviewholder holder, int position) {
        holder.cod.setText(successholder.get(position).getCod());
        holder.harga.setText(successholder.get(position).getHarga());

    }

    @Override
    public int getItemCount() {
        return successholder.size();
    }

    class successviewholder extends RecyclerView.ViewHolder
    {
        TextView cod, harga;

        public successviewholder(@NonNull View itemView)
        {
            super(itemView);
            cod=itemView.findViewById(R.id.tv_cod_success);
            harga=itemView.findViewById(R.id.tv_harga_success);
        }
    }
}
