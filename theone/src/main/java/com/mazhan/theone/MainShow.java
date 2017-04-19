package com.mazhan.theone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dragonfly on 2017/3/16.
 */

public class MainShow extends AppCompatActivity{
//    InterfaceViews interfaceView=null;
//    public MainShow() {
//        interfaceView=new MainActivity(this);
//        interfaceView.getValueSc("12345");
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
