package com.example.bai8_haduyanh_callsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonCall, buttonSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCall = findViewById(R.id.buttonCall);
        buttonSms = findViewById(R.id.buttonSms);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(MainActivity.this, CallActivity.class);
                startActivity(call);
            }
        });
        buttonSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sms = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(sms);
            }
        });
    }
}