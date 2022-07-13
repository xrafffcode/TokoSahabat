package com.example.tokosahabat.model;

import java.io.Serializable;

public class DataModel implements Serializable {
    private int id_item;
    private String kode_item, barcode, nama_item, gambar_item, stok_item, jenis_item, konversi, tipe_item, satuan, harga_pokok, harga_level;

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getKode_item() {
        return kode_item;
    }

    public void setKode_item(String kode_item) {
        this.kode_item = kode_item;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNama_item() {
        return nama_item;
    }

    public void setNama_item(String nama_item) {
        this.nama_item = nama_item;
    }

    public String getGambar_item() {
        return gambar_item;
    }

    public void setGambar_item(String gambar_item) {
        this.gambar_item = gambar_item;
    }

    public String getStok_item(){
        return stok_item;
    }

    public void  setStok_item(String stok_item){
        this.stok_item = stok_item;
    }

    public String getJenis_item() {
        return jenis_item;
    }

    public void setJenis_item(String jenis_item) {
        this.jenis_item = jenis_item;
    }

    public String getKonversi() {
        return konversi;
    }

    public void setKonversi(String konversi) {
        this.konversi = konversi;
    }

    public String getTipe_item() {
        return tipe_item;
    }

    public void setTipe_item(String tipe_item) {
        this.tipe_item = tipe_item;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getHarga_pokok() {
        return harga_pokok;
    }

    public void setHarga_pokok(String harga_pokok) {
        this.harga_pokok = harga_pokok;
    }

    public String getHarga_level() {
        return harga_level;
    }

    public void setHarga_level(String harga_level) {
        this.harga_level = harga_level;
    }
}
