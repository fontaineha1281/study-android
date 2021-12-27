package com.example.bai10_haduyanh_filter_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText editLink;
    Button buttonShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editLink = findViewById(R.id.editLink);
        buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khởi tạo intent ẩn để thực hiện action view
                Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+editLink.getText().toString()));
                startActivity(myintent);
            }
        });
    }
}