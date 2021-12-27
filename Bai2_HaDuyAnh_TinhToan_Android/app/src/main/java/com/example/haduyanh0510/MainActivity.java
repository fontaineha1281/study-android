package com.example.haduyanh0510;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtNhapA ;
    TextView txtNhapB;
    EditText editA , editB ;
    TextView txtKetqua;
    Button   btnTinhTong ;
    Button btnTinhHieu;
    Button btnTinhTich;
    Button btnTinhThuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        txtKetqua = (TextView) findViewById(R.id.textViewKQ1);
        btnTinhTong = (Button) findViewById(R.id.buttonTong);
        btnTinhHieu = (Button) findViewById(R.id.buttonHieu);
        btnTinhTich = (Button) findViewById(R.id.buttonTich);
        btnTinhThuong = (Button) findViewById(R.id.buttonThuong);

        editA = (EditText) findViewById(R.id.editA);
        editB = (EditText) findViewById(R.id.editB);
        //Bước 3
        //set Onclick
        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                int tong = a + b ;
                txtKetqua.setText(String.valueOf(tong));
            }
        });

        btnTinhHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                int hieu = a - b ;
                txtKetqua.setText(String.valueOf(hieu));
            }
        });

        btnTinhTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                int tich = a * b ;
                txtKetqua.setText(String.valueOf(tich));
            }
        });

        btnTinhThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                float thuong = a / b ;
                txtKetqua.setText(String.valueOf(thuong));
            }
        });

    }
}