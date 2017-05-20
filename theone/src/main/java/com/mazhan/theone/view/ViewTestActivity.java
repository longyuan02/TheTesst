package com.mazhan.theone.view;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mazhan.theone.R;

/**
 * Created by dragonfly on 2017/5/9.
 */

public class ViewTestActivity extends AppCompatActivity{
    private ImageView view,view1;
    private LinearLayout ln;
    private Button btn_click;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtest);
        view= (ImageView) findViewById(R.id.view);
        view1= (ImageView) findViewById(R.id.view1);
        btn_click= (Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("android.provider.Telephony.SMS_RECEIVED");
//                sendBroadcast(intent);
                sendOrderedBroadcast(intent, null);
            }
        });
        requestSmsPermission();

        ObjectAnimator.ofFloat(view,"translationX",0,400).setDuration(5000).start();
        final int startX=0;
        final int deltaX=1000;
        ValueAnimator animator=ValueAnimator.ofFloat(0f, 200.0f).setDuration(1000);
        animator.setTarget(view1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                float fraction =animation.getAnimatedFraction();
                // 获取当前值
                Float mValue = (Float) animation.getAnimatedValue();
                // 设置横向偏移量
                view1.setTranslationX(mValue);
                // 设置纵向偏移量
                view1.setTranslationY(mValue);
            }
        });
        animator.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        view.post(new Runnable() {
            @Override
            public void run() {
            //获取方法
            }
        });
        ViewTreeObserver observer=view.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int viewwidth=view.getMeasuredWidth();
                int viewheight=view.getMeasuredHeight();
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            int viewwidth=view.getMeasuredWidth();
            int viewheight=view.getMeasuredHeight();
        }
    }
    private void requestSmsPermission() {
        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if ( grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
    }
}
