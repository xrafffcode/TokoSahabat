package com.example.tokosahabat.model;

import android.os.Parcelable;

import java.io.Serializable;

public class MyCartListModel implements Serializable {
        private int id_item, id_keranjang;
        private String nama_item, gambar_item, harga_pokok;

        public int getId_keranjang() {
            return id_keranjang;
        }

        public void setId_keranjang(int id_keranjang) {
            this.id_keranjang = id_keranjang;
        }

        public int getId_item() {
            return id_item;
        }

        public void setId_item(int id_item) {
            this.id_item = id_item;
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

        public String getHarga_pokok() {
            return harga_pokok;
        }

        public void setHarga_pokok(String harga_pokok) {
            this.harga_pokok = harga_pokok;
        }


}

