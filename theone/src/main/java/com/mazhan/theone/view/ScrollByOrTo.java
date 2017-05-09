package com.mazhan.theone.view;

/**
 * 弹性恢复
 * Created by dragonfly on 2017/5/9.
 */


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class ScrollByOrTo extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public ScrollByOrTo(Context context) {
        super(context);
        ininView(context);
    }

    public ScrollByOrTo(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView(context);
    }

    public ScrollByOrTo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView(context);
    }

    private void ininView(Context context) {
        setBackgroundColor(Color.BLUE);
        // 初始化Scroller
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.i("dragview=compute","compute");
        // 判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY());
            // 通过重绘来不断调用computeScroll
            invalidate();
        }
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("dragview=ontouch","moment");
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getX();
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //scroll移动
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                //效果同layout
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                //layout移动
//                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                //设置param 需要根据容器来确定方法LinearLayout relativeLayout等
//                ViewGroup.MarginLayoutParams layoutParams= (ViewGroup.MarginLayoutParams) getLayoutParams();
//                layoutParams.leftMargin=getLeft()+offsetX;
//                layoutParams.rightMargin=getRight()+offsetX;
//                layoutParams.topMargin=getTop()+offsetY;
//                layoutParams.bottomMargin=getBottom()+offsetY;
//                setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_UP:
                // 手指离开时，执行滑动过程
                View viewGroup = ((View) getParent());
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY(),100);
                invalidate();
                break;
        }
        return true;
    }
}
