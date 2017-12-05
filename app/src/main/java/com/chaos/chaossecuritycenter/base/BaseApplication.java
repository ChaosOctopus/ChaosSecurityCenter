package com.chaos.chaossecuritycenter.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by yc.Zhao on 2017/11/29 0029.
 */

public class BaseApplication extends Application {
    private static Context mAppContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
    }
    public static Context getAppContext() {
        return mAppContext;
    }
}
