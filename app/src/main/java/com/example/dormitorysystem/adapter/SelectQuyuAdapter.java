package com.example.dormitorysystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.bean.Quyu;

import java.util.List;


public class SelectQuyuAdapter extends RecyclerView.Adapter<SelectQuyuAdapter.ViewHolder> {
    private List<Quyu> mQuyuList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quyu_Name;
        View quyuView;
        public ViewHolder(View view){
            super(view);
            quyuView = view;
            quyu_Name = (TextView) view.findViewById(R.id.quyu_select_item);
        }
    }

    public SelectQuyuAdapter(List<Quyu> quyuList){
        mQuyuList = quyuList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_quyu_layout,parent,false);
        final boolean[] flag = {false};

        final ViewHolder holder = new ViewHolder(view);
        holder.quyuView.setOnClickListener(new View.OnClickListener() {
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
        Quyu quyu = mQuyuList.get(position);
        holder.quyu_Name.setText(quyu.getQuyu_name());
    }

    @Override
    public int getItemCount() {
        return mQuyuList.size();
    }


}
