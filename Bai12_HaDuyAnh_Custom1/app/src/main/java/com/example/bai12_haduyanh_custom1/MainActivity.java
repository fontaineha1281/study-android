package com.example.bai12_haduyanh_custom1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int imagePhone[] = {R.drawable.ip,R.drawable.samsung,R.drawable.lg,R.drawable.htc,R.drawable.wp,R.drawable.sky};
    String namePhone[] = {"Điện thoại Iphone","Điện thoại Samsung","Điện thoại LG","Điện thoại HTC","Điện thoại WindowsPhone","Điện thoại Sky"};
    ArrayList<Phone> myList;
    myArrayAdapter myAdapter;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);
        //Tạo mảng chính
        myList = new ArrayList<>();
        //thêm 2 mảng chính
        for (int i=0; i< imagePhone.length; i++)
        {
            myList.add(new Phone(imagePhone[i],namePhone[i]));

        }
        //tạo adapter
        myAdapter = new myArrayAdapter(MainActivity.this,R.layout.layout_item,myList);
        //đưa adapter lên Listview
        lv1.setAdapter(myAdapter);
        //xử lí click vào listview
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(MainActivity.this,SubActivity.class);
                intent1.putExtra("name",namePhone[position]);//position = i
                startActivity(intent1);
            }
        });
    }
}