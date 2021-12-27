package com.example.haduyanh_doancanhan;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class myarrayAdapter extends ArrayAdapter<Item> {
    Activity context= null;
    ArrayList<Item> myArray= null;
    int LayoutId;
    public myarrayAdapter(Activity context, int LayoutId,ArrayList<Item>arr)
    {
        super(context, LayoutId,arr);
        // TODOAuto-generated constructor stub
        this.context= context;
        this.LayoutId= LayoutId;
        this.myArray= arr;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODOAuto-generated method stub
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);
        final Item myItem = myArray.get(position);
        final TextView tieude = (TextView)convertView.findViewById(R.id.txttieude);
        tieude.setText(myItem.getTieude());
        final TextView maso =(TextView)convertView.findViewById(R.id.txtmaso);
        maso.setText(myItem.getMaso());
        final ImageView btnlike = (ImageView)convertView.findViewById(R.id.btnlike);
        final ImageView btnunlike = (ImageView)convertView.findViewById(R.id.btnunlike);
        int thich = myItem.getThich();
        //Xửlý hiển thịcho ImageButton btnlikevàbtnunlike
        if(thich==0)
        {
            btnlike.setVisibility(View.INVISIBLE);//cho ẩn btnlike
            btnunlike.setVisibility(View.VISIBLE);//cho hiển thịbtnunlike
        } else
            {
            btnunlike.setVisibility(View.INVISIBLE);//cho ẩnbtnunlike
            btnlike.setVisibility(View.VISIBLE);//cho hiệnbtnlike
        }
        // Xửlý sựkiện khi click vào ImageButton btnlikevàbtnunlike
        // Cập nhật trạng thái thich vào CSDL; Thiết lập ImageButton cho phù hợp
        btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 0);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{maso.getText().toString()});
                btnlike.setVisibility(View.INVISIBLE);
                btnunlike.setVisibility(View.VISIBLE);
            }
        });
        btnunlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 1);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{maso.getText().toString()});
                btnunlike.setVisibility(View.INVISIBLE);
                btnlike.setVisibility(View.VISIBLE);
            }
        });
        //Xửlý sựkiện khi Click vào mỗi dòng tiều đềbài hát trên Listview
        // Chuyển Textview tieudevà masosang màu đỏ
        // Khai báo Intent, Bundle,lấy masotruyền qua subactivityvà gọi activitysub
        tieude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tieude.setTextColor(Color.RED);
                maso.setTextColor(Color.RED);
                Intent intent1 = new Intent(context,activitysub.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("maso", maso.getText().toString());
                intent1.putExtra("package", bundle1);
                context.startActivity(intent1);
            }
        });
        return convertView;
    }
}
