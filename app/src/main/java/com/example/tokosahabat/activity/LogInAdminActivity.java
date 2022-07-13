package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.SessionManager;
import com.example.tokosahabat.activity.user.DashboardUserActivity;
import com.example.tokosahabat.databinding.ActivityLogInAdminBinding;
import com.example.tokosahabat.model.login.Login;
import com.example.tokosahabat.model.login.LoginAdmin;
import com.example.tokosahabat.model.login.LoginAdminData;
import com.example.tokosahabat.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInAdminActivity extends AppCompatActivity {

    APIRequestData apiInterface;
    SessionManager sessionManager;
    private String Username;
    private String Password;
    ActivityLogInAdminBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        // intent ke halaman Dashboard admin activity
        binding.btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = binding.edtEmailAdmin.getText().toString();
                Password = binding.edtPasswordAdmin.getText().toString();
                if(Username.matches("") && Password.matches("")){
                    Toast.makeText(LogInAdminActivity.this, "Email Atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    login(Username, Password);
                }
            }
        });

    }

    private void login(String username, String password) {
        apiInterface = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<LoginAdmin> loginCall = apiInterface.loginAdminResponse(username,password);
        loginCall.enqueue(new Callback<LoginAdmin>() {

            @Override
            public void onResponse(Call<LoginAdmin> call, Response<LoginAdmin> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){


                    //Ini untuk pindah
                    Toast.makeText(LogInAdminActivity.this, response.body().getLoginAdminData().getUsername(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LogInAdminActivity.this, DashboardAdminActivity.class));
                    finish();
                } else {
                    Toast.makeText(LogInAdminActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginAdmin> call, Throwable t) {
                Toast.makeText(LogInAdminActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}