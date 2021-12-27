package com.example.haduyanh_doancanhan;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activitysub extends AppCompatActivity {
    TextView txtmaso,txtbaihat,txtloibaihat,txttacgia;
    ImageButton btnthich,btnkhongthich;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODOAuto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);
        txtmaso=(TextView)findViewById(R.id.txtmaso);
        txtbaihat=(TextView)findViewById(R.id.txtbaihat);
        txtloibaihat=(TextView) findViewById(R.id.txtloibaihat);
        txttacgia=(TextView)findViewById(R.id.txttacgia);
        btnthich=(ImageButton)findViewById(R.id.btnthich);
        btnkhongthich= (ImageButton) findViewById(R.id.btnkhongthich);
        //Nhận Intent từ myarrayAdapter, lấy dữliệu khỏi Bundle
        Intent callerIntent1 = getIntent();
        Bundle backagecaller1 = callerIntent1.getBundleExtra("package");
        String maso = backagecaller1.getString("maso");
        //Truy vấn dữliệu từmasonhận được; Hiển thịdữliệu Mã bài hát, Tên bài hát, Lời bài //hát, Tác giả, Trạng thái Thích lên activitysub
        Cursor c = MainActivity.database.rawQuery("SELECT * FROM ArirangSongList  WHERE MABH LIKE'"+maso+"'", null);
        txtmaso.setText(maso);
        c.moveToFirst();
        txtbaihat.setText(c.getString(2));
        txtloibaihat.setText(c.getString(3));
        txttacgia.setText(c.getString(4));
        if (c.getInt(6)==0) {
            btnthich.setVisibility(View.INVISIBLE);
            btnkhongthich.setVisibility(View.VISIBLE);
        } else {
            btnkhongthich.setVisibility(View.INVISIBLE);
            btnthich.setVisibility(View.VISIBLE);
        }
        c.close();
        //Xửlý sựkiện khi click vào Button btnthichvàbtnkhongthich
        // Cập nhật dữliệu vào CSDL, thay đổi trạng thái hiển thịcho Button btnthichvà btnkothich
        btnthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 0);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{txtmaso.getText().toString()});
                btnthich.setVisibility(View.INVISIBLE);
                btnkhongthich.setVisibility(View.VISIBLE);
            }
        });
        btnkhongthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 1);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{txtmaso.getText().toString()});
                btnkhongthich.setVisibility(View.INVISIBLE);
                btnthich.setVisibility(View.VISIBLE);
            }
        });
    }
}
