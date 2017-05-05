package com.mazhan.theone.androidfive;

import android.content.pm.ApplicationInfo;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.mazhan.theone.R;

/**
 * Created by dragonfly on 2017/5/4.
 */

public class Clipping extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipping);
        if (ApplicationInfo.FLAG_SYSTEM != 0) {//系统应用
        } else if (ApplicationInfo.FLAG_SYSTEM <= 0) {//第三方应用

        }
        ;
        TextView view1 = (TextView) findViewById(R.id.clipping);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, 100, 100);
            }
        };
        view1.setOutlineProvider(viewOutlineProvider);
    }
}
