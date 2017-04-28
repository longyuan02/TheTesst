package com.mazhan.theone.viewgroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dragonfly on 2017/4/26.
 */

public class VIew extends View{
    public VIew(Context context) {
        super(context);
    }

    public VIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i("View======","view");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("View======","ontouchevent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("View======","dispatchtouchevent");
        return super.dispatchTouchEvent(event);
    }
}
