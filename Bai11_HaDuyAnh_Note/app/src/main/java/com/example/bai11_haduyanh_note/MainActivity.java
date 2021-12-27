package com.example.bai11_haduyanh_note;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textDate;
    Button buttonAdd,buttonEdit,buttonDelete;
    EditText editWork, editHour, editMinute;
    ListView listview1;
    ArrayAdapter<String> arrAdapter;
    ArrayList<String> arrWork;
    int location = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDate = findViewById(R.id.textDate);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonDelete = findViewById(R.id.buttonDelete);
        editWork = findViewById(R.id.editWork);
        editHour = findViewById(R.id.editHour);
        editMinute = findViewById(R.id.editMinute);
        listview1 = findViewById(R.id.listview1);
        //Ởđây chúng ta không sử dụng dữ liệu cốđịnh, mà dữ liệu của
        //Listview được cập nhật trong quá trình chạy, nên ởđây ta //khai báo mảng ArrayList kiểu String rỗng
        arrWork = new ArrayList<String>();
        //Khai báo ArrayAdapter, đưa mảng dữ liệu vào ArrayAdapter
        arrAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrWork);
        //Đưa Adapter có dữ liệu lên Listview
        listview1.setAdapter(arrAdapter);
        Date currentDate = Calendar.getInstance().getTime();
        //Format theo định dạng dd/mm/yyyy
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        //Hiển thị lên TextView
        textDate.setText("Hôm Nay: "+simpleDateFormat.format(currentDate));
        //buttonAdd
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Nếu 1 trong 3 Edit Text không có nội dung thì hiện lên thông báo bằng hộp thoại Dialog
                if (editWork.getText().toString().equals("") || editHour.getText().toString().equals("") || editMinute.getText().toString().equals("")) {
                    AlertDialog.Builder alertShow = new AlertDialog.Builder(MainActivity.this);
                    alertShow.setTitle("Bạn điền thiếu thông tin");
                    alertShow.setMessage("Hãy điền lại đầy đủ thông tin để tiếp tục");
                    alertShow.setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                                //Nothing here
                        }
                    });
                    alertShow.show();
                }
                //Lấy nội dung công việc và thời gian ra từEdit Text và đưa vào Mảng arraywork, cập nhật lại Adapter
                else {
                    String str = editWork.getText().toString()+" - "+editHour.getText().toString()+":"+editMinute.getText().toString();
                    arrWork.add(str);
                    arrAdapter.notifyDataSetChanged();
                    editHour.setText("");
                    editMinute.setText("");
                    editWork.setText("");
                }
            }
        });
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editWork.setText(arrWork.get(i));
                location = i;
            }
        });
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrWork.set(location,editWork.getText().toString()+" - "+editHour.getText().toString()+":"+editMinute.getText().toString());
                arrAdapter.notifyDataSetChanged();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrWork.remove(location);
                arrAdapter.notifyDataSetChanged();
                editHour.setText("");
                editMinute.setText("");
                editWork.setText("");
            }
        });
    }
}