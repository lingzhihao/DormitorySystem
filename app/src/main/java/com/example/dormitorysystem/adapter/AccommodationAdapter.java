package com.example.dormitorysystem.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dormitorysystem.BedDormActivity;
import com.example.dormitorysystem.R;
import com.example.dormitorysystem.bean.Accommodation;

import java.util.List;

public class AccommodationAdapter extends RecyclerView.Adapter<AccommodationAdapter.ViewHolder> {
    private List<Accommodation> mAdtList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View adtView;

        TextView dm_number,dm_type,dm_accmmoadation,adt_number,dm_address,nation_1,nation_2,nation_3,nation_4,nation_5,nation_6;

        public ViewHolder(View view){
            super(view);
            adtView = view;
            dm_number = view.findViewById(R.id.dm_number);//寝室号
            dm_type = view.findViewById(R.id.dm_type);//寝室类型
            dm_accmmoadation = view.findViewById(R.id.dm_accommodation);
            adt_number = view.findViewById(R.id.adt_number);
            dm_address = view.findViewById(R.id.dm_address);
            nation_1 = view.findViewById(R.id.nation_1);
            nation_2 = view.findViewById(R.id.nation_2);
            nation_3 = view.findViewById(R.id.nation_3);
            nation_4 = view.findViewById(R.id.nation_4);
            nation_5 = view.findViewById(R.id.nation_5);
            nation_6 = view.findViewById(R.id.nation_6);
        }
    }

    public AccommodationAdapter(List<Accommodation> adtList){
        mAdtList = adtList;

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accommodation_layout,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        holder.adtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(parent.getContext(), BedDormActivity.class);
                parent.getContext().startActivity(intent);

            }
        });
        return holder;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Accommodation adt = mAdtList.get(position);



        holder.dm_number.setText(adt.getDm_number());
        holder.dm_type.setText(adt.getDm_type());
        holder.dm_accmmoadation.setText(adt.getDm_accommodation());
        holder.adt_number.setText(adt.getAdt_number());
        holder.dm_address.setText(adt.getDm_address());
        holder.nation_1.setText(adt.getNation_1());
        holder.nation_2.setText(adt.getNation_2());
        holder.nation_3.setText(adt.getNation_3());
        holder.nation_4.setText(adt.getNation_4());
        holder.nation_5.setText(adt.getNation_5());
        holder.nation_6.setText(adt.getNation_6());
        if(holder.adt_number.getText().equals("0/6")){
            holder.dm_number.setTextColor(R.color.black);
            holder.adt_number.setTextColor(R.color.black);
        }
        //判断是 男 还是女公寓，
        if(holder.dm_type.getText().equals("男")){
            holder.dm_type.setBackgroundResource(R.drawable.yuan_blue);
        }
        //判断入住人数，1--5人  显示黄色
        if (holder.adt_number.getText().equals("5/6") || holder.adt_number.getText().equals("4/6") || holder.adt_number.getText().equals("3/6")
                || holder.adt_number.getText().equals("2/6") || holder.adt_number.getText().equals("1/6")){
            holder.nation_1.setBackgroundResource(R.drawable.yuan_nation_yellow);
            holder.nation_2.setBackgroundResource(R.drawable.yuan_nation_yellow);
            holder.nation_3.setBackgroundResource(R.drawable.yuan_nation_yellow);
            holder.nation_4.setBackgroundResource(R.drawable.yuan_nation_yellow);
            holder.nation_5.setBackgroundResource(R.drawable.yuan_nation_yellow);
            holder.nation_6.setBackgroundResource(R.drawable.yuan_nation_yellow);
            holder.dm_number.setTextColor(R.color.yellow);
            holder.adt_number.setTextColor(Color.parseColor("#FF9800"));
        }
        //设置民族，如果不为空，则显示
        if(!holder.nation_1.getText().equals("")){
            holder.nation_1.setVisibility(View.VISIBLE);
        }
        if(!holder.nation_2.getText().equals("")){
            holder.nation_2.setVisibility(View.VISIBLE);
        }
        if(!holder.nation_3.getText().equals("")){
            holder.nation_3.setVisibility(View.VISIBLE);
        }
        if(!holder.nation_4.getText().equals("")){
            holder.nation_4.setVisibility(View.VISIBLE);
        }
        if(!holder.nation_5.getText().equals("")){
            holder.nation_5.setVisibility(View.VISIBLE);
        }
        if(!holder.nation_6.getText().equals("")){
            holder.nation_6.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {

        return mAdtList.size();
    }


}
