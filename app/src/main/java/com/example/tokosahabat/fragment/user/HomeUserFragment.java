package com.example.tokosahabat.fragment.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.activity.SearchActivity;
import com.example.tokosahabat.activity.user.CartActivity;
import com.example.tokosahabat.adapter.AdapterData;
import com.example.tokosahabat.model.Cart;
import com.example.tokosahabat.model.DataModel;
import com.example.tokosahabat.model.MyCartListModel;
import com.example.tokosahabat.model.ResponseModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeUserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //recyclerview
    private RecyclerView rvData, rvCart;
    public RecyclerView.Adapter adData, adCart;
    public RecyclerView.LayoutManager lmData, lmCart;
    private List<DataModel> listData = new ArrayList<>();
    private ProgressBar pbData;
    private SearchView svData;
    private ImageButton btnCart;
    private ImageView ivKosong;
    private String nama_item;
    private int id_user;
    private List<MyCartListModel> listProduk = new ArrayList<>();
    SessionManager sessionManager;


    public HomeUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeUserFragment newInstance(String param1, String param2) {
        HomeUserFragment fragment = new HomeUserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_user, container, false);

        rvData = view.findViewById(R.id.recyclerView_User);
        pbData = view.findViewById(R.id.pb_data);

        btnCart = view.findViewById(R.id.btn_cart);
        ivKosong = view.findViewById(R.id.iv_kosong);
        svData = view.findViewById(R.id.search_product_user);
        rvCart = view.findViewById(R.id.rv_my_cart_list);

        svData.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                nama_item = query;
                searchData();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartData();
            }
        });

        lmData = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);retrieveData();

//        SetupSearchView();

        return view;
    }

    private void searchData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> SearchData = ardData.ardCariProdukData(nama_item);

        SearchData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listData = response.body().getData();
                if (kode == 1) {
                    Intent cari = new Intent(getActivity(), SearchActivity.class);
                    cari.putExtra("listData", (Serializable) listData);
                    startActivity(cari);
                } else {
                    Toast.makeText(getActivity(), pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cartData() {
        sessionManager = new SessionManager(getActivity());
        id_user = Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.USER_ID));
        openCart();
    }

    public void openCart() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Cart> tampilData = ardData.ardRertrieveKeranjangData(id_user);

        tampilData.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listProduk = response.body().getData();
                if (kode == 1) {
                    Intent intent = new Intent(getActivity(), CartActivity.class);
                    intent.putExtra("listProduk", (Serializable) listProduk);
                    intent.putExtra("id_user", id_user);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void SetupSearchView() {
//        final SearchView searchView = svData;
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData(){
        pbData.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRertrieveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                listData = response.body().getData();

                if (kode == 1) {
                    adData = new AdapterData(getContext(), listData);
                    rvData.setAdapter(adData);
                    adData.notifyDataSetChanged();

                    pbData.setVisibility(View.INVISIBLE);
                } else {
                    ivKosong.setVisibility(View.VISIBLE);
                    pbData.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal Tehubung Dengan Serve : "+t.getMessage(), Toast.LENGTH_SHORT).show();

                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }

}