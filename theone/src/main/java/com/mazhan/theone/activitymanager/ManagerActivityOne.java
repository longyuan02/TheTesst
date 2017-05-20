package com.mazhan.theone.activitymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;

import java.text.DecimalFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/5/16.
 */

public class ManagerActivityOne extends AppCompatActivity{
    @InjectView(R.id.btn_click)
    Button btn_click;
    public static DecimalFormat df = new DecimalFormat("####0"); // 保留整数
    public static DecimalFormat df1 = new DecimalFormat("###0.0"); // 保留小数点一位
    public static DecimalFormat df2 = new DecimalFormat("###0.00"); // 保留小数点两位
    public static DecimalFormat df3 = new DecimalFormat("###0.000"); // 保留小数点三位
    public static DecimalFormat df4 = new DecimalFormat("###0.0000"); // 保留小数点四位
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ManagerApplication.getInstance().pushActivity(this);
        ButterKnife.inject(this);
        btn_click.setText("第一个");
        String df=df1.format(1.555);
        Log.i("managerone===",df);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManagerActivityOne.this,ManagerActivityTwo.class);
                startActivity(intent);
            }
        });
    }
}
