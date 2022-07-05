package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.activity.user.DashboardUserActivity;
import com.example.tokosahabat.activity.user.SignUpUserActivity;
import com.example.tokosahabat.databinding.ActivitySignInBinding;
import com.example.tokosahabat.model.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    APIRequestData apiInterface;
    ActivitySignInBinding binding;
    private String Username;
    private String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        // intent button sign in ke dashboard admin
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username = binding.edtEmail.getText().toString();
                Password = binding.edtPassword.getText().toString();
                if(Username.matches("") && Password.matches("")){
                    Toast.makeText(SignInActivity.this, "Email Atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                   login(Username, Password);
                }

            }
        });

        // intent button login as admin
        binding.btnLoginAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke login in admin activity
                startActivity(new Intent(SignInActivity.this, LogInAdminActivity.class));
            }
        });

        // intent sign up ke user
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Explicit pindah halaman ke activity_detail
                startActivity(new Intent(SignInActivity.this, SignUpUserActivity.class));
            }
        });

    }

    private void login(String email, String password) {
        apiInterface = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Login> loginCall = apiInterface.loginResponse(email,password);
        loginCall.enqueue(new Callback<Login>() {

            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){


                    //Ini untuk pindah
                    Toast.makeText(SignInActivity.this, response.body().getData().getEmail(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInActivity.this, DashboardUserActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignInActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(SignInActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}