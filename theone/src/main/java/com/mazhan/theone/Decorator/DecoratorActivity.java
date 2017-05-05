package com.mazhan.theone.Decorator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mazhan.theone.R;

import dagger.*;

/**
 * Created by dragonfly on 2017/5/4.
 */

public class DecoratorActivity extends AppCompatActivity implements Component {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipping);
    }

    @Override
    public void show() {

    }
}
