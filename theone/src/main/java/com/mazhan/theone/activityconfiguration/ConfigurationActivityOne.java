package com.mazhan.theone.activityconfiguration;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;
import com.mazhan.theone.activitymanager.ManagerApplication;
import com.mazhan.theone.service.IMyBinder;
import com.mazhan.theone.service.LocalService;
import com.mazhan.theone.service.MyService;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/18.
 */

public class ConfigurationActivityOne extends Activity {
    public static DecimalFormat df2 = new DecimalFormat("###0.00"); // 保留小数点两位
    public static DecimalFormat df22=new DecimalFormat("0.00");
    public static ConfigurationActivityOne configuratonac = null;
    @InjectView(R.id.btn_click)
    Button btn_click;
    //    private IMyBinder myBinder;
//    MyService.IBinder myBinder=new MyService.IBinder();
    MyService mService;
    private boolean mBound;
    private final static String TAG = ConfigurationActivityOne.class.getSimpleName() + "======:";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double d = 13.99;
        d=((int)(d*100))/100;
        String str2="14.6897";
        int dfs=str2.indexOf(".");
        int lenth=str2.length();
        int startlen =dfs+2;
        String end=str2.substring(0,startlen);
        Log.i("onCreate=====one", "onCreate"+df22.format(5.189)+"***"+end);
//        new DecimalFormat("0.00").format(244.025)
        configuratonac = this;
        ManagerApplication.getInstance().pushActivity(this);
        ButterKnife.inject(this);
        String[] df = {"dd", "edc", "asdf"};
        List<String> dtat = Arrays.asList(df);
        Log.i(TAG, dtat.get(0));
        btn_click.setText("第一个");
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationActivityOne.this, ConfigurationActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Defines callbacks for service binding, passed to bindService()
     */
    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyService.IBinder binder = (MyService.IBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(ConfigurationActivityOne.this, MyService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
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
        unbindService(conn);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.i("onResume=====one", "keyback");
            finish();
        }
        return false;
    }

    public double round(double value) {
        return Math.round(value * 100) / 100.0;
    }
    public static double round(double v,int scale){

        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
