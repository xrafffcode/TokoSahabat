package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.activity.DashboardAdminActivity;
import com.example.tokosahabat.activity.LogInAdminActivity;
import com.example.tokosahabat.activity.SignInActivity;
import com.example.tokosahabat.databinding.ActivitySignUpUserBinding;
import com.example.tokosahabat.model.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpUserActivity extends AppCompatActivity {

    ActivitySignUpUserBinding binding;
    APIRequestData apiInterface;
    private String Username;
    private String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // intent ke halaman Dashboard admin activity
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username = binding.edtEmail.getText().toString();
                Password = binding.edtPassword.getText().toString();
                register(Username, Password);


            }
        });
    }

    private void register(String username, String password) {
        apiInterface = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Register> call = apiInterface.registerResponse(username, password);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(SignUpUserActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpUserActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpUserActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(SignUpUserActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}