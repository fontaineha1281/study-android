package com.example.haduyanh_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    final String DATABASE_NAME = "dbqlsach.db";
    Button buttonThem, buttonHuy;
    EditText editMaSo,editTenSach,editTacGia,editNamXB,editSoLuong;
    String masach="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addControls();
        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        buttonHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void addControls() {
        editMaSo = findViewById(R.id.editMaSo);
        editTenSach = findViewById(R.id.editTenSach);
        editTacGia = findViewById(R.id.editTenTacGia);
        editNamXB = findViewById(R.id.editNamXB);
        editSoLuong = findViewById(R.id.editSoLuong);
        buttonThem= findViewById(R.id.buttonThem);
        buttonHuy=findViewById(R.id.buttonHuy);
    }
    private void insert () {
        String masach = editMaSo.getText().toString();
        String tensach = editTenSach.getText().toString();
        String tacgia = editTacGia.getText().toString();
        String namxb = editNamXB.getText().toString();
        String soluong = editSoLuong.getText().toString();
        ContentValues values = new ContentValues();
        values.put("masach",masach);
        values.put("tensach",tensach);
        values.put("tacgia",tacgia);
        values.put("namxb",namxb);
        values.put("soluong",soluong);
        SQLiteDatabase database = Database.initDatabase(this,"dbqlsach.db");
        database.insert("tablesach",null,values);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void cancel() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}