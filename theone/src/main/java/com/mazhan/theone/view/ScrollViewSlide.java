package com.mazhan.theone.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * Created by dragonfly on 2017/5/9.
 */

public class ScrollViewSlide extends View {
    private ScrollView scrollView;
    Scroller mScroller = null;
    int offsetx = 0;
    int offsety = 0;

    public ScrollViewSlide(Context context) {
        super(context);
        initView(context);
    }

    public ScrollViewSlide(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ScrollViewSlide(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        scrollView = new ScrollView(context);
        mScroller = new Scroller(context);
    }

    private void smoothScrollTo(int destX, int destY) {
        int scrollx = getScrollX();
        int retax = destX - scrollx;
        mScroller.startScroll(scrollx, 0, retax, 0, 1000);
    }

    @Override
    public void computeScroll() {
//        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY());
            // 通过重绘来不断调用computeScroll
            invalidate();
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                offsetx = (int) event.getX();
                offsety = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int xx=x - offsetx;
                int yy=y - offsety;
                ((View) getParent()).scrollBy(-xx, -yy);
                break;
            case MotionEvent.ACTION_UP:
                View viewGroup = ((View) getParent());
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY(),1000);
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
