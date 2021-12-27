package com.example.bai7_haduyanh_intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtNghiem;
    Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtNghiem = findViewById(R.id.txtNghiem);
        buttonBack = findViewById(R.id.buttonBack);
        //nhận intent
        Intent myintent = getIntent();
        //Lấy bundle ra khỏi intent
        Bundle mybundle1 = myintent.getBundleExtra("mypackage");
        //Lấy dữ liệu ra khỏi bundle
        int a = mybundle1.getInt("numbera");
        int b = mybundle1.getInt("numberb");
        //tiến hành giải PT
        String nghiem="";
        if (a == 0 && b == 0)
                nghiem = "Phương trình vô số nghiệm";
            else if (a == 0 && b != 0)
                nghiem = "Phương trình vô nghiệm";
            else
                nghiem = "Nghiệm phương trình X = " + b*(-1.0)/a;
            txtNghiem.setText(nghiem);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}