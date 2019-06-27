package com.example.dormitorysystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BedDormDiaoHuanOKActivity extends AppCompatActivity {
    private Button ok_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_dorm_diao_huan_ok);

        ok_btn = (Button)findViewById(R.id.dorm_diaohuan_ok);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(BedDormDiaoHuanOKActivity.this)
                        .setTitle("提示")
                        .setMessage("调换成功！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(BedDormDiaoHuanOKActivity.this,BedAllocationActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .create();
                dialog.show();
            }
        });
    }
}
