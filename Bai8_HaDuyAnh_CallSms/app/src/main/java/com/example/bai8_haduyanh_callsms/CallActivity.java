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

public class CallActivity extends AppCompatActivity {
    EditText editPhone1;
    Button buttonBack1;
    ImageButton buttonDial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        editPhone1 = findViewById(R.id.editPhone2);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonDial = findViewById(R.id.buttonSend);
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+editPhone1.getText().toString()));
                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callDial);
            }
        });
        buttonBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}