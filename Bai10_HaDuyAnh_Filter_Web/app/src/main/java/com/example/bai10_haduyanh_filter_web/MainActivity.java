package com.example.bai10_haduyanh_filter_web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView myBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBrowser = findViewById(R.id.myBrowser);
        Intent myintent = getIntent();
        Uri url = myintent.getData();
        //Nếu lỗi không dừng ctr và hiển thị lỗi
        try
        {
            myBrowser.loadUrl(url.toString());
        }
        catch (Exception e)
         {
            e.printStackTrace();
        }
    }
}