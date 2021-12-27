package com.example.bai5_haduyanh_ptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnTiepTuc, btnGiai,btnExit;
    TextView ketQua;
    EditText editA, editB, editC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        editC = findViewById(R.id.editC);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnExit = findViewById(R.id.btnExit);
        btnGiai = findViewById(R.id.btnGiai);
        ketQua = findViewById(R.id.ketQua);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sa = editA.getText()+"";
                String sb = editB.getText()+"";
                String sc = editC.getText()+"";
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String result = "";
                DecimalFormat decimal = new DecimalFormat("#.00");
                if (a==0) {
                    if (b==0){
                        if (c==0) result = "Phương trình vô số nghiệm";
                            else  result = "Phương trình vô nghiệm";
                    }
                    else {
                        result = "Phương trình có 1 nghiệm, x = "+decimal.format(-c/b);
                    }
                }
                else
                    {
                        double delta=b*b-4*a*c; if(delta<0)
                         {
                                 result="PT vô nghiệm";
                          }
                        else if(delta==0)
                        {
                            result="Phương trình có nghiệm kép x1=x2="+decimal.format(-b/(2*a));
                        }
                        else {
                            result="Phương trình có 2 nghiệm: x1="+decimal.format((-b+Math.sqrt(delta))/(2*a))+"; x2="+decimal.format((-b- Math.sqrt(delta))/(2*a));
                        }
                    }
                ketQua.setText(result);
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editA.setText("");
                editB.setText("");
                editC.setText("");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}