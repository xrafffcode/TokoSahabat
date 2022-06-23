package com.example.tokosahabat.model;

public class AllOrderModel {

    int image;
    String id, name, waktu;

    public AllOrderModel(int image, String id, String name, String waktu) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.waktu = waktu;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
