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

public class ThirdActivity extends AppCompatActivity {
    @InjectView(R.id.tv_third)
    TextView third;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcthird);
        Log.i("111111====:",UserManager.sUserId+"");
        ButterKnife.inject(this);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
                Log.i("111111====:",UserManager.sUserId+"");
            }
        });
    }
}
