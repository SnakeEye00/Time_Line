package com.example.time_line;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import index_fragment.Index_Gundam;
import index_fragment.Index_Person;
import index_fragment.Index_ST;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment1,fragment2,fragment3;
    private Fragment[] fragments;
    private int lastindex;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
        setContentView(R.layout.activity_main);
        initFragment();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void changeFragment(int index,int lastindex) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastindex]);
        if(fragments[index].isAdded()==false){
            transaction.add(R.id.index_fragment,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    private void initFragment() {
        fragment1=new Index_Gundam();
        fragment2=new Index_ST();
        fragment3=new Index_Person();
        fragments=new Fragment[]{fragment1,fragment2,fragment3};
        lastindex=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.index_fragment,fragment1).show(fragment1).commitAllowingStateLoss();
    }

}
