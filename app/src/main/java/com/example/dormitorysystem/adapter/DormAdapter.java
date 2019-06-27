package com.example.dormitorysystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.StudentDetailsActivity;
import com.example.dormitorysystem.bean.Student;
import com.example.dormitorysystem.bean.ValueTest;

import java.util.List;


public class DormAdapter extends RecyclerView.Adapter<DormAdapter.ViewHolder> {
    private List<Student> mStuList;
    private Context mcontext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        View stuView;

        TextView bed_num,stu_nation,stu_name,stu_num,stu_class;

        public ViewHolder(View view){
            super(view);
            stuView = view;
            bed_num = view.findViewById(R.id.bed_num);
            stu_nation = view.findViewById(R.id.stu_nation);
            stu_name = view.findViewById(R.id.stu_name);
            stu_num = view.findViewById(R.id.stu_num);
            stu_class = view.findViewById(R.id.stu_class);
        }
    }

    public DormAdapter(List<Student> adtList){
        mStuList = adtList;

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        if (mcontext ==null){
            mcontext = parent.getContext();
        }
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dorm_layout,parent,false);
        final boolean[] flag = {false};

        final ViewHolder holder = new ViewHolder(view);
        holder.stuView.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                if (holder.stu_name.getText().equals("暂无学生入住!")){
                    if(!flag[0]){
                        view.setBackgroundResource(R.drawable.yuanjiao_blue_kuang);
                        flag[0] = true;
                    }else{
                        view.setBackgroundResource(R.drawable.yuanjiao_recyclerview);
                        flag[0] =false;
                    }
                }else{
                    Toast.makeText(mcontext,"请选择空床位",Toast.LENGTH_SHORT).show();
                }

                /*Intent intent = new Intent(mcontext, StudentDetailsActivity.class);
                mcontext.startActivity(intent);*/
            }


        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student stu = mStuList.get(position);
        holder.bed_num.setText(stu.getBed_num());
        holder.stu_nation.setText(stu.getStu_nation());
        holder.stu_name.setText(stu.getStu_name());
        holder.stu_num.setText(stu.getStu_num());
        holder.stu_class.setText(stu.getStu_class());
        if(holder.stu_name.getText().equals("")){
            holder.bed_num.setBackgroundResource(R.drawable.yuan_blue);
            holder.bed_num.setTextColor(Color.parseColor("#0B89F5"));
            holder.stu_name.setText("暂无学生入住!");
            holder.stu_name.setTextColor(Color.parseColor("#92D6D5D5"));
            holder.stu_nation.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mStuList.size();
    }


}
