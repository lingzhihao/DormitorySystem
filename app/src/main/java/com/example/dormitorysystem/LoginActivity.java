package com.example.dormitorysystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dormitorysystem.bean.LoginOkGo;
import com.example.dormitorysystem.callback.StringDialogCallback;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private EditText username,userpassword;
    private TextView tishi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        ImmersionBar.with(this).init();
        loginBtn = findViewById(R.id.login);
        loginBtn.setOnClickListener(this);

        username = (EditText)findViewById(R.id.edit_name);
        userpassword = (EditText)findViewById(R.id.edit_password);
        tishi = (TextView) findViewById(R.id.login_tishi);

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                tishi.setVisibility(View.GONE);
            }
        });
        userpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                tishi.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                final String name = username.getText().toString();
                final String password = userpassword.getText().toString();
                OkGo.<String>post("http://183.223.236.6:51337/v1/api/permuaa//oauth/token")
                        .tag(this)
                        .params("grant_type","password")
                        .params("username",name)
                        .params("password",password)
                        .params("tdsourcetag","s_pctim_aiomsg")
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                String str = response.body();
                                Gson gson = new Gson();
                                LoginOkGo loginOkGo = gson.fromJson(str, LoginOkGo.class);
                                if(!TextUtils.isEmpty(loginOkGo.getErrcode())){
                                    if(TextUtils.isEmpty(name) || (TextUtils.isEmpty(password))){
                                        tishi.setText("*用户名或密码为空");
                                    }else{
                                        tishi.setText("*学号/工号与密码不匹配");
                                        username.setText("");
                                        userpassword.setText("");
                                    }
                                    tishi.setVisibility(View.VISIBLE);
                                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                }else if(!TextUtils.isEmpty(loginOkGo.getAccess_token())){
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    //sharedpreferences
                                    SharedPreferences.Editor editor = getSharedPreferences("loginToken",0).edit();
                                    editor.clear();
                                    editor.putString("token",loginOkGo.getAccess_token());
                                    editor.apply();
                                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
            default:
                break;
        }
    }
}
