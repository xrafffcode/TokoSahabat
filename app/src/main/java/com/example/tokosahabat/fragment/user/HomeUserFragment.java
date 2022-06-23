package com.example.tokosahabat.fragment.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tokosahabat.R;
import com.example.tokosahabat.adapter.DashboardUserAdapter;
import com.example.tokosahabat.model.DashboardUserModel;

import java.util.ArrayList;

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
    RecyclerView recyclerView;
    ArrayList<DashboardUserModel> dasboarduserholder;

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
        recyclerView = view.findViewById(R.id.recyclerView_User);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dasboarduserholder = new ArrayList<>();

        DashboardUserModel ob1 = new DashboardUserModel(R.drawable.img_produk, "Aice Choco Melt", "Stock 4 pcs", "Rp. 4,000,-");
        dasboarduserholder.add(ob1);

        DashboardUserModel ob2 = new DashboardUserModel(R.drawable.img_produk, "Good Day", "Stock 5 pcs", "Rp. 5,000,-");
        dasboarduserholder.add(ob2);

        DashboardUserModel ob3 = new DashboardUserModel(R.drawable.img_produk, "Aice Choco Melt", "Stock 4 pcs", "Rp. 4,000,-");
        dasboarduserholder.add(ob3);

        DashboardUserModel ob4 = new DashboardUserModel(R.drawable.img_produk, "Good Day", "Stock 6 pcs", "Rp. 5,000,-");
        dasboarduserholder.add(ob4);

        DashboardUserModel ob5 = new DashboardUserModel(R.drawable.img_produk, "Aice Choco Melt", "Stock 4 pcs", "Rp. 4,000,-");
        dasboarduserholder.add(ob5);


        recyclerView.setAdapter(new DashboardUserAdapter(dasboarduserholder));

        return view;
    }
}