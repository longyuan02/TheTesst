package com.mazhan.theone.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by dragonfly on 2017/5/8.
 */

public class TranslationView extends View {
    private int mLastX = 0;
    private int mLastY = 0;

    public TranslationView(Context context) {
        super(context);
    }

    public TranslationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = (int) event.getX();
                mLastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int deltax = x - mLastX;
                int deltay = y - mLastY;
                int translationx = (int) ViewHelper.getTranslationX(this) + deltax;
                int translationy = (int) ViewHelper.getTranslationY(this) + deltay;
                ViewHelper.setTranslationX(this, translationx);//需要接入三方库
                ViewHelper.setTranslationY(this, translationy);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }
}
