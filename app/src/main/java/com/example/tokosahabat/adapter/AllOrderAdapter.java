package com.example.tokosahabat.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.activity.DetailOrderAdminActivity;
import com.example.tokosahabat.activity.user.CartActivity;
import com.example.tokosahabat.model.Cart;
import com.example.tokosahabat.model.MyCartListModel;
import com.example.tokosahabat.model.Order;
import com.example.tokosahabat.model.OrderData;
import com.example.tokosahabat.model.ResponseModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllOrderAdapter extends RecyclerView.Adapter<AllOrderAdapter.orderholder>{
    private Context ctx;
    private List<OrderData> listProduk;
    private List<MyCartListModel> listOrder = new ArrayList<>();
    private int id_transaksi, id_user;
    private String nama;


    public AllOrderAdapter(Context ctx, List<OrderData> listProduk) {
        this.ctx = ctx;
        this.listProduk = listProduk;
    }

    @NonNull
    @Override
    public orderholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_list_order_admin, parent, false);
        orderholder holder = new orderholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull orderholder holder, int position) {
        OrderData dm = listProduk.get(position);
        holder.id_u.setText(String.valueOf(dm.getId_user()));
        holder.img.setText(dm.getDelivered());
        holder.id.setText(String.valueOf(dm.getId_transaksi()));
        holder.name.setText(dm.getNamaUser());
        holder.waktu.setText(dm.getWaktuOrder());
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    class orderholder extends RecyclerView.ViewHolder
    {
        TextView id, name, waktu, img, id_u;

        public orderholder(@NonNull View itemView) {
            super(itemView);
            id_u = itemView.findViewById(R.id.tv_id_user_order);
            img = itemView.findViewById(R.id.ib_delivered);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name_user);
            waktu = itemView.findViewById(R.id.tv_waktu);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    id_user = Integer.parseInt(id_u.getText().toString());
                    nama = name.getText().toString();
                    id_transaksi = Integer.parseInt(id.getText().toString());
                    detailOrder();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Aksi yang akan dilakukan");
                    dialogPesan.setTitle("Perhatian");
                    dialogPesan.setCancelable(true);

                    dialogPesan.setPositiveButton("Approve", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            approve();
                            dialogInterface.dismiss();
                        }
                    });
                    dialogPesan.show();
                    id_transaksi = Integer.parseInt(id.getText().toString());
                    id_user = Integer.parseInt(id_u.getText().toString());

                    return false;
                }
            });
        }
    }

    private void detailOrder() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Cart> tampilData = ardData.ardDataOrder(id_user);

        tampilData.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listOrder = response.body().getData();
                if (kode == 1) {
                    Intent intent = new Intent(ctx, DetailOrderAdminActivity.class);
                    intent.putExtra("listOrder", (Serializable) listOrder);
                    intent.putExtra("id_user", id_user);
                    intent.putExtra("nama", nama);
                    intent.putExtra("id_transaksi", id_transaksi);
                    ctx.startActivity(intent);
                } else {
                    Toast.makeText(ctx, pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });


    }

    private void approve() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Order> approveData = ardData.ardApproveData(id_transaksi, id_user);

        approveData.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                Toast.makeText(ctx, pesan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Toast.makeText(ctx, "Gagal Approve Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
