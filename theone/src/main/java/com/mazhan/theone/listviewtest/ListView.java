package com.mazhan.theone.listviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by dragonfly on 2017/4/26.
 */

public class ListView extends android.widget.ListView {
    private float density;

    public ListView(Context context) {
        super(context);
    }

    public ListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取密度
//        DisplayMetrics dm = new DisplayMetrics();
//        dm = getResources().getDisplayMetrics();
//        density = dm.density;
        DisplayMetrics dm=new DisplayMetrics();
        dm=getResources().getDisplayMetrics();
        float df=dm.density;
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, (int) (100 * density), isTouchEvent);
    }
}
