package com.mazhan.theone.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by dragonfly on 2017/4/26.
 */

public class VIewGroup extends ViewGroup{
    public VIewGroup(Context context) {
        super(context);
    }

    public VIewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("ViewGroup======","intercepttouchevnet");
        return false;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("ViewGroup======","ontouchevnet");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("ViewGroup======","dispatchtouchevent");
        return super.dispatchTouchEvent(ev);
    }
}
