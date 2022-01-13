package com.example.haduyanh_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "dbqlsach.db";
    SQLiteDatabase database;
    ListView lv1;
    ArrayList<Sach>list;
    AdapterSach adapter;
    FloatingActionButton buttonAdd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        readData();
    }

    private void addControl() {
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });
        lv1 = findViewById(R.id.lv1);
        list = new ArrayList<>();
        adapter = new AdapterSach(this,list);
        lv1.setAdapter(adapter);
    }
    private void readData() {
        database = Database.initDatabase(MainActivity.this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM tablesach",null);
        list.clear();
        for (int i=0;i<cursor.getCount();i++) {
            cursor.moveToPosition(i);
            String masach = cursor.getString(0);
            String tensach = cursor.getString(1);
            String tentacgia = cursor.getString(2);
            int namsx = cursor.getInt(3);
            int soluong = cursor.getInt(4);
            list.add(new Sach(masach,tensach,tentacgia,namsx,soluong));
        }
        adapter.notifyDataSetChanged();
    }
}