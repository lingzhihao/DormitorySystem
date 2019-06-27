package com.example.dormitorysystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dormitorysystem.adapter.AccommodationAdapter;
import com.example.dormitorysystem.adapter.AccommodationOkGoAdapter;
import com.example.dormitorysystem.adapter.StudentDetailsAdapter;
import com.example.dormitorysystem.bean.Accommodation;
import com.example.dormitorysystem.bean.DormListModel;
import com.example.dormitorysystem.bean.StudentDetails;
import com.example.dormitorysystem.callback.StringDialogCallback;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class StudentBedAllocationActivity extends AppCompatActivity implements View.OnClickListener {
    private List<AccommodationOkGoAdapter> adtList = new ArrayList<>();
    private List<StudentDetails> stuDtList =  new ArrayList<>();
    private ImageView back;
    private AccommodationOkGoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_bed_allocation);

        initList();
        back = (ImageView) findViewById(R.id.student_details_back);
        back.setOnClickListener(this);


        //学生详细信息列表
//        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view_student_details);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView1.setLayoutManager(layoutManager);
//        StudentDetailsAdapter adapter1 = new StudentDetailsAdapter(stuDtList);
//        recyclerView1.setAdapter(adapter1);

        //寝室分配列表
//        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view_fenpei);
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
//        recyclerView1.setLayoutManager(layoutManager1);
//        AccommodationAdapter adapter1 = new AccommodationAdapter(adtList);
//        recyclerView1.setAdapter(adapter1);


        //获取保存到的Token
        SharedPreferences pref = getSharedPreferences("loginToken",0);
        String token = pref.getString("token","");
        //主界面数据，获取返回的json，解析数组
        OkGo.<String>post("http://zyd.cdzhiyong.com:51337/v1/api/zydxgMobile/BedApi/getDormPage?")
                .headers("Authorization","Bearer" + token)
                .params("pageNo",1)
                .params("pageSize",10)
                .execute(new StringDialogCallback(StudentBedAllocationActivity.this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
//                        String str = response.body();
                        DormListModel dormListModel = gson.fromJson(response.body(), DormListModel.class);
//                        Toast.makeText(BedAllocationActivity.this,str,Toast.LENGTH_SHORT).show();
                        List<DormListModel.RowsBean> list = new ArrayList<>();

                        //向recyclerview传入数据,直接使用接收的gson数据
                        adapter  = new AccommodationOkGoAdapter(dormListModel.getRows());
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_fenpei);
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(StudentBedAllocationActivity.this);
                        recyclerView.setLayoutManager(layoutManager1);
                        recyclerView.setAdapter(adapter);

                        //上滑加载更多
                        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged( RecyclerView recyclerView, int newState) {
                                super.onScrollStateChanged(recyclerView, newState);
                                int lastPosition = -1;
                                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                                lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                                if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                                    Toast.makeText(StudentBedAllocationActivity.this,"加载更多",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onScrolled( RecyclerView recyclerView, int dx, int dy) {
                                super.onScrolled(recyclerView, dx, dy);
                            }
                        });
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student_details_back:
                finish();
                break;

            default:
                break;
        }
    }

    private void initList(){
        StudentDetails stu_name = new StudentDetails("姓名","凌志豪");
        StudentDetails stu_sex = new StudentDetails("性别","男");
        StudentDetails stu_number = new StudentDetails("学号","17301055");
        StudentDetails stu_bornDate = new StudentDetails("出生日期","1998-11-18");
        StudentDetails stu_nation = new StudentDetails("民族","汉");
        StudentDetails stu_grade = new StudentDetails("年级","2017级");
        StudentDetails stu_college = new StudentDetails("学院","四川信息职业技术学院");
        StudentDetails stu_class = new StudentDetails("班级","软件4班");
        StudentDetails stu_dromSituation = new StudentDetails("住宿情况","未入住");
        stuDtList.add(stu_name);
        stuDtList.add(stu_sex);
        stuDtList.add(stu_number);
        stuDtList.add(stu_bornDate);
        stuDtList.add(stu_nation);
        stuDtList.add(stu_grade);
        stuDtList.add(stu_college);
        stuDtList.add(stu_class);
        stuDtList.add(stu_dromSituation);


        //寝室list数据
//        for (int i = 0; i < 4; i++) {
//            Accommodation one = new Accommodation("1-101","女","入住情况","6/6","校区A区域A1栋","汉","彝","藏","苗","土","维",false);
//            adtList.add(one);
//            Accommodation tow = new Accommodation("2-238","女","入住情况","4/6","校区A区域A1栋","汉","藏","彝","回",null,null,false);
//            adtList.add(tow);
//            Accommodation three = new Accommodation("1-103","男","入住情况","0/6","校区A区域A1栋",null,null,null,null,null,null,false);
//            adtList.add(three);
//        }


    }
}
