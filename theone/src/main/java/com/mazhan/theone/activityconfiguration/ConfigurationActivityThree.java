package com.mazhan.theone.activityconfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/18.
 */

public class ConfigurationActivityThree extends AppCompatActivity {
    @InjectView(R.id.btn_click)
    Button btn_click;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("onCreate=====three", "onCreate");
        ButterKnife.inject(this);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationActivityThree.this, ConfigurationActivityOne.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart=====three", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop=====three", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy=====three", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause=====three", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart=====three", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume=====three", "onResume");
    }
}
