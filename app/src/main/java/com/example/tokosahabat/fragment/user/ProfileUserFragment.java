package com.example.tokosahabat.fragment.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.activity.SignInActivity;
import com.example.tokosahabat.adapter.AkunAdapter;
import com.example.tokosahabat.databinding.ActivityDashboardUserBinding;
import com.example.tokosahabat.model.AkunModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileUserFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<AkunModel> akunholder;
    SessionManager sessionManager;
    TextView etEmail, btnLogout, etNama, etTelepon;
    String email, telepon, nama;

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
        sessionManager = new SessionManager(getActivity());
        etEmail = view.findViewById(R.id.tv_gmail_user);
        etNama = view.findViewById(R.id.tv_nama_profile);
        etTelepon = view.findViewById(R.id.tv_no_telepon);
        email = sessionManager.getUserDetail().get(SessionManager.EMAIL);
        telepon = sessionManager.getUserDetail().get(SessionManager.TELEPON);
        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        etEmail.setText(email);
        etNama.setText(nama);
        etTelepon.setText(telepon);

        btnLogout = view.findViewById(R.id.tv_logout_user);
        btnLogout.setOnClickListener(this);

        AkunModel ob1 = new AkunModel("Alamat", "Perum Abdi Negara D1/27, Padamara, Kab. Purbalingga, Jawa Tengah");
        akunholder.add(ob1);

        AkunModel ob2 = new AkunModel("Nomor Telepon", telepon);
        akunholder.add(ob2);

        AkunModel ob3 = new AkunModel("Keamanan Akun", "Kata Sandi");
        akunholder.add(ob3);

        recyclerView.setAdapter(new AkunAdapter(akunholder));

        return view;
    }

    @Override
    public void onClick(View view) {
        sessionManager.logoutSession();
        moveToLogin();
    }

    private void moveToLogin() {
        Intent intent = new Intent(getActivity(), SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        getActivity().finish();
    }
}