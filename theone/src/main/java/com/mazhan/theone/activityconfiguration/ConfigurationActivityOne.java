package com.mazhan.theone.activityconfiguration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/18.
 */

public class ConfigurationActivityOne extends Activity {
    @InjectView(R.id.btn_click)
    Button btn_click;
    private final static String TAG=ConfigurationActivityOne.class.getSimpleName()+"======:";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate=====one", "onCreate");
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        String[] df = {"dd", "edc","asdf"};
        List<String> dtat= Arrays.asList(df);
        Log.i(TAG,dtat.get(0));
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationActivityOne.this, ConfigurationActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart=====one", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop=====one", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy=====one", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause=====one", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart=====one", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume=====one", "onResume");
    }

}
