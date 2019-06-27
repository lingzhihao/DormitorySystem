package com.example.dormitorysystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.dormitorysystem.adapter.AccommodationOkGoAdapter;
import com.example.dormitorysystem.adapter.SelectClassAdapter;
import com.example.dormitorysystem.adapter.SelectDormAdapter;
import com.example.dormitorysystem.adapter.SelectLoudongAdapter;
import com.example.dormitorysystem.adapter.SelectQuyuAdapter;
import com.example.dormitorysystem.bean.Dorm;
import com.example.dormitorysystem.bean.DormListModel;
import com.example.dormitorysystem.bean.LouDong;
import com.example.dormitorysystem.bean.Quyu;
import com.example.dormitorysystem.bean.SelectionClass;
import com.example.dormitorysystem.callback.StringDialogCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BedAllocationActivity extends AppCompatActivity implements View.OnClickListener {

//    private List<Accommodation> adtList = new ArrayList<>();
    //获取接口数据

    private List<Dorm> dormList = new ArrayList<>();
    private List<SelectionClass> classList = new ArrayList<>();
    private List<Quyu> quyuList = new ArrayList<>();
    private List<LouDong> loudongList = new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private ImageView saixuan_img,backHome;
    private FloatingActionButton saomiao ;
    private SwipeRefreshLayout swipe_refresh;
    private Button diaohuan_btn,reset_select,select_ok;
    private RecyclerView recyclerView;
    int pageNo = 1;
    int pageSize =1000;
    //扫描

    private boolean hasGotToken = false;
    private AlertDialog.Builder alertDialog;

    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    private AccommodationOkGoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_allocation);
//        ImmersionBar.with(this).init();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.bed_saixuan);
        }
        saixuan_img = (ImageView) findViewById(R.id.saixuan);
        saixuan_img.setOnClickListener(this);
        //扫描按钮
        saomiao = findViewById(R.id.saomiao);
        saomiao.setOnClickListener(this);
        //返回上一级
        backHome = findViewById(R.id.bedallocation_back);
        backHome.setOnClickListener(this);

        //下拉刷新
        swipe_refresh = (SwipeRefreshLayout) findViewById(R.id.bed_shuaxin);
        swipe_refresh.setColorSchemeResources(R.color.qianhong);
        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshBedAllocation();
            }
        });

        initClass();
        initQuyu();
        initLoudong();
        initDorm();

        //侧边页面班级选择 RecyclerView
        RecyclerView recyclerView1 = findViewById(R.id.recycler_view_banji);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        final SelectClassAdapter adapter1 = new SelectClassAdapter(classList);
        recyclerView1.setAdapter(adapter1);

        //区域选择
        RecyclerView recyclerView2 = findViewById(R.id.recycler_view_quyu);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);
        final SelectQuyuAdapter adapter2 = new SelectQuyuAdapter(quyuList);
        recyclerView2.setAdapter(adapter2);

        //楼栋选择
        RecyclerView recyclerView3 = findViewById(R.id.recycler_view_loudong);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView3.setLayoutManager(layoutManager3);
        final SelectLoudongAdapter adapter3 = new SelectLoudongAdapter(loudongList);
        recyclerView3.setAdapter(adapter3);

        //寝室选择
        RecyclerView recyclerView4 = (RecyclerView)findViewById(R.id.recycler_view_selectDorm);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView4.setLayoutManager(gridLayoutManager);
        final SelectDormAdapter adapter4 = new SelectDormAdapter(dormList);
        recyclerView4.setAdapter(adapter4);

        //调换按钮
        /*diaohuan_btn = findViewById(R.id.bed_dorm_ok_fenpei);
        diaohuan_btn.setOnClickListener(this);*/

        //重置
        reset_select = findViewById(R.id.select_reset);
        reset_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classList.clear();
                quyuList.clear();
                loudongList.clear();
                dormList.clear();
                initClass();
                adapter1.notifyDataSetChanged();
                initQuyu();
                adapter2.notifyDataSetChanged();
                initLoudong();
                adapter3.notifyDataSetChanged();
                initDorm();
                adapter4.notifyDataSetChanged();
                Toast.makeText(BedAllocationActivity.this,"1111",Toast.LENGTH_LONG).show();
            }
        });

        //确定按钮，
        select_ok = findViewById(R.id.select_ok);
        select_ok.setOnClickListener(this);

        //获取保存到的Token
        SharedPreferences pref = getSharedPreferences("loginToken",0);
        String token = pref.getString("token","");
        //主界面数据，获取返回的json，解析数组
        //获取寝室信息
        OkGo.<String>post("http://zyd.cdzhiyong.com:51337/v1/api/zydxgMobile/BedApi/getDormPage?")
                .headers("Authorization","Bearer" + token)
                .params("pageNo",pageNo)
                .params("pageSize",pageSize)
                .execute(new StringDialogCallback(BedAllocationActivity.this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
//                        String str = response.body();
                        DormListModel dormListModel = gson.fromJson(response.body(), DormListModel.class);
//                        Toast.makeText(BedAllocationActivity.this,str,Toast.LENGTH_SHORT).show();
                        List<DormListModel.RowsBean> list = new ArrayList<>();
                        //向recyclerview传入数据,直接使用接收的gson数据
                        adapter  = new AccommodationOkGoAdapter(dormListModel.getRows());
                        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_fenpei);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(BedAllocationActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                        //上滑加载更多
                        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged( RecyclerView recyclerView, int newState) {
                                super.onScrollStateChanged(recyclerView, newState);
                                int lastPosition = -1;
                                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                                lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                                if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                                    Toast.makeText(BedAllocationActivity.this,"加载更多",Toast.LENGTH_SHORT).show();
                                    pageNo = pageNo+ 1;
                                }
                            }
                            @Override
                            public void onScrolled( RecyclerView recyclerView, int dx, int dy) {
                                super.onScrolled(recyclerView, dx, dy);
                            }
                        });
                    }

                });
    }

    private void refreshBedAllocation() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        initAccommodation();
