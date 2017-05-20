package com.mazhan.theone.activityconfiguration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mazhan.theone.R;
import com.mazhan.theone.activitymanager.ManagerApplication;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/18.
 */

public class ConfigurationActivityTwo extends Activity {
    @InjectView(R.id.btn_click)
    Button btn_click;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreatetwo=====", "onCreate");
        setContentView(R.layout.activity_main);
        ManagerApplication.getInstance().pushActivity(this);
        ButterKnife.inject(this);
        btn_click.setText("第二个");
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ConfigurationActivityTwo.this, ConfigurationActivityThree.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                ManagerApplication.getInstance().finishActivity(ConfigurationActivityOne.class);
//                ManagerApplication.getInstance().finishAllActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStarttwo=====", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStoptwo=====", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroytwo=====", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPausetwo=====", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestarttwo=====", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResumetwo=====", "onResume");
    }
}
