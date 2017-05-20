package com.mazhan.theone.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/**
 * Created by dragonfly on 2017/5/10.
 */

public class TouchView extends ViewGroup {
    int mLastx = 0;
    int mLasty = 0;

    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void dip(){

    }

    @Override
    public View getRootView() {
        return super.getRootView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean interceptbl = false;
        int interceptx = (int) ev.getX();
        int intercepty = (int) ev.getY();
        int movex = 0;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                interceptbl = false;
                movex = (int) ev.getX();
                Log.i("viewgroup====", "actiondown");
                break;
            case MotionEvent.ACTION_MOVE:
                int movexx = (int) (movex - ev.getX());
                if (movex > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    interceptbl = false;
                    Log.i("viewgroup====", "actionmove");
                } else {
                    Log.i("viewgroup====", "actionmovedown");
                }
                break;
            case MotionEvent.ACTION_UP:
                interceptbl = false;
                Log.i("viewgroup====", "actionup");
                break;
        }
        return interceptbl;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean interceptbl = false;
        int interceptx = (int) ev.getX();
        int intercepty = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                interceptbl = false;
                Log.i("viewgroup====", "actiondown");
                break;
            case MotionEvent.ACTION_MOVE:
                int movexx = Math.abs((int) (interceptx - mLastx));
                int viewslop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                if (movexx > viewslop) {
                    interceptbl = false;
                    Log.i("viewgroup====", "actionmove");
                } else {
                    Log.i("viewgroup====", "actionmovedown");
                }
                break;
            case MotionEvent.ACTION_UP:
                interceptbl = false;
                Log.i("viewgroup====", "actionup");
                break;
        }
        mLastx = interceptx;
        mLasty = intercepty;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
