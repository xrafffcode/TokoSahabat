package com.example.tokosahabat.model;

public class SuccessModel {

    String cod, harga;

    public SuccessModel(String cod, String harga) {
        this.cod = cod;
        this.harga = harga;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
