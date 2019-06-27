package com.example.dormitorysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DormOkStudentActivity extends AppCompatActivity {
    private Button back_btn,ok_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorm_ok_student);
        back_btn = findViewById(R.id.dorm_allocation_fanhui);
        ok_btn = findViewById(R.id.dorm_allocation_ok);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormOkStudentActivity.this,BedAllocationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
