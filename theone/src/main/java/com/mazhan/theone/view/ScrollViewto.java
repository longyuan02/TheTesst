package com.mazhan.theone.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by dragonfly on 2017/5/8.
 */

public class ScrollViewto extends View {
    private Context context;
    public ScrollViewto(Context context) {
        super(context);
    }

    public ScrollViewto(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewto(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initView(){
        ScrollView sv=new ScrollView(context);
    }
    private void SmoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int desta=destX-scrollX;
    }
}
