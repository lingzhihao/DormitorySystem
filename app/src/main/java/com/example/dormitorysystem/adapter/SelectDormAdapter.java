package com.example.dormitorysystem.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.bean.Dorm;

import java.util.List;

public class SelectDormAdapter extends RecyclerView.Adapter<SelectDormAdapter.ViewHolder> {
    private List<Dorm> mDormList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View adtView;
        TextView dm_number;

        public ViewHolder(View view){
            super(view);
            adtView = view;
            dm_number = view.findViewById(R.id.dorm_select_item);
        }
    }

    public SelectDormAdapter(List<Dorm> dormList){
        mDormList = dormList;

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_dorm_layout,parent,false);
        final boolean[] flag = {false};
        final ViewHolder holder = new ViewHolder(view);
        holder.adtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag[0]){
                    view.setBackgroundResource(R.drawable.cebianlan_dorm_biankuang_blue);
                    flag[0] = true;
                }else{
                    view.setBackgroundResource(R.drawable.cebianlan_dorm_biankuang_gray);
                    flag[0] =false;
                }
            }
        });
        return holder;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dorm dorm = mDormList.get(position);
        holder.dm_number.setText(dorm.getDorm_num());
    }

    @Override
    public int getItemCount() {
        return mDormList.size();
    }


}
