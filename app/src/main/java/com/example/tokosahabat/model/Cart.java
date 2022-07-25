package com.example.tokosahabat.model;

import java.util.List;

public class Cart {
    private int kode;
    private String pesan;
    private List<MyCartListModel> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<MyCartListModel> getData() {
        return data;
    }

    public void setData(List<MyCartListModel> data) {
        this.data = data;
    }
}
