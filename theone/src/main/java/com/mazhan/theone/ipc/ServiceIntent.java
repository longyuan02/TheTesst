package com.mazhan.theone.ipc;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by dragonfly on 2017/4/25.
 */

public class ServiceIntent extends IntentService {
    private int count = 0;
    private boolean isRunning = true;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public ServiceIntent() {
        super("ServiceIntent");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        isRunning = true;
        Log.i("onHandleIntent======1",count+"");
        count = 0;
        while (isRunning) {
            count++;
            if (count >= 100) {
                isRunning = false;
                Log.i("onHandleIntent======",isRunning+"");
            }
        }


}

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("serviceonCreate======","");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("serviceonStart======",startId+"");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i("serviceonStartComm==",flags+"**"+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ondestroy++===","destrye");
    }
}
