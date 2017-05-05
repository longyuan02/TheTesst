package com.mazhan.theone.activityconfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by dragonfly on 2017/5/3.
 */

public class ActivityHandlerTest extends AppCompatActivity {

    private static class MyHandler extends Handler {
        private final WeakReference<ActivityHandlerTest> mActivity;

        public MyHandler(ActivityHandlerTest activity) {
            mActivity = new WeakReference<ActivityHandlerTest>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ActivityHandlerTest activity = mActivity.get();
            if (activity != null) {
                // ...
            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);

    /**
     * Instances of anonymous classes do not hold an implicit
     * reference to their outer class when they are "static".
     */
    private final Runnable sRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(1);
            Log.i("activityHandler====", "runnanble");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Post a message and delay its execution for 10 minutes.
        mHandler.postDelayed(sRunnable, 6* 1000);

        // Go back to the previous Activity.
        finish();
    }
}