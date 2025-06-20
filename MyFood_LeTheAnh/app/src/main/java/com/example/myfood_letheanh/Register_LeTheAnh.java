package com.example.myfood_letheanh;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import sqlite.DBHelper_LeTheAnh;

public class Register_LeTheAnh extends AppCompatActivity {

    EditText etUsernameRegister, etPasswordRegister, etRePasswordRegister;
    ImageButton btnRegister;
    TextView tvLoginNow;
    DBHelper_LeTheAnh dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
//ánh xạ
        dbHelper = new DBHelper_LeTheAnh(this);
        etUsernameRegister = findViewById(R.id.etUsernameRegister);
        etPasswordRegister = findViewById(R.id.etPasswordRegister);
        etRePasswordRegister = findViewById(R.id.etRePasswordRegister);
        btnRegister = findViewById(R.id.btnRegister);
        tvLoginNow = findViewById(R.id.tvLoginNow);

        btnRegister.setOnClickListener(v -> {
            String username = etUsernameRegister.getText().toString().trim();
            String password = etPasswordRegister.getText().toString().trim();
            String repassword = etRePasswordRegister.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(repassword)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO User_LeTheAnh (username, password) VALUES (?, ?)", new String[]{username, password});
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });

        tvLoginNow.setOnClickListener(v -> {
            finish();
        });
    }
}
