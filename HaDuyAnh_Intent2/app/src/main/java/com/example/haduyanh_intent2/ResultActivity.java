package com.example.haduyanh_intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText editA1, editB1;
    Button buttonSend;
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        editA1 = findViewById(R.id.editA1);
        editB1 = findViewById(R.id.editB1);
        buttonSend = findViewById(R.id.buttonSend);
        //nhận intent
        myintent = getIntent();
        int a = myintent.getIntExtra("numbera",1);
        int b = myintent.getIntExtra("numberb",1);
        editA1.setText(a+"");
        editB1.setText(b+"");
        int sum = a + b;
        //đưa sum trở lại intent
        myintent.putExtra("ketqua",sum);
        //gửi kết quả về
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(33,myintent);
                finish();
            }
        });
    }
}