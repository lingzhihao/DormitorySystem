package com.example.dormitorysystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.bean.SelectionClass;

import java.util.List;

public class SelectClassAdapter extends RecyclerView.Adapter<SelectClassAdapter.ViewHolder> {
    private List<SelectionClass> mClassList;
    private Context mcontext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        View classView;
        TextView className;
        public ViewHolder(View view){
            super(view);
            classView = view;
            className = (TextView) view.findViewById(R.id.class_select_item);
        }
    }

    public SelectClassAdapter(List<SelectionClass> classList){
        mClassList = classList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mcontext ==null){
            mcontext = parent.getContext();
        }
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_class_layout,parent,false);

        final boolean[] flag = {false};
        final ViewHolder holder = new ViewHolder(view);
        holder.classView.setOnClickListener(new View.OnClickListener() {
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
        SelectionClass sc = mClassList.get(position);
        holder.className.setText(sc.getClass_name());
    }

    @Override
    public int getItemCount() {
        return mClassList.size();
    }


}
