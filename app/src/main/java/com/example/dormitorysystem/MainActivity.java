package com.example.dormitorysystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView cwfp_img,cwdhjl_img,cwfpset_img,qd_img,kqset_img,wgtj_img,yckhsq_img,myself_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this).init();
        cwfp_img = findViewById(R.id.chuangweifenpei_index);
        cwdhjl_img = findViewById(R.id.chuangweidiaohuanjilu_index);
        cwfpset_img = findViewById(R.id.chuangweifenpeishezhi_index);
        qd_img = findViewById(R.id.wodeqiandao_index);
        kqset_img = findViewById(R.id.kaoqinshezhi_index);
        wgtj_img = findViewById(R.id.wanguitongji_index);
        yckhsq_img = findViewById(R.id.yichangkaoheshenqing);
        myself_img = findViewById(R.id.myself_home);

        cwfp_img.setOnClickListener(this);
        cwdhjl_img.setOnClickListener(this);
        cwfpset_img.setOnClickListener(this);
        qd_img.setOnClickListener(this);
        kqset_img.setOnClickListener(this);
        wgtj_img.setOnClickListener(this);
        yckhsq_img.setOnClickListener(this);
        myself_img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myself_home:
                Intent intent = new Intent(MainActivity.this,MySelfActivity.class);
                startActivity(intent);
                break;
            case R.id.chuangweifenpei_index:
                Intent intent1 = new Intent(MainActivity.this, BedAllocationActivity.class);
                startActivity(intent1);
                break;
            case R.id.chuangweifenpeishezhi_index:
                Intent intent3 = new Intent(MainActivity.this,BedDormDiaoHuanOKActivity.class);
                startActivity(intent3);
                break;
            case R.id.yichangkaoheshenqing:
                Intent intent4 = new Intent(MainActivity.this,OkGoTestActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
