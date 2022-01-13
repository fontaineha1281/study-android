package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btncreat, btnibsertlop, btndelop, btnuplop, btnqerylop;
    TextView edtmalop,edttenlop,edtsiso;
    SQLiteDatabase database1= null;
    String tbllop= "tbllop";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnibsertlop= (Button) findViewById(R.id.btninstlop);
        btndelop= (Button) findViewById(R.id.btndellop);
        btnuplop= (Button) findViewById(R.id.btnUplop);
        btnqerylop= (Button) findViewById(R.id.btnqrylop);
        edtmalop= (TextView) findViewById(R.id.edtmalop);
        edttenlop= (TextView) findViewById(R.id.edttenlop);
        edtsiso= (TextView) findViewById(R.id.edtsiso);
        database1= openOrCreateDatabase("qlsinhvien.db", MODE_PRIVATE, null);
        try {
            docreattable();//Gọi hàm Tạo Tabel
        } catch(Exception e) {
            Log.e("Error", "Table is exists");
        }
        btnibsertlop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doinsertrecordtolop();// Gọi hàm chèn thêm lớp mới
            }
        });
        btndelop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleterowLop();// Gọi hàm xóa lớp
            }
        });
        btnuplop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doupdaterowlop();//Gọi hàm update lớp
            }
        });
        btnqerylop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querytablelop();// Gọi hàm truy vấn lớp
            }
        });
    }
    private void docreattable() {
        String sql1="CREATE TABLE tbllop ("+"malop TEXT primary key,"+"tenlop TEXT,"+"siso INTEGER)";
        database1.execSQL(sql1);
    }
    private void doinsertrecordtolop() {
        String malop = edtmalop.getText().toString();
        String tenlop = edttenlop.getText().toString();
        String siso = edttenlop.getText().toString();
        ContentValues values=new ContentValues();
        values.put("malop", malop);
        values.put("tenlop", tenlop);
        values.put("siso", siso);
        String msg="";
        if(database1.insert("tbllop", null, values)==-1){
            msg="Failed to insert record";
        } else {
            msg="Failed to insert record";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    private void deleterowLop() {
        String malop = edtmalop.getText().toString();
        int d = database1.delete("tbllop", "malop =?", new String[]{malop});
        String msg = "";
        if(d ==0){
            msg ="Delete Row "+malop +" Fail";
        }else{
            msg ="Delete Row "+malop +" Sucessful";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    private void doupdaterowlop() {
        String malop = edtmalop.getText().toString();
        String new_tenlop = edttenlop.getText().toString();
        String siso = edtsiso.getText().toString();
        ContentValues values=new ContentValues();
        values.put("tenlop", new_tenlop);
        values.put("siso", siso);
        String msg="";
        int ret=database1.update("tbllop", values,"malop=?", new String[]{malop});
        if(ret==0){
            msg="Failed to update";
        }else{
            msg="updating is successful";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    public void querytablelop() {
        Cursor c = database1.query("tbllop", null, null, null, null, null, null);
        c.moveToFirst();
        String data="";
        while(c.isAfterLast()==false) {
            data+=c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2);data+="\n";c.moveToNext();
        }
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        c.close();
    }
}