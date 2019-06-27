package com.example.dormitorysystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.bean.LouDong;

import java.util.List;


public class SelectLoudongAdapter extends RecyclerView.Adapter<SelectLoudongAdapter.ViewHolder> {
    private List<LouDong> mLoudongList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView loudongName;
        View loudongView;

        public ViewHolder(View view){
            super(view);
            loudongView = view;
            loudongName = (TextView) view.findViewById(R.id.loudog_select_item);
        }
    }

    public SelectLoudongAdapter(List<LouDong> loudongList){
        mLoudongList = loudongList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_loudong_layout,parent,false);
        final boolean[] flag = {false};

        final ViewHolder holder = new ViewHolder(view);
        holder.loudongView.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LouDong loudong = mLoudongList.get(position);
        holder.loudongName.setText(loudong.getLoudong_name());
    }

    @Override
    public int getItemCount() {
        return mLoudongList.size();
    }


}
