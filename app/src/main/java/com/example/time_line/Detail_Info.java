package com.example.time_line;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import GetInformation.GetInfo;
import entity.Detail_Infomation;
import entity.Get_detail_info;
import entity.WebView_Url;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import recyclerview.Detail_Info_RecyclerView_Adapter;


public class Detail_Info extends AppCompatActivity {
    private final String url="http://10.0.2.2:8080/Time_Line/getDetail_Info";
    private final String url2="http://10.0.2.2:8080/Time_Line/getWebViewurl";
    private TextView textView1;
    private ImageView imageView;
    private RecyclerView recyclerView1,recyclerView2;
    private WebView webView;
    private Detail_Infomation infomation;                           //从上一个Activity获取到的数据
    private Get_detail_info detail_info_name,detail_info_img;
    private WebView_Url webView_url;
    private Context context;
    SwipeRefreshLayout swipeRefreshLayout;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(context);
                    linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerView1.setLayoutManager(linearLayoutManager1);
                    recyclerView1.setAdapter(new Detail_Info_RecyclerView_Adapter(context,detail_info_img));
                    break;
                case 2:
                    LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(context);
                    linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerView2.setLayoutManager(linearLayoutManager2);
                    recyclerView2.setAdapter(new Detail_Info_RecyclerView_Adapter(context,detail_info_name));
                    break;
                case 3:
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(webView_url.getWebview_url());
                    if(swipeRefreshLayout.isRefreshing()){
                        handler.sendEmptyMessage(4);
                    }
                    break;
                case 4:
                    swipeRefreshLayout.setRefreshing(false);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__info);
        context=getBaseContext();
        infomation=getinfo(getIntent());
        final RequestBody requestBody1=new FormBody.Builder()
                .add("item_name",infomation.getItem_name())
                .add("type","jiti")
                .add("dataBase","gundam")
                .build();
        init(infomation.getItem_name(),infomation.getItem_img_url());
        ExecutorService single= Executors.newSingleThreadExecutor();
        single.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                String result_json=getInfo.GetJson(url,requestBody1);
                Gson gson=new Gson();
                detail_info_img=gson.fromJson(result_json,Get_detail_info.class);
                if(detail_info_img!=null){
                    Log.d("detail","获取到机体数据");
                    handler.sendEmptyMessage(1);
                }
                else {
                    Log.d("detail","未获取机体到数据");
                }
            }
        });
        final RequestBody requestBody2=new FormBody.Builder()
                .add("item_name",infomation.getItem_name())
                .add("type","pilot")
                .add("dataBase","gundam")
                .build();
        single.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                String result_json=getInfo.GetJson(url,requestBody2);
                Gson gson=new Gson();
                detail_info_name=gson.fromJson(result_json,Get_detail_info.class);
                if(detail_info_name!=null){
                    Log.d("detail","获取到驾驶员数据");
                    handler.sendEmptyMessage(2);
                }
                else {
                    Log.d("detail","未获取到驾驶员数据");
                }
            }
        });
        final RequestBody requestBody3=new FormBody.Builder()
                .add("item_name",infomation.getItem_name())
                .add("type","webview_url")
                .add("dataBase","gundam")
                .build();
        single.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                String result_json=getInfo.GetJson(url2,requestBody3);
                Gson gson=new Gson();
                webView_url=gson.fromJson(result_json,WebView_Url.class);
                if(webView_url!=null){
                    Log.d("detail","获取到webview的url");
                    handler.sendEmptyMessage(3);
                }
                else {
                    Log.d("detail","未获取到webview的url");
                }
            }
        });
        swipeRefreshLayout=findViewById(R.id.detail_swipref);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                final RequestBody requestBody1=new FormBody.Builder()
                        .add("item_name",infomation.getItem_name())
                        .add("type","jiti")
                        .add("dataBase","gundam")
                        .build();
                init(infomation.getItem_name(),infomation.getItem_img_url());
                ExecutorService single= Executors.newSingleThreadExecutor();
                single.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        String result_json=getInfo.GetJson(url,requestBody1);
                        Gson gson=new Gson();
                        detail_info_img=gson.fromJson(result_json,Get_detail_info.class);
                        if(detail_info_img!=null){
                            Log.d("detail","获取到机体数据");
                            handler.sendEmptyMessage(1);
                        }
                        else {
                            Log.d("detail","未获取机体到数据");
                        }
                    }
                });
                final RequestBody requestBody2=new FormBody.Builder()
                        .add("item_name",infomation.getItem_name())
                        .add("type","pilot")
                        .add("dataBase","gundam")
                        .build();
                single.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        String result_json=getInfo.GetJson(url,requestBody2);
                        Gson gson=new Gson();
                        detail_info_name=gson.fromJson(result_json,Get_detail_info.class);
                        if(detail_info_name!=null){
                            Log.d("detail","获取到驾驶员数据");
                            handler.sendEmptyMessage(2);
                        }
                        else {
                            Log.d("detail","未获取到驾驶员数据");
                        }
                    }
                });
                final RequestBody requestBody3=new FormBody.Builder()
                        .add("item_name",infomation.getItem_name())
                        .add("type","webview_url")
                        .add("dataBase","gundam")
                        .build();
                single.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        String result_json=getInfo.GetJson(url2,requestBody3);
                        Gson gson=new Gson();
                        webView_url=gson.fromJson(result_json,WebView_Url.class);
                        if(webView_url!=null){
                            Log.d("detail","获取到webview的url");
                            handler.sendEmptyMessage(3);
                        }
                        else {
                            Log.d("detail","未获取到webview的url");
                        }
                    }
                });
            }
        });
    }

    private void init(String name, String url) {
        textView1=findViewById(R.id.item_name);
        imageView=findViewById(R.id.item_img);
        recyclerView1=findViewById(R.id.detail_gundam);
        recyclerView2=findViewById(R.id.detail_poilt);
        textView1.setText(name);
        webView=findViewById(R.id.webview);
        Glide.with(this).load(url).into(imageView);
    }

    public Detail_Infomation getinfo(Intent getintent){
        Detail_Infomation detailInfomation=new Detail_Infomation(getintent.getStringExtra("item_name"),getintent.getStringExtra("item_img_ulr"),getintent.getIntExtra("index",0));
        Log.d("name1",detailInfomation.getItem_name());
        Log.d("url",detailInfomation.getItem_img_url());
        Log.d("index",String.valueOf(detailInfomation.getIndex()));
        return detailInfomation;
    }
}
