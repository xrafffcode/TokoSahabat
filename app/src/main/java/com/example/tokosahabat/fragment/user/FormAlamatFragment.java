package com.example.tokosahabat.fragment.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tokosahabat.R;
import com.example.tokosahabat.activity.user.FormPembayaranActivity;
import com.example.tokosahabat.adapter.FormAlamatAdapter;
import com.example.tokosahabat.model.FormAlamatModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormAlamatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormAlamatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<FormAlamatModel> formholder;

    public FormAlamatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormAlamatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormAlamatFragment newInstance(String param1, String param2) {
        FormAlamatFragment fragment = new FormAlamatFragment();
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
        View view = inflater.inflate(R.layout.fragment_form_alamat, container, false);
        Button btnSimpan = (Button) view.findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FormPembayaranActivity.class);
                startActivity(intent);
            }
        });

        recyclerView= view.findViewById(R.id.rv_form_alamat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        formholder = new ArrayList<>();

        FormAlamatModel ob1 = new FormAlamatModel("Nama Penerima", "Deni Fitriani");
        formholder.add(ob1);

        FormAlamatModel ob2 = new FormAlamatModel("Alamat", "Perum Abdi Negara D1/27, Padamara, Kab. Purbalingga, Jawa Tengah");
        formholder.add(ob2);

        FormAlamatModel ob3 = new FormAlamatModel("Kode Pos", "53372");
        formholder.add(ob3);

        FormAlamatModel ob4 = new FormAlamatModel("Nomor Telepon Penerima", "081123456789");
        formholder.add(ob4);

        recyclerView.setAdapter(new FormAlamatAdapter(formholder));

        return view;
    }
}