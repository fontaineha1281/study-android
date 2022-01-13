package com.example.haduyanh_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    final String DATABASE_NAME = "dbqlsach.db";
    Button buttonLuu, buttonHuy;
    EditText editMaSo,editTenSach,editTacGia,editNamXB,editSoLuong;
    String masach="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        addControls();
        initUI();
        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        buttonHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void initUI() {
        Intent intent = getIntent();
        masach = intent.getStringExtra("masach");
        SQLiteDatabase database = Database.initDatabase(UpdateActivity.this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM tablesach WHERE masach = ?",new String[]{masach});
        cursor.moveToFirst();

        String tensach = cursor.getString(1);
        String tentacgia = cursor.getString(2);
        int namsx = cursor.getInt(3);
        int soluong = cursor.getInt(4);

        editMaSo.setText(masach);
        editTenSach.setText(tensach);
        editTacGia.setText(tentacgia);
        editNamXB.setText(namsx + "");
        editSoLuong.setText(soluong + "");
    }

    private void addControls() {
        editMaSo = findViewById(R.id.editMaSo);
        editTenSach = findViewById(R.id.editTenSach);
        editTacGia = findViewById(R.id.editTenTacGia);
        editNamXB = findViewById(R.id.editNamXB);
        editSoLuong = findViewById(R.id.editSoLuong);
        buttonLuu= findViewById(R.id.buttonThem);
        buttonHuy=findViewById(R.id.buttonHuy);
    }
    private void update () {
        String tensach = editTenSach.getText().toString();
        String tacgia = editTacGia.getText().toString();
        String namxb = editNamXB.getText().toString();
        String soluong = editSoLuong.getText().toString();
        ContentValues values = new ContentValues();
        values.put("tensach",tensach);
        values.put("tacgia",tacgia);
        values.put("namxb",namxb);
        values.put("soluong",soluong);
        SQLiteDatabase database = Database.initDatabase(this,"dbqlsach.db");
        database.update("tablesach",values,"masach = ?", new String[]{masach});
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void cancel() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}