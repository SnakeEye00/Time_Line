package index_fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.time_line.R;
import com.google.gson.Gson;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import GetInformation.GetInfo;
import entity.InFormationItem;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import recyclerview.Index_RecyclerView_Adapter;


public class Index_Gundam extends Fragment {
    private final String url="http://49.233.179.154:8080/Time_Line/getRecycleViewInfo";
    private final String postString="gundam";
    private RecyclerView UC,OO,Seed,icon_blood,W;
    private InFormationItem inFormationItem1,inFormationItem2,inFormationItem3,inFormationItem4,inFormationItem5;
    private static Context context;
    private SwipeRefreshLayout swipeRefreshLayout;
    Executor singleThreadPool,getSingleThreadPool1,getSingleThreadPool2,getSingleThreadPool3,getSingleThreadPool4;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(context);
                    linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                    UC.setLayoutManager(linearLayoutManager1);
                    UC.setAdapter(new Index_RecyclerView_Adapter(getContext(),inFormationItem1));
                    break;
                case 2:
                    LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(context);
                    linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                    OO.setLayoutManager(linearLayoutManager2);
                    OO.setAdapter(new Index_RecyclerView_Adapter(getContext(),inFormationItem2));
                case 3:
                    LinearLayoutManager linearLayoutManager3=new LinearLayoutManager(context);
                    linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
                    Seed.setLayoutManager(linearLayoutManager3);
                    Seed.setAdapter(new Index_RecyclerView_Adapter(getContext(),inFormationItem3));
                case 4:
                    LinearLayoutManager linearLayoutManager4=new LinearLayoutManager(context);
                    linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
                    icon_blood.setLayoutManager(linearLayoutManager4);
                    icon_blood.setAdapter(new Index_RecyclerView_Adapter(getContext(),inFormationItem4));
                case 5:
                    LinearLayoutManager linearLayoutManager5=new LinearLayoutManager(context);
                    linearLayoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);
                    W.setLayoutManager(linearLayoutManager5);
                    W.setAdapter(new Index_RecyclerView_Adapter(getContext(),inFormationItem5));
                    if(swipeRefreshLayout.isRefreshing()){
                        handler.sendEmptyMessage(6);
                    }
                    break;
                case 6:
                    swipeRefreshLayout.setRefreshing(false);
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index_gundam,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getActivity();
        swipeRefreshLayout=view.findViewById(R.id.swipe_ly);
        UC=view.findViewById(R.id.UC);
        OO=view.findViewById(R.id.OO);
        Seed=view.findViewById(R.id.Seed);
        icon_blood=view.findViewById(R.id.icon_blood);
        W=view.findViewById(R.id.W);
        Log.d("context", String.valueOf(context));
        singleThreadPool= Executors.newSingleThreadExecutor();
        //获取后端数据，开启单线程
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                RequestBody requestBody=new FormBody.Builder()
                        .add("request_item",postString) //gundam/st
                        .add("index",String.valueOf(1))             //第几个recyeleview的图片
                        .build();
                String result=getInfo.GetJson(url,requestBody);
                Gson gson=new Gson();
                inFormationItem1=gson.fromJson(result,InFormationItem.class);
                Log.d("information-length",inFormationItem1.getLenght()+"---1");
                if(inFormationItem1!=null){
                    handler.sendEmptyMessage(1);
                }
                else {
                }
            }
        });
        getSingleThreadPool1= Executors.newSingleThreadExecutor();
        getSingleThreadPool1.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                RequestBody requestBody=new FormBody.Builder()
                        .add("request_item",postString) //gundam/st
                        .add("index",String.valueOf(2))             //第几个recyeleview的图片
                        .build();
                String result=getInfo.GetJson(url,requestBody);
                Gson gson=new Gson();
                inFormationItem2=gson.fromJson(result,InFormationItem.class);
                Log.d("information-length",inFormationItem2.getLenght()+"---2");
                if(inFormationItem2!=null){
                    handler.sendEmptyMessage(2);
                }
                else {
                }
            }
        });
        getSingleThreadPool2= Executors.newSingleThreadExecutor();
        getSingleThreadPool2.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                RequestBody requestBody=new FormBody.Builder()
                        .add("request_item",postString) //gundam/st
                        .add("index",String.valueOf(3))             //第几个recyeleview的图片
                        .build();
                String result=getInfo.GetJson(url,requestBody);
                Gson gson=new Gson();
                inFormationItem3=gson.fromJson(result,InFormationItem.class);
                Log.d("information-length",inFormationItem3.getLenght()+"---3");
                if(inFormationItem3!=null){
                    handler.sendEmptyMessage(3);
                }
                else {
                }
            }
        });
        getSingleThreadPool3= Executors.newSingleThreadExecutor();
        getSingleThreadPool3.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                RequestBody requestBody=new FormBody.Builder()
                        .add("request_item",postString) //gundam/st
                        .add("index",String.valueOf(4))             //第几个recyeleview的图片
                        .build();
                String result=getInfo.GetJson(url,requestBody);
                Gson gson=new Gson();
                inFormationItem4=gson.fromJson(result,InFormationItem.class);
                Log.d("information-length",inFormationItem4.getLenght()+"---4");
                if(inFormationItem4!=null){
                    Log.d("get_info","icon_blood获取到后端数据");
                    Log.d("tag",String.valueOf(inFormationItem4.getLenght()));
                    handler.sendEmptyMessage(4);
                }
                else {
                    Log.d("get_info","icon_blood获取后端数据失败");
                }
            }
        });
        Log.d("TAG",Thread.currentThread().getName()+"icon_boold");
        getSingleThreadPool4= Executors.newSingleThreadExecutor();
        getSingleThreadPool4.execute(new Runnable() {
            @Override
            public void run() {
                GetInfo getInfo=new GetInfo();
                RequestBody requestBody=new FormBody.Builder()
                        .add("request_item",postString) //gundam/st
                        .add("index",String.valueOf(5))             //第几个recyeleview的图片
                        .build();
                String result=getInfo.GetJson(url,requestBody);
                Gson gson=new Gson();
                inFormationItem5=gson.fromJson(result,InFormationItem.class);
                Log.d("information-length",inFormationItem5.getLenght()+"---5");
                if(inFormationItem5!=null){
                    Log.d("get_info","W获取到后端数据");
                    Log.d("tag",String.valueOf(inFormationItem5.getLenght()));
                    handler.sendEmptyMessage(5);
                }
                else {
                    Log.d("get_info","W获取后端数据失败");
                }
            }
        }); 
        Log.d("TAG",Thread.currentThread().getName()+"W");
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                singleThreadPool= Executors.newSingleThreadExecutor();
                //获取后端数据，开启单线程
                singleThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        RequestBody requestBody=new FormBody.Builder()
                                .add("request_item",postString) //gundam/st
                                .add("index",String.valueOf(1))             //第几个recyeleview的图片
                                .build();
                        String result=getInfo.GetJson(url,requestBody);
                        Gson gson=new Gson();
                        inFormationItem1=gson.fromJson(result,InFormationItem.class);
                        if(inFormationItem1!=null){
                            Log.d("get_info","UC获取到后端数据");
                            Log.d("tag",String.valueOf(inFormationItem1.getLenght()));
                            handler.sendEmptyMessage(1);
                        }
                        else {
                            Log.d("get_info", "UC获取后端数据失败");
                        }
                    }
                });
                Log.d("TAG",Thread.currentThread().getName()+"UC");
                singleThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        RequestBody requestBody=new FormBody.Builder()
                                .add("request_item",postString) //gundam/st
                                .add("index",String.valueOf(2))             //第几个recyeleview的图片
                                .build();
                        String result=getInfo.GetJson(url,requestBody);
                        Gson gson=new Gson();
                        inFormationItem2=gson.fromJson(result,InFormationItem.class);
                        if(inFormationItem2!=null){
                            Log.d("get_info","OO获取到后端数据");
                            Log.d("tag",String.valueOf(inFormationItem2.getLenght()));
                            handler.sendEmptyMessage(2);
                        }
                        else {
                            Log.d("get_info","OO获取后端数据失败");
                        }
                    }
                });
                Log.d("TAG",Thread.currentThread().getName()+"OO");
                singleThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        RequestBody requestBody=new FormBody.Builder()
                                .add("request_item",postString) //gundam/st
                                .add("index",String.valueOf(3))             //第几个recyeleview的图片
                                .build();
                        String result=getInfo.GetJson(url,requestBody);
                        Gson gson=new Gson();
                        inFormationItem3=gson.fromJson(result,InFormationItem.class);
                        if(inFormationItem3!=null){
                            Log.d("get_info","Seed获取到后端数据");
                            Log.d("tag",String.valueOf(inFormationItem3.getLenght()));
                            handler.sendEmptyMessage(3);
                        }
                        else {
                            Log.d("get_info","Seed获取后端数据失败");
                        }
                    }
                });
                Log.d("TAG",Thread.currentThread().getName()+"Seed");
                singleThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        RequestBody requestBody=new FormBody.Builder()
                                .add("request_item",postString) //gundam/st
                                .add("index",String.valueOf(4))             //第几个recyeleview的图片
                                .build();
                        String result=getInfo.GetJson(url,requestBody);
                        Gson gson=new Gson();
                        inFormationItem4=gson.fromJson(result,InFormationItem.class);
                        if(inFormationItem4!=null){
                            Log.d("get_info","icon_blood获取到后端数据");
                            Log.d("tag",String.valueOf(inFormationItem4.getLenght()));
                        }
                        else {
                            Log.d("get_info","icon_blood获取后端数据失败");
                        }
                    }
                });
                Log.d("TAG",Thread.currentThread().getName()+"icon_boold");
                singleThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        GetInfo getInfo=new GetInfo();
                        RequestBody requestBody=new FormBody.Builder()
                                .add("request_item",postString) //gundam/st
                                .add("index",String.valueOf(5))             //第几个recyeleview的图片
                                .build();
                        String result=getInfo.GetJson(url,requestBody);
                        Gson gson=new Gson();
                        inFormationItem5=gson.fromJson(result,InFormationItem.class);
                        if(inFormationItem5!=null){
                            Log.d("get_info","W获取到后端数据");
                            Log.d("tag",String.valueOf(inFormationItem5.getLenght()));
                        }
                        else {
                            Log.d("get_info","W获取后端数据失败");
                        }
                    }
                });
            }
        });
    }
}
