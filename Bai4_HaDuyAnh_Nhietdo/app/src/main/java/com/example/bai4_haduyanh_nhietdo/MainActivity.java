package com.example.bai4_haduyanh_nhietdo;

import static com.example.bai4_haduyanh_nhietdo.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView editFah, editCel;
    Button buttonCel,buttonFah,buttonClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        editCel = findViewById(R.id.editCel);
        editFah = findViewById(R.id.editFah);
        buttonCel = findViewById(R.id.buttonCel);
        buttonFah = findViewById(R.id.buttonFah);
        buttonClear = findViewById(R.id.buttonClear);

        buttonCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat decimal=new DecimalFormat("#.00");
                int doC = Integer.parseInt(editCel.getText().toString());//Lấy chữ nhập chuyển thành số
                double doF = doC * 9.0/5 + 32 ;//Tính *F
                editFah.setText(decimal.format(doF)+"");//set hiển thị F +"" để chuyển thành String
            }
        });

        buttonFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat decimal = new DecimalFormat("#.00");
                int doF = Integer.parseInt(editFah.getText().toString());
                double  doC = (doF-32) * 5.0/9;
                editCel.setText(decimal.format(doC)+"");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFah.setText("");
                editCel.setText("");
            }
        });

    }
}