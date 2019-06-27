package com.example.dormitorysystem.adapter;

import android.graphics.Color;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.bean.StudentDetails;
import com.example.dormitorysystem.bean.StudentInfoModel;

import java.util.List;


public class StudentDetailsAdapter extends RecyclerView.Adapter<StudentDetailsAdapter.ViewHolder> {
    private List<StudentDetails> mStuDetList;
    private int i =0;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView student_name,left_name,student_sex,student_num,student_born,student_nation,student_grade,student_campusName,studen_class,student_ruzhuqingkuang;

        public ViewHolder(View view){
            super(view);

            student_name = view.findViewById(R.id.student_name);
            left_name = view.findViewById(R.id.left_name);
//            student_sex = view.findViewById(R.id.student_sex);
//            student_num = view.findViewById(R.id.student_num);
//            student_born = view.findViewById(R.id.student_born);
//            student_nation = view.findViewById(R.id.student_nation);
//            student_grade = view.findViewById(R.id.student_grade);
//            student_campusName = view.findViewById(R.id.student_campusName);
//            studen_class = view.findViewById(R.id.student_class);
//            student_ruzhuqingkuang = view.findViewById(R.id.student_ruzhuqingkuang);
        }
    }

    public StudentDetailsAdapter(List<StudentDetails> studentDetailsList){
        mStuDetList = studentDetailsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_details_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentDetails s = mStuDetList.get(position);
        //判断第九个值，入住情况，若是 未入住，则显示红色
        holder.left_name.setText(s.getLeft_name());
        holder.student_name.setText(s.getRight_name());

        if(i==8){
            if (holder.student_name.getText().equals("")){
                holder.student_name.setText("未入住");
                holder.student_name.setTextColor(Color.parseColor("#894444"));
            }else{
                holder.student_name.setTextColor(Color.parseColor("#68D179"));
            }
        }
        i++;
//        holder.student_name.setText(stu.getStudentName());
//        holder.student_sex.setText(stu.getGenderName());
//        holder.student_num.setText(stu.getStudentNo());
//        holder.student_born.setText(stu.getBirthday());
//        holder.student_nation.setText(stu.getNationName());
//        holder.student_grade.setText(stu.getGradeName());
//        holder.student_campusName.setText(stu.getCampusName());
//        holder.studen_class.setText(stu.getClazzName());
//        holder.student_ruzhuqingkuang.setText(stu.getBuildName()+stu.getAreaName()+stu.getBuildCode());
//        if (holder.student_ruzhuqingkuang.getText().equals("")){
//            holder.student_ruzhuqingkuang.setText("未入住");
//            holder.student_ruzhuqingkuang.setTextColor(Color.parseColor("#894444"));
//        }else{
//            holder.student_ruzhuqingkuang.setTextColor(Color.parseColor("#68D179"));
//        }

    }

    @Override
    public int getItemCount() {
        return mStuDetList.size();
    }


}