//                        adapter.notifyDataSetChanged();
                        swipe_refresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saixuan:
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                break;
            //扫描
            case R.id.saomiao:
                Intent intent = new Intent(BedAllocationActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                Toast.makeText(BedAllocationActivity.this,"进入身份证扫描",Toast.LENGTH_SHORT).show();
                initAccessToken();
                break;
            case R.id.bedallocation_back:
                Intent intent1 = new Intent(BedAllocationActivity.this,MainActivity.class);
                startActivity(intent1);
                break;

            default:
                break;
        }
    }

    private void initClass(){
        //选择班级数据
        SelectionClass class1 = new SelectionClass("2018级软件技术1班",false);
        classList.add(class1);
        SelectionClass class2 = new SelectionClass("2018级软件技术2班",false);
        classList.add(class2);
    }

    private void initQuyu(){
        //选择区域数据
        Quyu q1 = new Quyu("A区",false);
        quyuList.add(q1);
        Quyu q2 = new Quyu("B区",false);
        quyuList.add(q2);
        Quyu q3 = new Quyu("C区",false);
        quyuList.add(q3);
        Quyu q4 = new Quyu("D区",false);
        quyuList.add(q4);
    }

    private void initLoudong(){
        //选择loudong数据
        LouDong loudong1 = new LouDong("1栋",false);
        loudongList.add(loudong1);
        LouDong loudong2 = new LouDong("2栋",false);
        loudongList.add(loudong2);
        LouDong loudong3 = new LouDong("3栋",false);
        loudongList.add(loudong3);
        LouDong loudong4 = new LouDong("4栋",false);
        loudongList.add(loudong4);
        LouDong loudong5 = new LouDong("5栋",false);
        loudongList.add(loudong5);
    }

    private void initDorm(){
        //选择寝室号数据
        String dorm_number = "";
        for (int i=1;i<=15;i++){
            if (i<10){
                dorm_number = "110" + i;
            }else if (i>=10){
                dorm_number = "11" + i;
            }
            Dorm dorm1 = new Dorm(dorm_number,false);
            dormList.add(dorm1);
            dorm_number = "";
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
                        Intent intent = new Intent(BedAllocationActivity.this,NotFindStudentActivity.class);
                        startActivity(intent);
                    } else {
                        //识别不出来
                        Intent intent = new Intent(BedAllocationActivity.this,NotFindStudentActivity.class);
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
                Toast.makeText(BedAllocationActivity.this, "licence方式获取token失败" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }, getApplicationContext());
    }

}
