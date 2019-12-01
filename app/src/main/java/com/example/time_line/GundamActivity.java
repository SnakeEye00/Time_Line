package com.example.time_line;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import index_fragment.Gundam;

public class GundamActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    Gundam gundam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gundam);
        frameLayout=findViewById(R.id.Gundam_framelayout);
        gundam=new Gundam();
        getSupportFragmentManager().beginTransaction().replace(R.id.Gundam_framelayout,gundam).show(gundam).commitAllowingStateLoss();//Gundam中有一个framelayout，放置对应的fragment
    }
}
