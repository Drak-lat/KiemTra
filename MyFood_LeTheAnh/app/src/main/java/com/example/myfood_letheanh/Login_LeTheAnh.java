package com.example.myfood_letheanh;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import sqlite.DBHelper_LeTheAnh;


public class Login_LeTheAnh extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvRegister;
    ImageButton btnDoctor, btnPatient;
    DBHelper_LeTheAnh dbHelper;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        btnDoctor= findViewById(R.id.btnDoctor);
        btnPatient = findViewById(R.id.btnPatient);

        dbHelper = new DBHelper_LeTheAnh(this);


        btnLogin.setOnClickListener(view -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
//Truyèn user
            if (checkLogin_LeTheAnh(username, password)) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeLeTheAnh.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this, Register_LeTheAnh.class);
            startActivity(intent);
        });

        // Xử lý nút chhọn loại tài khoản
        btnDoctor.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn đã chọn tài khoản bác sĩ", Toast.LENGTH_SHORT).show();
        });

        btnPatient.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn đã chọn tài khoản bệnh nhân", Toast.LENGTH_SHORT).show();
        });
    }

    private boolean checkLogin_LeTheAnh(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM User_LeTheAnh WHERE username=? AND password=?",
                new String[]{username, password}
        );
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }
}
