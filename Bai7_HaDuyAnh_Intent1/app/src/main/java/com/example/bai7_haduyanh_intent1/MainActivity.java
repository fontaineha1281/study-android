package com.example.bai7_haduyanh_intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editA, editB;
    Button buttonKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        buttonKq = findViewById(R.id.buttonKq);

        buttonKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khai báo Intent
                Intent myintent = new Intent(MainActivity.this,ResultActivity.class);
                //khai báo bundle
                Bundle mybundle1 = new Bundle();
                //lấy dữ liệu
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                //đưa dữ liệu vào bundle
                mybundle1.putInt("numbera",a);
                mybundle1.putInt("numberb",b);
                //đưa bundle vào intent
                myintent.putExtra("mypackage",mybundle1);
                //khởi đọng activity qua intent
                startActivity(myintent);
            }
        });
    }
}