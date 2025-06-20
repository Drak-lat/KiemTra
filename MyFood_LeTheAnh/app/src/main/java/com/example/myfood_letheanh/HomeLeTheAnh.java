package com.example.myfood_letheanh;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfood_letheanh.model.RestaurantModel_LeTheAnh;
import java.util.ArrayList;
import sqlite.DBHelper_LeTheAnh;

public class HomeLeTheAnh extends AppCompatActivity {

    ListView lvRestaurant_LeTheAnh;
    ArrayList<RestaurantModel_LeTheAnh> list = new ArrayList<>();
    ArrayAdapter<RestaurantModel_LeTheAnh> adapter;
    DBHelper_LeTheAnh dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        lvRestaurant_LeTheAnh = findViewById(R.id.lvRestaurant_LeTheAnh);
        dbHelper = new DBHelper_LeTheAnh(this);
        loadRestaurants();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvRestaurant_LeTheAnh.setAdapter(adapter);

//xử lý click Item
        lvRestaurant_LeTheAnh.setOnItemClickListener((parent, view, position, id) -> {
            RestaurantModel_LeTheAnh res = list.get(position);
            Intent intent = new Intent(this, FoodListActivity_LeTheAnh.class);
            intent.putExtra("restaurantId", res.id);
            startActivity(intent);
        });
    }

    //lấy dữ liệu db
    private void loadRestaurants() {
        list.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Restaurant_LeTheAnh", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                String imageUrl = cursor.getString(3);
                list.add(new RestaurantModel_LeTheAnh(id, name, address, imageUrl));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}