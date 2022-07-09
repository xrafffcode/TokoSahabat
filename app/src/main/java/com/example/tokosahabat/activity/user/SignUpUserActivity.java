package com.example.tokosahabat.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tokosahabat.API.APIRequestData;
import com.example.tokosahabat.API.RetroServer;
import com.example.tokosahabat.activity.SignInActivity;
import com.example.tokosahabat.databinding.ActivitySignUpUserBinding;
import com.example.tokosahabat.model.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpUserActivity extends AppCompatActivity {

    ActivitySignUpUserBinding binding;
    APIRequestData apiInterface;
    private String Email, Username, Password, Nama, Telepon;


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

                Email = binding.edtEmail.getText().toString();
                Username = binding.edtUsername.getText().toString();
                Password = binding.edtPassword.getText().toString();
                Nama = binding.edtNama.getText().toString();
                Telepon = binding.edtTelepon.getText().toString();
                if(Email.matches("") && Username.matches("") && Password.matches("") && Nama.matches("") && Telepon.matches("")){
                    Toast.makeText(SignUpUserActivity.this, "Email Atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                   register(Email, Username, Password, Nama, Telepon);
                }


            }
        });
    }

    private void register(String email, String username, String password, String nama, String telepon) {
        apiInterface = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Register> call = apiInterface.registerResponse(email, username, password, nama, telepon);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText( SignUpUserActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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