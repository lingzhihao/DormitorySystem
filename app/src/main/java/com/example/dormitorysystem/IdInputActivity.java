package com.example.dormitorysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class IdInputActivity extends AppCompatActivity {
    private ImageView back,search_id ;
    private EditText user_id_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_input);
        user_id_input = findViewById(R.id.user_id_input);
        //返回按钮
        back = findViewById(R.id.id_input_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdInputActivity.this,BedAllocationActivity.class);
                startActivity(intent);

            }
        });


        search_id = findViewById(R.id.search_id);
        search_id.setOnClickListener(new View.OnClickListener() {
            String idCard = user_id_input.getText().toString();
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdInputActivity.this,StudentDetailsActivity.class);
                intent.putExtra("idCard",idCard);
                startActivity(intent);
            }
        });


    }
}
