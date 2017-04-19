package com.mazhan.theone;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by dragonfly on 2017/3/16.
 */

public abstract class MaingAbstract extends AppCompatActivity{
    InterfaceViews interfaceViews;
    void preferty(){
        interfaceViews.getValueSc("111");
    }
}
