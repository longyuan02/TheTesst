package com.mazhan.theone.view;

import android.view.View;

/**
 * Created by dragonfly on 2017/5/2.
 */

public class WrapperView {
    private View mTarger;

    public WrapperView(View mTarger) {
        this.mTarger = mTarger;
    }
    public int getHeight(){//方法名与调用objectAnimation 参数名一至
        return mTarger.getLayoutParams().height;
    }
    public void setHeight(int height){
        mTarger.getLayoutParams().height=height;
        mTarger.requestLayout();
    }

}
