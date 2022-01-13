package com.example.haduyanh_final_exam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSach extends BaseAdapter {
    Activity context;
    ArrayList<Sach> list;

    public AdapterSach(Activity context, ArrayList<Sach> list) {
        this.context = context;
        this.list = list;
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_row,null);
        TextView txtMaSach = (TextView) row.findViewById(R.id.txtMaSo);
        TextView txtTenSach = (TextView) row.findViewById(R.id.txtTenSach);
        TextView txtTacGia = (TextView) row.findViewById(R.id.txtTacGia);
        TextView txtNamXB = (TextView) row.findViewById(R.id.txtNamXB);
        TextView txtSoLuong = (TextView) row.findViewById(R.id.txtSoLuong);
        Button buttonSua = (Button) row.findViewById(R.id.buttonThem);
        Button buttonXoa = (Button) row.findViewById(R.id.buttonHuy);

        final Sach sachQL = list.get(position);
        txtMaSach.setText(sachQL.masach);
        txtTenSach.setText(sachQL.tensach);
        txtTacGia.setText(sachQL.tentacgia);
        txtNamXB.setText(sachQL.namxb + "");
        txtSoLuong.setText(sachQL.soluong + "");

        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("masach",sachQL.masach);
                context.startActivity(intent);
            }
        });
        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder xoa = new AlertDialog.Builder(context);
                xoa.setIcon(android.R.drawable.ic_delete);
                xoa.setTitle("Xác nhận xoá");
                xoa.setMessage("Bạn có chắc muốn xoá quyển sách này?");
                xoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete(sachQL.masach);
                    }
                });
                xoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = xoa.create();
                dialog.show();
            }
        });

        return row;
    }

    private void delete(String maSach) {
        SQLiteDatabase database = Database.initDatabase(context,"dbqlsach.db");
        database.delete("tablesach","masach = ?",new String[]{maSach});
        list.clear();
        Cursor cursor = database.rawQuery("SELECT * FROM tablesach",null);
        while (cursor.moveToNext()) {
            String masach = cursor.getString(0);
            String tensach = cursor.getString(1);
            String tentacgia = cursor.getString(2);
            int namxb = cursor.getInt(3);
            int soluong = cursor.getInt(4);
            list.add(new Sach(masach,tensach,tentacgia,namxb,soluong));
        }
        notifyDataSetChanged();
    }
}
