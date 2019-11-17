package com.example.time_line;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import cn.sharesdk.onekeyshare.OnekeyShare;
import index_fragment.Gundam;
import index_fragment.Index;
import index_fragment.Index_Gundam;
import index_fragment.Index_Person;
import index_fragment.Index_ST;
import index_fragment.Login_fragment;
import index_fragment.Logined_fragment;

public class DrawdActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fragment1,fragment2,fragment3,fragment4,fragment5;
    private Fragment[] fragments;
    private int lastindex;
    //private MenuItem bottomItem;
    //筛选获取到的Fragement的id
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //bottomItem=item;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(lastindex!=0){
                        changeFragment(0,lastindex);
                        lastindex=0;
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if(lastindex!=1){
                        changeFragment(1,lastindex);
                        lastindex=1;
                    }
                    return true;
                case R.id.navigation_notifications:
                    if(lastindex!=2){
                        changeFragment(2,lastindex);
                        lastindex=2;
                    }
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawd);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.draw_nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        initFragment();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemTextAppearanceActive(R.style.bottom_selected_text);
        navView.setItemTextAppearanceInactive(R.style.bottom_normal_text);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    //切换主界面Fragdment
    private void changeFragment(int index,int lastindex) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastindex]);
        if(fragments[index].isAdded()==false){
            transaction.add(R.id.index_fragment,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();

    }
    //初始化Fragement
    private void initFragment() {
        fragment1=new Index();
        fragment2=new Index_ST();
        fragment3=new Login_fragment();
        fragment4=new Logined_fragment();
        fragment5=new Gundam();
        fragments=new Fragment[]{fragment1,fragment2,fragment3,fragment4,fragment5};
        lastindex=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.index_fragment,fragment1).show(fragment1).commitAllowingStateLoss();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            // Handle the camera action
            changeFragment(0,lastindex);
        } else if (id == R.id.nav_gallery) {
            changeFragment(4,lastindex);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {
            /*OnekeyShare oks = new OnekeyShare();
            // title标题，微信、QQ和QQ空间等平台使用
            oks.setTitle(getString(R.string.share));
            // titleUrl QQ和QQ空间跳转链接
            oks.setTitleUrl("http://sharesdk.cn");
            // text是分享文本，所有平台都需要这个字段
            oks.setText("我是分享文本");
            // imagePath是图片的本地路径，确保SDcard下面存在此张图片
            //oks.setImagePath("/sdcard/test.jpg");
            // url在微信、Facebook等平台中使用
            oks.setUrl("http://sharesdk.cn");
            // 启动分享GUI
            oks.show(this);*/
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
