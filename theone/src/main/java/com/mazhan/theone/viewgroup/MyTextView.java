package com.mazhan.theone.viewgroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mazhan.theone.R;

/**
 * Created by dragonfly on 2017/4/21.
 */

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private int mViewWidth = 0;
    private int mTranslate = 0;
    private boolean mAnimating = true;
    private int titlecolor;
    private Float titleTextSize;

    //自定义的View 必须要重写两个或者三个参数的构造方法。
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
//        titlecolor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
//        int contentcolor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
//        titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 10);
//        float contentsize = ta.getDimension(R.styleable.TopBar_leftTextColor, 0);
//        String titletext = ta.getString(R.styleable.TopBar_titleText);
//        String title = ta.getString(R.styleable.TopBar_title);
//        ta.recycle();
//        TextView tv_title = new TextView(context);
//        Button btn = new Button(context);
//        TextView tv_content = new TextView(context);
//        tv_title.setText(titletext);
//        tv_title.setTextSize(titleTextSize);
//        tv_title.setTextColor(titlecolor);
//        tv_content.setText(title);
//        tv_content.setTextColor(contentcolor);
//        tv_content.setTextSize(contentsize);
//        ViewGroup.LayoutParams titleparam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(-mViewWidth, 0, 0, 0,
                        new int[]{0x33ffffff, 0xffffffff, 0x33ffffff},
                        new float[]{0, 0.5f, 1}, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAnimating && mGradientMatrix != null) {
            //每一次运动的递增值
            mTranslate += mViewWidth / 10;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(50);
        }
    }
}