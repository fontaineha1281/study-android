package com.example.bai12_haduyanh_custom1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class myArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    ArrayList<Phone> myList;
    int idLayout;
    //Tạo constructor để Mainactvity gọi đến và truyền các tham số vào
    public myArrayAdapter(Activity context, int idLayout,  ArrayList<Phone> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.myList = myList;
        this.idLayout = idLayout;
    }
    //gọi hàm getView để tiến hành sắp xếp dữ liệu
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //tạo đế chứa layout
        LayoutInflater myFlactor = context.getLayoutInflater();
        //đặt layout lên đế tạo thành đối tượng view
        convertView = myFlactor.inflate(idLayout, null);
        //lấy dữ liệu trong mảng
        Phone myPhone = myList.get(position);
        //tiến hành sắp xếp dữ liệu
        ImageView imagePhone = convertView.findViewById(R.id.imagePhone);
        imagePhone.setImageResource(myPhone.getImgPhone());
        //tiến hành hiển thị dữ liệu lên điện thoại
        TextView textViewPhone = convertView.findViewById(R.id.txt_subphone);
        textViewPhone.setText(myPhone.getNamePhone());
        return convertView;
    }
}
