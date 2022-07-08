package com.example.tokosahabat.API;

import com.example.tokosahabat.model.ResponseModel;
import com.example.tokosahabat.model.login.Login;
import com.example.tokosahabat.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("email") String email,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("gambar_item") String gambar_item,
            @Field("kode_item") String kode_item,
            @Field("barcode") String barcode,
            @Field("nama_item") String nama_item,
            @Field("stok_item") String stok_item,
            @Field("jenis_item") String jenis_item,
            @Field("konversi") String konversi,
            @Field("tipe_item") String tipe_item,
            @Field("satuan") String satuan,
            @Field("harga_pokok") String harga_pokok,
            @Field("harga_level") String harga_level
    );

    @GET("retrieve.php")
    Call<ResponseModel> ardRertrieveData();
}
