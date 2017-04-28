package com.mazhan.theone.tools;

import android.content.Context;

/**
 * Created by dragonfly on 2017/4/28.
 */

public class Tools {
    /**
     * px转为dp或dip 保证尺寸大小不变
     * @param context
     * @param pxValue
     * @return
     */
    public static int pix2dip(Context context, float pxValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

/**
 * dip或dp 转为px 保证尺寸大小不变
 *
 */
    public static int dip2px(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue/scale+0.5f);
    }

}
