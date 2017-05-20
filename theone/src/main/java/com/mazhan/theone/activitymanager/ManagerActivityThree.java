package com.mazhan.theone.activitymanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;

import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/5/16.
 */

public class ManagerActivityThree extends AppCompatActivity{
    @InjectView(R.id.btn_click)
    Button btn_click;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_click.setText("第三个");
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
