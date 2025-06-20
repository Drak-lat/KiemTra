package com.example.myfood_letheanh;

import android.content.Intent; //dữ liệu từ intent
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfood_letheanh.adapter.FoodAdapter_LeTheAnh;
import com.example.myfood_letheanh.model.FoodModel_LeTheAnh;
import java.util.ArrayList;
import sqlite.DBHelper_LeTheAnh;

public class FoodListActivity_LeTheAnh extends AppCompatActivity {


    ListView lvFood_LeTheAnh;
    ArrayList<FoodModel_LeTheAnh> list = new ArrayList<>();
    FoodAdapter_LeTheAnh adapter;
    DBHelper_LeTheAnh dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        lvFood_LeTheAnh = findViewById(R.id.lvFood_LeTheAnh);
        dbHelper = new DBHelper_LeTheAnh(this);

        int resId = getIntent().getIntExtra("restaurantId", -1);
        loadData(resId);

        adapter = new FoodAdapter_LeTheAnh(this, list);
        lvFood_LeTheAnh.setAdapter(adapter);

        lvFood_LeTheAnh.setOnItemClickListener((parent, view, position, id) -> { // Xử lý sự kiện khi click item
            FoodModel_LeTheAnh selectedFood = list.get(position);
            int foodId = selectedFood.id;
//chuyển trang bằng inteent
            Intent intent = new Intent(FoodListActivity_LeTheAnh.this, FoodDetail_LeTheAnh.class);
            intent.putExtra("foodId", foodId);
            startActivity(intent);
        });
    }

    private void loadData(int resId) {
        list.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT f.id, f.name, f.price_small, f.imageUrl, r.name FROM Food_LeTheAnh f JOIN Restaurant_LeTheAnh r ON f.restaurantId = r.id WHERE r.id=?", new String[]{String.valueOf(resId)});
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                double price = cursor.getDouble(2);
                String imageUrl = cursor.getString(3);
                String resName = cursor.getString(4);
                list.add(new FoodModel_LeTheAnh(id, name, "S", price, imageUrl, resName));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}