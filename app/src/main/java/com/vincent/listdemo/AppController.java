package com.vincent.listdemo;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class AppController extends MultiDexApplication {

    private static AppController appInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static synchronized AppController getInstance() {
        return appInstance;
    }
}
