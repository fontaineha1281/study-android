package com.example.bai9_haduyanh_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonPlay, buttonStop;
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonStop = findViewById(R.id.buttonStop);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPlay = new Intent(MainActivity.this, MusicService.class);
                startService(intentPlay);
                if (flag == true)
                {
                    buttonPlay.setImageResource(R.drawable.pause);
                    flag = false;
                }
                else
                {
                    buttonPlay.setImageResource(R.drawable.play);
                    flag = true ;
                }
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStop = new Intent(MainActivity.this, MusicService.class);
                stopService(intentStop);
                buttonPlay.setImageResource(R.drawable.play);
                flag = true;
            }
        });
    }
}