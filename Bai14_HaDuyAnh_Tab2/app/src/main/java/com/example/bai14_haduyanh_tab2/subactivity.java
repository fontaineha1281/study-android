package com.example.bai14_haduyanh_tab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class subactivity extends AppCompatActivity {
    TextView textMaSo,textBaiHat,textLyric,textArtist;
    ImageButton buttonLikeSong,buttonUnLikeSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
        textMaSo = findViewById(R.id.textMaSo);
        textBaiHat = findViewById(R.id.textBaiHat);
        textArtist = findViewById(R.id.textArtist);
        textLyric = findViewById(R.id.textLyric);
        buttonLikeSong = findViewById(R.id.buttonLikeSong);
        buttonUnLikeSong = findViewById(R.id.buttonUnLikeSong);
        //Nhận Intent từmyarrayAdapter, lấy dữliệu khỏi Bundle
        Intent callerIntent1 = getIntent();
        Bundle backagecaller1 = callerIntent1.getBundleExtra("package");
        String maso = backagecaller1.getString("maso");
        //Truy vấn dữliệu từmasonhận được; Hiển thịdữliệu Mã bài hát, Tên bài hát, Lời bài hát , Tác giả, Trạng thái Thích lên activitysub
        Cursor c = MainActivity.database.rawQuery("SELECT * FROM ArirangSongList  WHERE MABH LIKE'"+maso+"'", null);
        textMaSo.setText(maso);
        c.moveToFirst();
        textBaiHat.setText(c.getString(2));
        textLyric.setText(c.getString(3));
        textArtist.setText(c.getString(4));
        if(c.getInt(6)==0)
            {
                buttonUnLikeSong.setVisibility(View.VISIBLE);
                buttonLikeSong.setVisibility(View.INVISIBLE);
            }
        else
            {
                buttonUnLikeSong.setVisibility(View.INVISIBLE);
                buttonLikeSong.setVisibility(View.VISIBLE);
            }
        c.close();
        //Xửlý sựkiện khi click vào Button
        //Cập nhật dữliệu vào CSDL, thay đổi trạng thái hiển thịcho Button
        buttonLikeSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 0);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{textMaSo.getText().toString()});
                buttonLikeSong.setVisibility(View.INVISIBLE);
                buttonUnLikeSong.setVisibility(View.VISIBLE);
            }
        });
        buttonUnLikeSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 1);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{textMaSo.getText().toString()});
                buttonLikeSong.setVisibility(View.VISIBLE);
                buttonUnLikeSong.setVisibility(View.INVISIBLE);
            }
        });
    }
}