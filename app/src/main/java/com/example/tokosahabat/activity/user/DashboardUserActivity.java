package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.tokosahabat.R;
import com.example.tokosahabat.databinding.ActivityDashboardUserBinding;
import com.example.tokosahabat.fragment.CartFragment;
import com.example.tokosahabat.fragment.HomeFragment;
import com.example.tokosahabat.fragment.ProfileFragment;
import com.example.tokosahabat.fragment.SearchFragment;
import com.example.tokosahabat.fragment.user.CartUserFragment;
import com.example.tokosahabat.fragment.user.HomeUserFragment;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;
import com.example.tokosahabat.fragment.user.SearchUserFragment;

public class DashboardUserActivity extends AppCompatActivity {

    ActivityDashboardUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(new HomeUserFragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_user, new HomeUserFragment()).commit();

        binding.bottomNavUser.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeUserFragment());
                    break;
                case R.id.search:
                    replaceFragment(new SearchUserFragment());
                    break;
                case R.id.cart:
                    replaceFragment(new CartUserFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileUserFragment());
                    break;
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_user,fragment);
        fragmentTransaction.commit();


    }
}