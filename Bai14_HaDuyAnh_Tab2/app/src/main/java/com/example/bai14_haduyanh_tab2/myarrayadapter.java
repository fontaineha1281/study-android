package com.example.bai14_haduyanh_tab2;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myarrayadapter extends ArrayAdapter<Item> {
    Activity context = null;
    ArrayList<Item>myArray = null;
    int layoutId;
    public myarrayadapter (Activity context, int layoutId, ArrayList<Item>arrayList)
    {
        super(context,layoutId,arrayList);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =  context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        final Item myItem = myArray.get(position);
        final ImageView buttonLike = (ImageView)convertView.findViewById(R.id.buttonLikeSong);
        final ImageView buttonUnLike = (ImageView)convertView.findViewById(R.id.buttonUnLikeSong);
        final TextView title = (TextView)convertView.findViewById(R.id.textNumber);
        title.setText(myItem.getTieuDe());
        final TextView number = (TextView)convertView.findViewById(R.id.textNumber);
        number.setText(myItem.getMaSo());
        int like = myItem.getLike();
            if (like==0)
            {
                buttonLike.setVisibility(View.INVISIBLE);//ẨN NÚT LIKE
                buttonUnLike.setVisibility(View.VISIBLE);//Hiển thị unlike
            }
             else
            {
                buttonLike.setVisibility(View.VISIBLE);//ẨN NÚT LIKE
                buttonUnLike.setVisibility(View.INVISIBLE);//Hiển thị like
            }

        // Xửlý sựkiện khi click vào ImageButton btnlikevàbtnunlike
        // Cập nhật trạng thái thich vào CSDL; Thiết lập ImageButton cho phù hợp
        buttonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values= new ContentValues();
                values.put("YEUTHICH",0);
                MainActivity.database.update("ArirangSongList",values,"MABH=?",new String[]{number.getText().toString()});
                buttonUnLike.setVisibility(View.INVISIBLE);
                buttonLike.setVisibility(View.VISIBLE);
            }
        });
        buttonUnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 1);
                MainActivity.database.update("ArirangSongList", values,"MABH=?", new String[]{number.getText().toString()});
                buttonUnLike.setVisibility(View.INVISIBLE);
                buttonLike.setVisibility(View.VISIBLE);
            }
        });
        //Xửlý sựkiện khi Click vào mỗi dòng tiều đềbài hát trên Listview/
        // /Chuyển Textview tieudevà masosang màu đỏ
        // Khai báo Intent, Bundle,lấy masotruyền qua subactivityvà gọi activitysub
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setTextColor(Color.RED);
                number.setTextColor(Color.RED);
                Intent intent1 = new Intent(context,subactivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("maso", number.getText().toString());
                intent1.putExtra("package", bundle1);
                context.startActivity(intent1);
            }
        });
        return convertView;
    }
}
