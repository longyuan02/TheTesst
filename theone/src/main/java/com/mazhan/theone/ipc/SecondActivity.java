package com.mazhan.theone.ipc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mazhan.theone.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/24.
 */

public class SecondActivity extends AppCompatActivity {
//    private final static String TAG = SecondActivity.class.getSimpleName() + "======:";
    @InjectView(R.id.tv_second)
    TextView second;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcsecend);
        int db=UserManager.sUserId;
//        Log.i(TAG, UserManager.sUserId + "");
        ButterKnife.inject(this);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
