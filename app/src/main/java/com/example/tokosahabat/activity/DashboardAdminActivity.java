package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityDashboardAdminBinding;
import com.example.tokosahabat.fragment.CartFragment;
import com.example.tokosahabat.fragment.HomeFragment;
import com.example.tokosahabat.fragment.ProfileFragment;
import com.example.tokosahabat.fragment.SearchFragment;
import com.example.tokosahabat.fragment.user.HomeUserFragment;

public class DashboardAdminActivity extends AppCompatActivity {

    ActivityDashboardAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(new HomeFragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_admin, new HomeFragment()).commit();

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.search:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_admin,fragment);
        fragmentTransaction.commit();


    }
}