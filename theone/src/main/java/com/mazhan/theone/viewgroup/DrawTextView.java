package com.mazhan.theone.viewgroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dragonfly on 2017/4/20.
 */

public class DrawTextView extends View {
    public DrawTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * Created by dragonfly on 2017/4/20.
     * 限制输入宽高模式调整
     */
    @SuppressLint("AppCompatCustomView")
    public static class DrawView extends TextView {
        private Bitmap bitmap1;
        private int widthMeasure;
        private int heightMeasure;
        private Paint mPaint = null;
        private LinearGradient mLinearGradient = null;
        private Matrix mGradientMatrix;
        private int mViewWidth = 0;
        private int mTranslate = 0;
        private boolean mAnimating = true;

        public DrawView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
    //        mPaint = getPaint();
    //        mLinearGradient = new LinearGradient(0, 0, widthMeasure, 0, new int[]{Color.YELLOW, Color.GREEN, Color.WHITE}, null, Shader.TileMode.CLAMP);
    //        mPaint.setShader(mLinearGradient);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            widthMeasure = widthMeasureSpec;
            heightMeasure = heightMeasureSpec;
            setMeasuredDimension(measureWidth(measureWidth(widthMeasureSpec)), measureHeight(heightMeasureSpec));
        }

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

        /**
         * 闪烁动画
         * @param w
         * @param h
         * @param oldw
         * @param oldh
         */
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            if (mViewWidth == 0) {
                mViewWidth = getMeasuredWidth();
                if (mViewWidth > 0) {
                    mPaint = getPaint();
                    mLinearGradient = new LinearGradient(-mViewWidth, 0, 0, 0,
                            new int[] { 0x33ff0000, 0xffff00, 0x33ff0000 },
                            new float[] { 0, 0.8f, 1 }, Shader.TileMode.CLAMP);
                    mPaint.setShader(mLinearGradient);
                    mGradientMatrix = new Matrix();
                }
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
    //        Paint mPaint1 = new Paint();
    //        mPaint1.setColor(getResources().getColor(R.color.colorAccent));
    //        mPaint1.setStyle(Paint.Style.FILL);
    //        Paint mPaint2 = new Paint();
    //        mPaint2.setColor(getResources().getColor(R.color.colorPrimaryDark));
    //        mPaint2.setStyle(Paint.Style.FILL);
    //        canvas.drawRect(0, 0, widthMeasure, heightMeasure, mPaint1);
    //        canvas.drawRect(10, 10, widthMeasure - 10, heightMeasure - 10, mPaint2);
    //        canvas.save();
    //        super.onDraw(canvas);
    //        canvas.restore();-----------------------------------------------------------------------------------
            super.onDraw(canvas);
    /**
     * 闪烁
     */
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
}
