package com.example.haduyanh_intent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editA,editB,editKq;
    Button buttonRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        editKq = findViewById(R.id.editKq);
        buttonRequest = findViewById(R.id.buttonRequest);

        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khia báo intent
                Intent myintent = new Intent(MainActivity.this,ResultActivity.class);
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                //đưa dữ liệu trực tiếp vào intent
                myintent.putExtra("numbera",a);
                myintent.putExtra("numberb",b);
                //khởi động intent và chờ kết quả
                startActivityForResult(myintent,99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33)
        {
            int sum = data.getIntExtra("ketqua",2);
            editKq.setText(sum+"");
        }
    }
}