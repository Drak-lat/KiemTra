package com.example.myfood_letheanh;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import sqlite.DBHelper_LeTheAnh;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper_LeTheAnh db = new DBHelper_LeTheAnh(this);
        db.getWritableDatabase();
    }
}