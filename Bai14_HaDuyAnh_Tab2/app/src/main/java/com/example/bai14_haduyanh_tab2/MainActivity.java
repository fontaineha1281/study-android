package com.example.bai14_haduyanh_tab2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String DB_PATH_SUFFIX= "/databases/";
    public static SQLiteDatabase database=null;
    public static String DATABASE_NAME="arirang.sqlite";
    EditText editNameSong;
    ListView listView1,listView2,listView3;
    TabHost tabHost;
    ArrayList<Item> list1,list2,list3;
    myarrayadapter myarray1,myarray2,myarray3;
    ImageButton buttonDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processCopy();
        //Mởcởsởdữliệu đã copy. Lưu vào biến database
        database= openOrCreateDatabase("arirang.sqlite", MODE_PRIVATE, null);
        addControl();//Hàm thêm các Controls
        addEvent();//Xửlý sựkiện khi chuyển Tab và các sựkiện khác
        addSearch();//Xửlý sựkiện khi chuyển Tab và các sựkiện khác
    }
    //Hàm khai báo và Add các Controls vào giao diện
    // Trên 3 Tab chúng ta có 3 ListView ứng với 3 Danh sách dữliệu (Dữliệu tìm kiếm,
    // Danhách bài hát gốc, Danh sách bài hát yêu thích) và Adapter riêng
    private void addControl()
    {
        buttonDelete = findViewById(R.id.buttonDelete);
        tabHost=(TabHost)findViewById(R.id.myTabHost);
        tabHost.setup();
        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("",getResources().getDrawable(R.drawable.search));
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("",getResources().getDrawable(R.drawable.list));
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("t3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("",getResources().getDrawable(R.drawable.favourite));
        tabHost.addTab(tab3);
        editNameSong=(EditText) findViewById(R.id.editNameSong);
        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        listView3 = (ListView) findViewById(R.id.listView3);
        list1=new ArrayList<Item>();
        list2=new ArrayList<Item>();
        list3=new ArrayList<Item>();
        myarray1 = new myarrayadapter(MainActivity.this,R.layout.customlistview,list1);
        myarray2 = new myarrayadapter(MainActivity.this,R.layout.customlistview,list2);
        myarray3 = new myarrayadapter(MainActivity.this,R.layout.customlistview,list3);
        listView1.setAdapter(myarray1);
        listView2.setAdapter(myarray2);
        listView3.setAdapter(myarray3);
    }
    //Xửlý sựkiện khi chuyển qua lại giữa các Tab Danh sáchvà Yêu Thích
    private void addEvent() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t2")) {
                    addDanhSach();
                }
                if (tabId.equalsIgnoreCase("t3")) {
                    addYeuThich();
                }
            }
        });
        // Sựkiện khi Click vào Button xóatrên Tab Tìm kiếm
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNameSong.setText("");
            }
        });
    }
        //Hàm thêm bài hát vào Listview trên Tab Yêu thích
        private void addYeuThich()
        {
            myarray3.clear();
            Cursor cursor = database.rawQuery("SELECT * FROM ArirangSongList  WHERE YEUTHICH = 1", null);
            cursor.moveToFirst();
            while(cursor.isAfterLast()==false)
            {
                list3.add(new Item(cursor.getString(1),cursor.getString(2),cursor.getInt(6)));
                cursor.moveToNext();
            }
            cursor.close();
            myarray3.notifyDataSetChanged();
        }
    //Hàm thêm bài hát vào Listview trên Tab Danh sách bài hát
         private void addDanhSach()
         {
             myarray2.clear();
             Cursor cursor = database.rawQuery("SELECT * FROM ArirangSongList", null);
             cursor.moveToFirst();
             while(cursor.isAfterLast()==false)
             {
                 list2.add(new Item(cursor.getString(1),cursor.getString(2),cursor.getInt(6)));
                 cursor.moveToNext();
             }
             cursor.close();
             myarray2.notifyDataSetChanged();
         }
    //Hàm xửlý tìm kiếm bài hát theo Tiêu đềvà Mã số
          private void addSearch()
             {
                 //Sựkiện khi Thay đổi Text trong editNameSong
                 editNameSong.addTextChangedListener(new TextWatcher() {
                     public void onTextChanged(CharSequence s, int start, int before, int count)
                     {
                         getdata();
                     }

                     private void getdata()
                     {
                         String dulieunhap =editNameSong.getText().toString();
                         myarray1.clear();
                         if (!editNameSong.getText().toString().equals(""))
                         {
                             Cursor c = database.rawQuery("SELECT * FROM ArirangSongList WHERE TENBH1 LIKE '"+"%"+dulieunhap+"%"+"' OR MABH LIKE '"+"%"+dulieunhap+"%"+"'", null);
                             c.moveToFirst();
                             while(c.isAfterLast()==false)
                             {
                                 list1.add(new Item(c.getString(1),c.getString(2),c.getInt(6)));
                                 c.moveToNext();
                             }
                             c.close();
                         }
                            myarray1.notifyDataSetChanged();
                     }
                     public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                     }
                     public void afterTextChanged(Editable s)
                     {

                     }
                 });
             }
    //Hàm xửlý Copy CS dữliệu từthư mục assets vào hệthống thư mục cài đặt
    private void processCopy() {
        //private app
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try{CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }
    public void CopyDataBaseFromAsset() {
        // TODO Auto-generated method stub
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
            // Path to the just created empty db
            String outFileName = getDatabasePath();
            //if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ((InputStream) myInput).read(buffer)) > 0)
            {
                myOutput.write(buffer, 0, length);
            }
            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
