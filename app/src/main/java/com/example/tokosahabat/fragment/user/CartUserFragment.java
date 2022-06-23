package com.example.tokosahabat.fragment.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tokosahabat.R;
import com.example.tokosahabat.activity.user.CheckoutUserActivity;
import com.example.tokosahabat.activity.user.FormAlamatActivity;
import com.example.tokosahabat.adapter.MyCartListAdapter;
import com.example.tokosahabat.model.MyCartListModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartUserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<MyCartListModel> cartholder;

    public CartUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartUserFragment newInstance(String param1, String param2) {
        CartUserFragment fragment = new CartUserFragment();
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
        View view = inflater.inflate(R.layout.fragment_cart_user, container, false);
        Button btnCheckout = (Button) view.findViewById(R.id.btn_checkout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheckoutUserActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = view.findViewById(R.id.rv_my_cart_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cartholder = new ArrayList<>();

        MyCartListModel ob1 = new MyCartListModel(R.drawable.img_produk, "Good Day Mocha", "Rp. 10,850,-");
        cartholder.add(ob1);

        MyCartListModel ob2 = new MyCartListModel(R.drawable.img_produk, "French Fries", "Rp. 3,250,-");
        cartholder.add(ob2);


        recyclerView.setAdapter(new MyCartListAdapter(cartholder));

        return view;
    }
}