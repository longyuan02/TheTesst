package com.mazhan.theone.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.mazhan.theone.R;

/**
 * Created by dragonfly on 2017/4/19.
 */

public class MyService extends Service {
    private final static String TAG = "MyService";
    private NotificationManager notificationMgr;
    private boolean canRun = true;
    private final IBinder binder = new IBinder();


    public class IBinder extends Binder {
        public MyService getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        Thread thr = new Thread(null, new ServiceWorker(), "BackgroundSercie");
        thr.start();

        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, String.format("on bind,intent = %s", intent.toString()));
        notificationMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        displayNotificationMessage("服务已启动");
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
// 处理具体的逻辑
//                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "=====unbind");
        canRun = false;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "=====destroy");
        canRun = false;
    }

    //为服务设置图标和文字描述
    private void displayNotificationMessage(String message, boolean isForeground) {
//        Notification notification = new Notification(R.mipmap.ic_launcher, message,
//                System.currentTimeMillis());
        NotificationManager notification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
//                new Intent(this, MyActivity.class), 0);
//        notification.setLatestEventInfo(this, "My Service", message,
//                contentIntent);
//        MyService.this.startForeground(1, notification);
    }

    private void displayNotificationMessage(String message) {
        Notification notification = new Notification(R.mipmap.ic_launcher, message,
                System.currentTimeMillis());
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
//                new Intent(this, MyActivity.class), 0);
//        notification.setLatestEventInfo(this, "我的通知", message,
//                contentIntent);
//        notificationMgr.notify(2, notification);
    }

    class ServiceWorker implements Runnable {
        int counter = 0;

        @Override
        public void run() {
            // do background processing here.....
            while (canRun) {
                Log.d("scott", "" + counter);
                counter++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
