package com.example.dormitorysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dormitorysystem.adapter.StudentDetailsAdapter;
import com.example.dormitorysystem.bean.StudentDetails;
import com.example.dormitorysystem.bean.StudentInfoModel;
import com.example.dormitorysystem.bean.ValueTest;
import com.example.dormitorysystem.callback.StringDialogCallback;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {
    private ImageView back;
    private List<StudentDetails> stuDtList =  new ArrayList<>();
    private String[] left_list = {"姓名","性别","学号","出生日期","民族","年级","学院","班级","住宿情况"};
    private String[] right_list={};
    private StudentDetailsAdapter adapter;
    private RecyclerView recyclerView;
    private List<StudentInfoModel> stuList = new ArrayList<>();
    private StudentInfoModel stu;
    private TextView textView;
    private Button okBtn;
    private int bedId,studentId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        getOkPost();

        back = findViewById(R.id.student_details_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        //显示寝室号
        textView = findViewById(R.id.tv_confirm_label);
        textView.setText("");

        //确定分配

        bedId = ValueTest.bedId;

        okBtn = findViewById(R.id.dorm_allocation_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取保存到的Token
                SharedPreferences pref = getSharedPreferences("loginToken",0);
                String token = pref.getString("token","");
                //主界面数据，获取返回的json，解析数组
                OkGo.<String>post("http://183.223.236.6:51337/v1/api/zydxgMobile//BedApi/allocationBed")
                        .headers("Authorization","Bearer" + token)
                        .params("studentId",studentId)
                        .params("bedId",bedId)
                        .execute(new StringDialogCallback(StudentDetailsActivity.this) {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Toast.makeText(StudentDetailsActivity.this,response.body(),Toast.LENGTH_LONG).show();
                            }
                });
                Intent intent1 = new Intent(StudentDetailsActivity.this,DormOkStudentActivity.class);
                startActivity(intent1);
            }
        });





    }

    private void getOkPost(){
        //接收传递的身份证号
        Intent intent = getIntent();
        String idCard = intent.getStringExtra("idCard");
        //获取保存到的Token
        SharedPreferences pref = getSharedPreferences("loginToken",0);
        String token = pref.getString("token","");
        //主界面数据，获取返回的json，解析数组
        OkGo.<String>post("http://183.223.236.6:51337/v1/api/zydxgMobile/BedApi/queryStudentBedInfoByIdCard")
                .headers("Authorization","Bearer" + token)
                .params("idCard",idCard)
                .execute(new StringDialogCallback(StudentDetailsActivity.this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body();
                        Toast.makeText(StudentDetailsActivity.this, str, Toast.LENGTH_LONG).show();
                        stu = gson.fromJson(str, StudentInfoModel.class);
                        StudentDetails stu_name = new StudentDetails("姓名",stu.getStudentName() );
                        StudentDetails stu_sex = new StudentDetails("性别", stu.getGenderName());
                        StudentDetails stu_number = new StudentDetails("学号", stu.getStudentNo());
                        StudentDetails stu_bornDate = new StudentDetails("出生日期", stu.getBirthday());
                        StudentDetails stu_nation = new StudentDetails("民族", stu.getNationName());
                        StudentDetails stu_grade = new StudentDetails("年级", stu.getGradeName());
                        StudentDetails stu_college = new StudentDetails("学院", stu.getCampusName());
                        StudentDetails stu_class = new StudentDetails("班级", stu.getClazzName());
                        StudentDetails stu_dromSituation = new StudentDetails("住宿情况", stu.getBuildName()+stu.getAreaName()+stu.getBuildCode());
                        stuDtList.add(stu_name);
                        stuDtList.add(stu_sex);
                        stuDtList.add(stu_number);
                        stuDtList.add(stu_bornDate);
                        stuDtList.add(stu_nation);
                        stuDtList.add(stu_grade);
                        stuDtList.add(stu_college);
                        stuDtList.add(stu_class);
                        stuDtList.add(stu_dromSituation);

                        adapter  = new StudentDetailsAdapter(stuDtList);
                        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_student_details);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(StudentDetailsActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);

                        studentId = stu.getStudentId();
                    }
                });
            }


}
