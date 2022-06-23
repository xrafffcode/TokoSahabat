package com.example.tokosahabat.fragment.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tokosahabat.R;
import com.example.tokosahabat.adapter.AkunAdapter;
import com.example.tokosahabat.model.AkunModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileUserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<AkunModel> akunholder;

    public ProfileUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileUserFragment newInstance(String param1, String param2) {
        ProfileUserFragment fragment = new ProfileUserFragment();
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
        View view =  inflater.inflate(R.layout.fragment_profile_user, container, false);
        recyclerView = view.findViewById(R.id.rv_akun);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        akunholder = new ArrayList<>();

        AkunModel ob1 = new AkunModel("Alamat", "Perum Abdi Negara D1/27, Padamara, Kab. Purbalingga, Jawa Tengah");
        akunholder.add(ob1);

        AkunModel ob2 = new AkunModel("Nomor Telepon", "081123456789");
        akunholder.add(ob2);

        AkunModel ob3 = new AkunModel("Keamanan Akun", "Kata Sandi");
        akunholder.add(ob3);

        recyclerView.setAdapter(new AkunAdapter(akunholder));

        return view;
    }
}