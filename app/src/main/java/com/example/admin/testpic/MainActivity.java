package com.example.admin.testpic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhy.autolayout.config.AutoLayoutConifg;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoLayoutConifg.getInstance().useDeviceSize();
        setContentView(R.layout.test);
    }
}
