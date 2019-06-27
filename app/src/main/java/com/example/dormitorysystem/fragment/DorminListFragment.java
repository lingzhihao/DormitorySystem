package com.example.dormitorysystem.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.adapter.AccommodationAdapter;
import com.example.dormitorysystem.bean.Accommodation;

import java.util.ArrayList;
import java.util.List;

public class DorminListFragment extends Fragment {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipe_refresh;
    Handler handler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_dormin_list,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        swipe_refresh = view.findViewById(R.id.bed_shuaxin);
        handler = new Handler();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Accommodation> list = new ArrayList<>();
        Accommodation one = new Accommodation("1-101","女","入住情况","6/6","校区A区域A1栋","汉","彝","藏","苗","土","维",false);
        list.add(one);
        Accommodation tow = new Accommodation("2-238","女","入住情况","4/6","校区A区域A1栋","汉","藏","彝","回",null,null,false);
        list.add(tow);
        Accommodation three = new Accommodation("1-103","男","入住情况","0/6","校区A区域A1栋",null,null,null,null,null,null,false);
        list.add(three);

        recyclerView.setAdapter(new AccommodationAdapter(list));
        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe_refresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
