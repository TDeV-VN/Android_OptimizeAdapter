package com.example.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bai1.adapter.StaffAdapter;
import com.example.bai1.object.Staff;

import java.util.ArrayList;

public class Bai1Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvStaffs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        // ánh xạ view
        lvStaffs = findViewById(R.id.lvStaffs);

        // tạo dữ liệu mẫu
        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("Nguyễn Văn A", "Kế toán"));
        staffs.add(new Staff("Trần Thị B", "Nhân sự"));
        staffs.add(new Staff("Lê Văn C", "Kỹ thuật"));
        staffs.add(new Staff("Phạm Thị D", "Marketing"));
        staffs.add(new Staff("Nguyễn Văn E", "Kinh doanh"));
        staffs.add(new Staff("Trần Thị F", "Kế toán"));
        staffs.add(new Staff("Lê Văn G", "Nhân sự"));
        staffs.add(new Staff("Phạm Thị H", "Kỹ thuật"));
        staffs.add(new Staff("Nguyễn Văn I", "Marketing"));
        staffs.add(new Staff("Trần Thị J", "Kinh doanh"));
        staffs.add(new Staff("Lê Văn K", "Kế toán"));
        staffs.add(new Staff("Phạm Thị L", "Nhân sự"));
        staffs.add(new Staff("Nguyễn Văn M", "Kỹ thuật"));

        // adapter
        StaffAdapter adapter = new StaffAdapter(this, staffs);
        lvStaffs.setAdapter(adapter);

        // sự kiện click item
        lvStaffs.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Staff staff = (Staff) adapterView.getItemAtPosition(i);
        Toast.makeText(this, staff.getName(), Toast.LENGTH_SHORT).show();
    }
}