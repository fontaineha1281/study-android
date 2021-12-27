package com.example.bai8_haduyanh_callsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SmsActivity extends AppCompatActivity {
    EditText editPhone2;
    Button buttonBack2;
    ImageButton buttonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        editPhone2 = findViewById(R.id.editPhone2);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendSms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+editPhone2.getText().toString()));
                //Grant access
                if (ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS},1);
                    return;
                }
                startActivity(sendSms);
            }
        });
        buttonBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}