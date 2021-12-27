package com.example.bai11_haduyanh_listview1;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    String[] myPhone ={"Iphone 7", "SamSung Galaxy S7", "Nokia Lumia 730", "Sony Xperia XZ","HTC One E9"};
    ArrayAdapter<String> myAdapter;
    ListView listviewPhone;
    TextView textviewSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listviewPhone = findViewById(R.id.listviewPhone);
        textviewSelect = findViewById(R.id.textviewSelect);
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myPhone);
        listviewPhone.setAdapter(myAdapter);
        //Bắt sự kiện Click vào Item của Listview
        listviewPhone.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textviewSelect.setText("Vị trí : "+(i+1)+" "+myPhone[i]);
            }
        });
    }
}
