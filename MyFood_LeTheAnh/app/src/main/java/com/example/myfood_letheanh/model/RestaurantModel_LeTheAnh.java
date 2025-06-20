package com.example.myfood_letheanh.model;

public class RestaurantModel_LeTheAnh {
    public int id;
    public String name;
    public String address;
    public String imageUrl;

    public RestaurantModel_LeTheAnh(int id, String name, String address, String imageUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return name + " - " + address;
    }
}
