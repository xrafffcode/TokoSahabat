package com.example.tokosahabat.model;

public class DashboardUserModel {

    int image;
    String name, stock, price;

    public DashboardUserModel(int image, String name, String stock, String price) {
        this.image = image;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
