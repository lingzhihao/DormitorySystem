package com.example.dormitorysystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

import org.w3c.dom.Text;

public class MySelfActivity extends AppCompatActivity implements View.OnClickListener {
private ImageView back;
private TextView update_pwd;
private Button logOut_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_self);
        ImmersionBar.with(this).init();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        update_pwd = (TextView)findViewById(R.id.update_password);
        back = (ImageView) findViewById(R.id.back);
        logOut_btn = (Button) findViewById(R.id.logout);

        update_pwd.setOnClickListener(this);
        back.setOnClickListener(this);
        logOut_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Intent intent = new Intent(MySelfActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.update_password:

                break;
            case R.id.logout:
                Intent intent1 = new Intent(MySelfActivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();
                default:
                    break;
        }
    }
}
