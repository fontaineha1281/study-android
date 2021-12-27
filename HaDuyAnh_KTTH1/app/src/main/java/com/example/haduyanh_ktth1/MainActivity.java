package com.example.haduyanh_ktth1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button buttonToNgoai, buttonToVND, buttonClear;
    EditText editVN, editNgoaiTe ;
    RadioGroup radioGroup;
    RadioButton radioUSD,radioEUR,radioJYP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonToVND = findViewById(R.id.buttonToVnd);
        buttonToNgoai = findViewById(R.id.buttonToNgoai);
        buttonClear = findViewById(R.id.buttonClear);
        editVN = findViewById(R.id.editVN);
        editNgoaiTe = findViewById(R.id.editNgoaiTe);
        radioGroup =  findViewById(R.id.radioGroup);
        radioUSD = findViewById(R.id.radioButtonUSD);
        radioEUR = findViewById(R.id.radioButtonEUR);
        radioJYP = findViewById(R.id.radioButtonJPY);

        buttonToNgoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("#.0");
                if (radioUSD.isChecked()) {
                    int tinhUSD = Integer.parseInt(editVN.getText().toString());
                    double kqVNDtoNgoai = tinhUSD/22280.0;
                    editNgoaiTe.setText(dcf.format(kqVNDtoNgoai)+"");
                }
                if (radioEUR.isChecked()) {
                    int tinhEur = Integer.parseInt(editVN.getText().toString());
                    double kqVNDtoNgoai = tinhEur/24280.0;
                    editNgoaiTe.setText(dcf.format(kqVNDtoNgoai)+"");
                }
                if (radioJYP.isChecked()) {
                    int tinhJPY = Integer.parseInt(editVN.getText().toString());
                    double kqVNDtoNgoai = tinhJPY/204.0;
                    editNgoaiTe.setText(dcf.format(kqVNDtoNgoai)+"");
                }
            }
        });

        buttonToVND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("#.0");
                if (radioUSD.isChecked()) {
                    int tinhUSD = Integer.parseInt(editNgoaiTe.getText().toString());
                    double kqNgoaiToVND = tinhUSD*22280.0;
                    editVN.setText(dcf.format(kqNgoaiToVND)+"");
                }
                if (radioEUR.isChecked()) {
                    int tinhEur = Integer.parseInt(editNgoaiTe.getText().toString());
                    double kqNgoaiToVND  = tinhEur*24280.0;
                    editVN.setText(dcf.format(kqNgoaiToVND)+"");
                }
                if (radioJYP.isChecked()) {
                    int tinhJPY = Integer.parseInt(editNgoaiTe.getText().toString());
                    double kqNgoaiToVND  = tinhJPY*204.0;
                    editVN.setText(dcf.format(kqNgoaiToVND)+"");
                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editVN.setText("");
                editNgoaiTe.setText("");
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}