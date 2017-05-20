package com.mazhan.theone.activitymanager;

import android.app.Activity;

/**
 * Created by dragonfly on 2017/5/16.
 */

public class ManagerApplication extends AbsSuperApplication {
    public static ManagerApplication managerApplication = null;

    private static class HolderApplacation {
        private final static ManagerApplication singleton = new ManagerApplication();
    }

    public final static ManagerApplication getInstance() {

        return HolderApplacation.singleton;
    }

    @Override
    protected String getAppNameFromSub() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void pushActivity(Activity activity) {
        super.pushActivity(activity);
    }

    @Override
    public void popActivity(Activity activity) {
        super.popActivity(activity);
    }

    @Override
    public Activity getTopActivity() {
        return super.getTopActivity();
    }

    @Override
    public String getTopActivityName() {
        return super.getTopActivityName();
    }

    @Override
    public void finishCurrentActivity() {
        super.finishCurrentActivity();
    }

    @Override
    public void finishActivity(Activity activity) {
        super.finishActivity(activity);
    }

    @Override
    public void finishActivity(Class<?> cls) {
//        super.finishActivity(cls);
        if (mActivitys == null || mActivitys.isEmpty()) {
            return;
        }
        for (Activity activity : mActivitys) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                return;
            }
        }
        for(Activity activity:mActivitys){
            if(activity.getClass().equals(cls)){

            }

        }
    }

    @Override
    public void finishAllActivity() {
        super.finishAllActivity();
    }
}
