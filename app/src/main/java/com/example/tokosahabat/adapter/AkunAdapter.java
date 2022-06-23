package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.AkunModel;

import java.util.ArrayList;

public class AkunAdapter extends RecyclerView.Adapter<AkunAdapter.myakunviewholder>
{
    ArrayList<AkunModel> akunholder;

    public AkunAdapter(ArrayList<AkunModel> akunholder) {
        this.akunholder = akunholder;
    }

    @NonNull
    @Override
    public myakunviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_akun_user,parent,false);
        return new myakunviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myakunviewholder holder, int position)
    {
        holder.name.setText(akunholder.get(position).getName());
        holder.desc.setText(akunholder.get(position).getDesc());


    }

    @Override
    public int getItemCount() {
        return akunholder.size();
    }

    class myakunviewholder extends RecyclerView.ViewHolder
    {
        TextView name, desc;

        public myakunviewholder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.tv_alamat);
            desc = itemView.findViewById(R.id.tv_isi_alamat);
        }
    }
}
