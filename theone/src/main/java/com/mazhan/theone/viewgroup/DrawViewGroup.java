package com.mazhan.theone.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mazhan.theone.R;

/**
 * Created by dragonfly on 2017/4/24.
 */

public class DrawViewGroup extends View {
    private int mLeftColor;
    public DrawViewGroup(Context context) {
        super(context);
    }

    public DrawViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.TopBar );
//        mLeftColor =ta.getColor(R.styleable.TopBar_titleTextColor,0);
    }
}
