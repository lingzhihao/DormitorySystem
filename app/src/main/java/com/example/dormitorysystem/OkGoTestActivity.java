package com.example.dormitorysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dormitorysystem.bean.OkGoTest;
import com.example.dormitorysystem.callback.StringDialogCallback;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;

import okhttp3.Call;

public class OkGoTestActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private Button get_okgo,post_okgo,down_okgo,upfile_okgo;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go_test);

        get_okgo = findViewById(R.id.get_okgo);
        post_okgo = findViewById(R.id.post_okgo);
        down_okgo = findViewById(R.id.down_okgo);
        upfile_okgo = findViewById(R.id.upfile_okgo);
        textView = findViewById(R.id.okgo_data);

        get_okgo.setOnClickListener(this);
        post_okgo.setOnClickListener(this);
        down_okgo.setOnClickListener(this);
        upfile_okgo.setOnClickListener(this);

        //OkGo GET 测试
        OkGo.<String>get("https://ditu.amap.com/service/regeo?longitude=121.04925573429551&latitude=31.315590522490712&tdsourcetag=s_pctim_aiomsg")
                .tag(this)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {

            }
        });

        //存储


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //OKGO get方法测试
            case R.id.get_okgo:
                OkGo.<String>get("https://ditu.amap.com/service/regeo?longitude=121.04925573429551&latitude=31.315590522490712&tdsourcetag=s_pctim_aiomsg")
                        .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                        .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                        .cacheMode(CacheMode.DEFAULT)   // 缓存模式，详细请看缓存介绍
                        .execute(new StringDialogCallback(OkGoTestActivity.this) {
                            @Override
                            public void onSuccess(Response<String> response) {




                                textView.setText(response.body());
                                String str = response.body();
                                //用GSON解析json
                                Gson gson = new Gson();
                                OkGoTest okGoTest = gson.fromJson(str,OkGoTest.class);
                                Toast.makeText(OkGoTestActivity.this,okGoTest.getData().getCity(),Toast.LENGTH_LONG).show();
                                //获取在执行线程的线程名
                                Log.d("xiancheng",Thread.currentThread().getName());
                                //反编译成json字符串
                                textView.setText(new Gson().toJson(okGoTest));
                            }
                        });
                break;
            //okgo post测试
            case R.id.post_okgo:
                OkGo.<String>post("http://183.223.236.6:51337/v1/api/permuaa//oauth/token") //输入请求地址
                        .tag(this)//销毁请求时候会用到
//                        .upJson(json)//上传参数  如果没什么需求直接用
                        .params("grant_type", "password")
                        .params("username","admin")
                        .params("password","123456")
                        .params("tdsourcetag","s_pctim_aiomsg")
                        .execute(new StringDialogCallback(OkGoTestActivity.this) {
                            @Override
                            public void onSuccess(Response<String> response) {


                                String body = response.body();
                                textView.setText(body);
                                Gson bodyJson = new Gson();
                                OkGoTest myBean = bodyJson.fromJson(body, OkGoTest.class);

                            }

                            @Override
                            public void onError(Response<String> response) {
                                super.onError(response);
                            }
                        });
                break;

            case R.id.down_okgo:

                break;
            case R.id.upfile_okgo:

                break;
            default:
                break;
        }
    }
}
