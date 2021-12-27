package com.example.bai14_haduyanh_tab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editA, editB;
    Button buttonPlus;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    ListView listView1;
    TabHost myTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                int c = a+b;
                mylist.add(a+" + "+b+" = "+c);
                myadapter.notifyDataSetChanged();
            }
        });
    }

    private void addControl() {
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        buttonPlus = findViewById(R.id.buttonPlus);
        //
        listView1 = findViewById(R.id.listView1);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,mylist);
        listView1.setAdapter(myadapter);
        //xử lí tab
        myTabHost = findViewById(R.id.myTabHost);
        //gọi lệnh setup
        myTabHost.setup();
        //khai báo các tab con
        TabHost.TabSpec spec1,spec2;
        //ứng với mỗi tab con, chúng ta có 4 việc cần làm
        spec1 = myTabHost.newTabSpec("tab1");//tạo mới tab
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("",getResources().getDrawable(R.drawable.cong));//thiết lập nhãn or icon
        myTabHost.addTab(spec1);//thêm tab con vào tab chính
        spec2 = myTabHost.newTabSpec("tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("",getResources().getDrawable(R.drawable.lichsu));
        myTabHost.addTab(spec2);

    }
}