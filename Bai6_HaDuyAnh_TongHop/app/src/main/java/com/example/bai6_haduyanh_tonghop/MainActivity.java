package com.example.bai6_haduyanh_tonghop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName, editID , editBoSung ;
    RadioGroup idgroup ;
    CheckBox    chkdocsach , chkdocbao , chkcoding ;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editID = findViewById(R.id.editID);
        editBoSung = findViewById(R.id.editBoSung);
        idgroup = findViewById(R.id.idGroup);
        chkdocsach = findViewById(R.id.checkBoxSach);
        chkdocbao = findViewById(R.id.checkBoxBao);
        chkcoding = findViewById(R.id.checkBoxCoding);
        buttonSend = findViewById(R.id.buttonSend);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HoTen = editName.getText().toString();
                if (HoTen.length() <3) {
                    Toast.makeText(MainActivity.this,"Tên phải>= 3 ký tự" , Toast.LENGTH_SHORT).show();//thông báo
                    editName.requestFocus();//Đưa con trỏ về
                    editName.selectAll();//Bôi đen
                    return;
                }
                String CMND =  editID.getText().toString();
                if (CMND.length()!=9){
                    Toast.makeText(MainActivity.this, "CMND phải đúng 9 số", Toast.LENGTH_SHORT).show();//thong báo
                    editID.requestFocus();
                    editID.selectAll();
                    return;
                }
                //Lấy bằng cấp
                int idselect = idgroup.getCheckedRadioButtonId();//Trả về id của option button được chọn
                RadioButton radselect = findViewById(idselect);//Tham chiếu đến id của Button
                String  bangcap = radselect.getText().toString();
                //Lấy sở thích người dùng
                String soThich = "";
                if  (chkdocsach.isChecked())//Nếu chọn ĐỌc Sách
                    soThich +=  chkdocsach.getText().toString()+"\n";
                if (chkdocbao.isChecked())
                    soThich += chkdocbao.getText().toString()+"\n";
                if  (chkcoding.isChecked())
                    soThich += chkcoding.getText().toString()+"\n";
                //Lấy thông tin bổ sung
                String  bosung  =   editBoSung.getText().toString();
                String  Tonghop =   HoTen+"\n" +CMND+"\n"+bangcap+"\n"+soThich+"----------\n"+bosung+"\n"+"--------";
                //Tạo Dialog
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Thông Tin Cá Nhân");
                mydialog.setMessage(Tonghop);
                mydialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydialog.create().show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn muốn thoát không?")
                .setCancelable(false)
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}