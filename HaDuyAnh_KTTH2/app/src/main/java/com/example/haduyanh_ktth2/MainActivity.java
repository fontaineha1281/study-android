package com.example.haduyanh_ktth2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText editName,editNumber,editTongSoKH,editTongSoKHVip,editTien,editDoanhThu;
    Button buttonTT,buttonNext,buttonThongKe;
    CheckBox checkBoxVip;
    int tongKH = 0, tongKHVip = 0, tongDoanhThu = 0;
    ImageButton buttonExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editNumber = findViewById(R.id.editNumber);
        editTien = findViewById(R.id.editTien);
        editTongSoKH = findViewById(R.id.editTongSoKH);
        editTongSoKHVip = findViewById(R.id.editTongSoKHVip);
        buttonNext = findViewById(R.id.buttonNext);
        buttonThongKe = findViewById(R.id.buttonThongKe);
        buttonTT = findViewById(R.id.buttonTT);
        checkBoxVip = findViewById(R.id.checkBoxVip);
        editDoanhThu = findViewById(R.id.editDoanhThu);
        buttonExit = findViewById(R.id.buttonThoat);

        buttonTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = editName.getText().toString();
                int soLuongSach = Integer.parseInt(editNumber.getText().toString());
                if (checkBoxVip.isChecked()){
                        int thanhTien = (soLuongSach*20000)-((soLuongSach*20000)*10/100);
                        tongKH++;
                        tongKHVip++;
                        tongDoanhThu += thanhTien;
                        editTien.setText(String.valueOf(thanhTien));

                }
                else {
                        int thanhTien = soLuongSach*20000;
                        editTien.setText(String.valueOf(thanhTien));
                        tongKH++;
                        tongDoanhThu += thanhTien;
                        editTien.setText(String.valueOf(thanhTien));
                }
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
                editNumber.setText("");
                editTien.setText("");
                editName.requestFocus();
            }
        });

        buttonThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDoanhThu.setText(String.valueOf(tongDoanhThu));
                editTongSoKH.setText(String.valueOf(tongKH));
                editTongSoKHVip.setText(String.valueOf(tongKHVip));
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShow();
            }
        });
    }
    private void dialogShow() {
        Dialog exit = new Dialog(this);
        exit.setContentView(R.layout.dialog_custom);
        ImageButton buttonYes = (ImageButton) exit.findViewById(R.id.buttonYes);
        ImageButton buttonNo = (ImageButton) exit.findViewById(R.id.buttonNo);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.cancel();
            }
        });
        exit.show();
    }
}