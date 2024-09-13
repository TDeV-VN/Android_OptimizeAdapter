package com.example.bai1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bai1.R;
import com.example.bai1.object.Staff;

import java.util.ArrayList;

public class StaffAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Staff> staffs;

    public StaffAdapter(Context context, ArrayList<Staff> staffs) {
        this.context = context;
        this.staffs = staffs;
    }

    @Override
    public int getCount() {
        return staffs.size();
    }

    @Override
    public Object getItem(int i) {
        return staffs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        TextView tvName;
        TextView tvDepartment;
        ImageView ivDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();//liên kết với layout
        ViewHolder holder = new ViewHolder();
        if (view == null) {
            view = inflater.inflate(R.layout.staff_item, viewGroup, false);
            holder.tvName = view.findViewById(R.id.tvName);
            holder.tvDepartment = view.findViewById(R.id.tvDepartment);
            holder.ivDelete = view.findViewById(R.id.ivDelete);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //set dữ liệu
        Staff staff = staffs.get(i);
        holder.tvName.setText(staff.getName());
        holder.tvDepartment.setText(staff.getDepartment());

        // sự kiện xóa
        holder.ivDelete.setOnClickListener(v1 -> {
            staffs.remove(i);
            notifyDataSetChanged();
        });

        return view;
    }

}
