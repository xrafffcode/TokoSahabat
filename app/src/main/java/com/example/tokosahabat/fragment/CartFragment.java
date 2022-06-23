package com.example.tokosahabat.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tokosahabat.R;
import com.example.tokosahabat.adapter.AllOrderAdapter;
import com.example.tokosahabat.adapter.DashboardAdminAdapter;
import com.example.tokosahabat.model.AllOrderModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<AllOrderModel> orderholder;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
       View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.rv_all_order);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderholder = new ArrayList<>();

        AllOrderModel ob1 = new AllOrderModel(R.drawable.ic_btn_delivered, "331100", "Indah", "07.00");
        orderholder.add(ob1);

        AllOrderModel ob2 = new AllOrderModel(R.drawable.ic_btn_delivered, "332010", "Cahyani", "10.00");
        orderholder.add(ob2);

        AllOrderModel ob3 = new AllOrderModel(R.drawable.ic_btn_delivered, "334214", "Musyafa", "13.000");
        orderholder.add(ob3);

        AllOrderModel ob4 = new AllOrderModel(R.drawable.ic_btn_delivered, "3331211", "Fadila", "17.15");
        orderholder.add(ob4);

        recyclerView.setAdapter(new AllOrderAdapter(orderholder));

        return view;
    }
}