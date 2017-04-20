package com.mazhan.theone.activityconfiguration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.TextView;

/**
 * Created by dragonfly on 2017/4/20.
 * 限制输入宽高模式调整
 */
@SuppressLint("AppCompatCustomView")
public class DrawView extends TextView {
    private Bitmap bitmap1;
    private int widthMeasure;
    private int heightMeasure;

    public DrawView(Context context) {
        super(context);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(measureWidth(measureWidth(widthMeasureSpec)), measureHeight(heightMeasureSpec));
//    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        Paint mPaint1 = new Paint();
//        mPaint1.setColor(0xFF0000);
//        mPaint1.setStyle(Paint.Style.FILL);
//        Paint mPaint2 = new Paint();
//        mPaint1.setColor(0xFFFF00);
//        mPaint1.setStyle(Paint.Style.FILL);
//        canvas.drawRect(0, 0, widthMeasure, heightMeasure, mPaint1);
//        canvas.drawRect(10, 10, widthMeasure - 10, heightMeasure - 10, mPaint2);
        super.onDraw(canvas);
//        canvas.drawBitmap(bitmap1,0,0,null);
    }
}

