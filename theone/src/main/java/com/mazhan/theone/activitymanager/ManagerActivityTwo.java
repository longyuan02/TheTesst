package com.mazhan.theone.activitymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mazhan.theone.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/5/16.
 */

public class ManagerActivityTwo extends AppCompatActivity {
    @InjectView(R.id.btn_click)
    Button btn_click;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ManagerApplication.getInstance().pushActivity(this);
        ButterKnife.inject(this);
        btn_click.setText("第二个");
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivityTwo.this, ManagerActivityThree.class);
                startActivity(intent);
                ManagerApplication.getInstance().finishActivity(ManagerActivityOne.class);
            }
        });
    }
}
