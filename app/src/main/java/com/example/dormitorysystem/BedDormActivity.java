package com.example.dormitorysystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.dormitorysystem.adapter.DormAdapter;
import com.example.dormitorysystem.adapter.DormOkGoAdapter;
import com.example.dormitorysystem.bean.BedDormModel;
import com.example.dormitorysystem.bean.DormListModel;
import com.example.dormitorysystem.bean.Student;
import com.example.dormitorysystem.bean.ValueTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BedDormActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageView back;
    private List<Student> stuList = new ArrayList<>();
    private List<BedDormModel> stuList1 = new ArrayList<>();
    private RecyclerView recyclerView;
    private GridView gv_bed_info;
    private Button fenpei_btn;
    private TextView dorm_num;

    //扫描识别
    private boolean hasGotToken = false;
    private AlertDialog.Builder alertDialog;

    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_dorm);
        initStudent();
        //接收上个活动传递的参数
        Intent intent = getIntent();
        String dorm_name = intent.getStringExtra("dormNumber");
        String dorm_id = intent.getStringExtra("dormId");

        dorm_num = findViewById(R.id.dorm_num);
        dorm_num.setText(dorm_name);

        //获取保存到的Token
        SharedPreferences pref = getSharedPreferences("loginToken",0);
        String token = pref.getString("token","");
        //主界面数据，获取返回的json，解析数组，              床位信息
        OkGo.<String>post("http://zyd.cdzhiyong.com:51337/v1/api/zydxgMobile/BedApi/queryBedInfoByDormId?")
                .headers("Authorization","Bearer" + token)
                .params("dormId",dorm_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        Gson gson = new Gson();
                        //
                        stuList1 = gson.fromJson(response.body(), new TypeToken<List<BedDormModel>>(){}.getType());

                        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_dorm);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(BedDormActivity.this,2);
                        DormOkGoAdapter adapter = new DormOkGoAdapter(stuList1);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(adapter);
                    }
                });

      //返回上一个
        back = findViewById(R.id.beddorm_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(BedDormActivity.this,BedAllocationActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        //确认分配
        fenpei_btn = findViewById(R.id.bed_dorm_ok_fenpei);
        fenpei_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bed_dorm_ok_fenpei:
                Intent intent = new Intent(BedDormActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                Toast.makeText(BedDormActivity.this,"进入身份证扫描",Toast.LENGTH_SHORT).show();
                initAccessToken();
                break;
            default:
                break;
        }
    }

    private void initStudent(){
        for (int i =0; i<1;i++){
            Student one = new Student("1","汉","陈小春","17301055","2017级软件技术2班");
            stuList.add(one);
            Student b = new Student("2","维","陈大春","17301055","2017级软件技术2班");
            stuList.add(b);
            Student c = new Student("3","回","陈二春","17301055","2017级软件技术2班");
            stuList.add(c);
            Student d = new Student("4","苗","陈春春","17301055","2017级软件技术2班");
            stuList.add(d);
            Student e = new Student("5","汉","陈三春","17301055","2017级软件技术2班");
            stuList.add(e);
            Student f = new Student("6","","","","");
            stuList.add(f);
        }
    }


    //卡片识别方法
    private void recIDCard(String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(20);

        //识别方法，传入识别的数据
        OCR.getInstance(this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {
            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {
                    String idNumber = result.getIdNumber().toString();
                    if (!idNumber.trim().isEmpty()) {
                        //识别出来不为空
                        Intent intent = new Intent(BedDormActivity.this,NotFindStudentActivity.class);
                        startActivity(intent);
                    } else {
                        //识别不出来
                        Intent intent = new Intent(BedDormActivity.this,NotFindStudentActivity.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onError(OCRError ocrError) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE_FRONT && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
        }

        if (requestCode == REQUEST_CODE_PICK_IMAGE_BACK && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
        }

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                    }
                }
            }
        }
    }


    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }



    /**
     * 以license文件方式初始化
     */
    private void initAccessToken() {
        OCR.getInstance(this).initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                Toast.makeText(BedDormActivity.this, "licence方式获取token失败" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }, getApplicationContext());
    }
}
