package com.example.tokosahabat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.model.FormAlamatModel;

import java.util.ArrayList;

public class FormAlamatAdapter extends RecyclerView.Adapter<FormAlamatAdapter.formviewholder>
{
    ArrayList<FormAlamatModel> formholder;

    public FormAlamatAdapter(ArrayList<FormAlamatModel> formholder) {
        this.formholder = formholder;
    }

    @NonNull
    @Override
    public formviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_akun_user,parent, false);
        return new formviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull formviewholder holder, int position)
    {
        holder.name.setText(formholder.get(position).getName());
        holder.desc.setText(formholder.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return formholder.size();
    }

    class formviewholder extends RecyclerView.ViewHolder
    {
        TextView name, desc;

        public formviewholder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.tv_alamat);
            desc=itemView.findViewById(R.id.tv_isi_alamat);
        }
    }
}
