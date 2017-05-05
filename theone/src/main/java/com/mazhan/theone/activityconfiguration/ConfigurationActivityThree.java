package com.mazhan.theone.activityconfiguration;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/18.
 */

public class ConfigurationActivityThree extends AppCompatActivity {
    @InjectView(R.id.btn_click)
    Button btn_click;
    private final MyHandler myHandler = new MyHandler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("onCreate=====three", "onCreate");
        ButterKnife.inject(this);
        btn_click.setText("第三个");
        myHandler.postDelayed(sRunnable, 10 * 1000);
        finish();
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationActivityThree.this, ActivityHandlerTest.class);
                startActivity(intent);
            }
        });
    }

    private class MyHandler extends Handler {
        private final WeakReference<ConfigurationActivityThree> mActivity;

        public MyHandler(ConfigurationActivityThree activity) {
            mActivity = new WeakReference<ConfigurationActivityThree>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ConfigurationActivityThree activity = mActivity.get();
            Log.i("three======1:","message");
            if (activity != null) {
                btn_click.setText("更新");
                Log.i("three======:","message");
                // ...
            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);
    /**
     * Instances of anonymous classes do not hold an implicit
     * reference to their outer class when they are "static".
     */
    private final Runnable sRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(1);
            Log.i("activityHandler====", "runnanble");
        }
    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            myHandler.sendEmptyMessage(1);
        }
    };

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
            Log.i("onResume=====three", "finish");
        }
        return false;
    }
}
