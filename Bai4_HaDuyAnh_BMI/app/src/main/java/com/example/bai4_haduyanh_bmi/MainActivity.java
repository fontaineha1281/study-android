package com.example.bai4_haduyanh_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtNhapten , edtHeight ,edtHeavy , edtBMI , edtChuandoan ;
    Button btnBMI ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNhapten = findViewById(R.id.edtNhapTen);
        edtHeight  = findViewById(R.id.edtHeight);
        edtHeavy = findViewById(R.id.edtHeavy);
        edtBMI = findViewById(R.id.edtBMI);
        edtChuandoan = findViewById(R.id.edtChuandoan);
        btnBMI = findViewById(R.id.btnBMI);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Height = Double.parseDouble(edtHeight.getText().toString());
                double  Heavy = Double.parseDouble(edtHeavy.getText().toString());
                double  BMI = Heavy/Math.pow(Height,2);
                String chuandoan="";
                if(BMI <18){
                    edtChuandoan.setText("Bạn Gầy");
                }else if (BMI<=24.9){
                    edtChuandoan.setText("Bạn bình thường");
                }else if(BMI<=29.9){
                    edtChuandoan.setText("Bạn béo phì độ 1");
                }else if(BMI<=34.9){
                    edtChuandoan.setText("Bạn béo phì độ 2");
                }else{
                    edtChuandoan.setText("Bạn béo phì độ 3");
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(BMI));
            }
        });
    }
}