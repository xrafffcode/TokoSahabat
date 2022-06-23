package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.FormPembayaranModel;

import java.util.ArrayList;

public class FormPembayaranAdapter extends RecyclerView.Adapter<FormPembayaranAdapter.pembayaranviewholder>
{
    ArrayList<FormPembayaranModel> pembayaranholder;

    public FormPembayaranAdapter(ArrayList<FormPembayaranModel> pembayaranholder) {
        this.pembayaranholder = pembayaranholder;
    }

    @NonNull
    @Override
    public pembayaranviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_ringkasan_pembayaran,parent,false);
        return new pembayaranviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pembayaranviewholder holder, int position)
    {
        holder.rgks.setText(pembayaranholder.get(position).getRgks());
        holder.tota.setText(pembayaranholder.get(position).getTota());
        holder.bila.setText(pembayaranholder.get(position).getBila());
        holder.rptota.setText(pembayaranholder.get(position).getRptota());
        holder.rpbila.setText(pembayaranholder.get(position).getRpbila());

    }

    @Override
    public int getItemCount() {
        return pembayaranholder.size();
    }

    class pembayaranviewholder extends RecyclerView.ViewHolder
    {
        TextView rgks, tota, bila, rptota, rpbila;

        public pembayaranviewholder(@NonNull View itemView)
        {
            super(itemView);
            rgks=itemView.findViewById(R.id.tv_ringkasan_pembayaran);
            tota=itemView.findViewById(R.id.tv_total_tagihan);
            bila=itemView.findViewById(R.id.tv_biaya_layanan);
            rptota=itemView.findViewById(R.id.tv_total);
            rpbila=itemView.findViewById(R.id.tv_biaya);
        }
    }
}
