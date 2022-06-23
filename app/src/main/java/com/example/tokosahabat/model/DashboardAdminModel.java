package com.example.tokosahabat.model;

public class DashboardAdminModel {

    int image;
    String name, stock, price, delete;

    public DashboardAdminModel(int image, String name, String stock, String price, String delete) {
        this.image = image;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.delete = delete;
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

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
}
