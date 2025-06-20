package com.example.myfood_letheanh.model;

public class FoodModel_LeTheAnh {
    public int id;
    public String name;
    public String size;
    public double price;
    public String imageUrl;
    public String restaurantName;

    public FoodModel_LeTheAnh(int id, String name, String size, double price, String imageUrl, String restaurantName) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.imageUrl = imageUrl;
        this.restaurantName = restaurantName;
    }
}
