package com.example.tokosahabat.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tokosahabat.R;
import com.example.tokosahabat.activity.AddDataAdminActivity;
import com.example.tokosahabat.adapter.DashboardAdminAdapter;
import com.example.tokosahabat.adapter.DashboardUserAdapter;
import com.example.tokosahabat.model.DashboardAdminModel;
import com.example.tokosahabat.model.DashboardUserModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<DashboardAdminModel> dashboardadminholder;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton btnAdd = (ImageButton) view.findViewById(R.id.btn_add_product);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AddDataAdminActivity.class);
                startActivity(intent);
            }
        });



        recyclerView = view.findViewById(R.id.recyclerView_Admin);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dashboardadminholder = new ArrayList<>();

        DashboardAdminModel ob1 = new DashboardAdminModel(R.drawable.img_produk, "Aice Choco Melt", "Stock 4 pcs", "Rp. 4,000,-", "delete");
        dashboardadminholder.add(ob1);

        DashboardAdminModel ob2 = new DashboardAdminModel(R.drawable.img_produk, "Good Day", "Stock 5 pcs", "Rp. 5,000,-", "delete");
        dashboardadminholder.add(ob2);

        DashboardAdminModel ob3 = new DashboardAdminModel(R.drawable.img_produk, "Aice Choco Melt", "Stock 4 pcs", "Rp. 4,000,-", "delete");
        dashboardadminholder.add(ob3);

        DashboardAdminModel ob4 = new DashboardAdminModel(R.drawable.img_produk, "Good Day", "Stock 6 pcs", "Rp. 5,000,-", "delete");
        dashboardadminholder.add(ob4);


        recyclerView.setAdapter(new DashboardAdminAdapter(dashboardadminholder));

        return view;
    }
}