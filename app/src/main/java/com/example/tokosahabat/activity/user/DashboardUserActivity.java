package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tokosahabat.R;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.activity.SignInActivity;
import com.example.tokosahabat.databinding.ActivityDashboardUserBinding;
import com.example.tokosahabat.fragment.user.HomeUserFragment;
import com.example.tokosahabat.fragment.user.ProfileUserFragment;
import com.example.tokosahabat.fragment.user.SearchUserFragment;

public class DashboardUserActivity extends AppCompatActivity {

    SessionManager sessionManager;
    ActivityDashboardUserBinding binding;
    TextView etEmail;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(new HomeUserFragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_user, new HomeUserFragment()).commit();

        sessionManager = new SessionManager(DashboardUserActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }


        binding.bottomNavUser.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeUserFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileUserFragment());
                    break;
            }
            return true;
        });

    }

    private void moveToLogin() {
        Intent intent = new Intent(DashboardUserActivity.this, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_user,fragment);
        fragmentTransaction.commit();


    }
}