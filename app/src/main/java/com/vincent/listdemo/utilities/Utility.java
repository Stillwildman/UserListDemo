package com.vincent.listdemo.utilities;

import android.widget.Toast;

import androidx.annotation.StringRes;

import com.vincent.listdemo.AppController;

public class Utility {

    public static void forceCloseTask() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void toastShort(String msg) {
        Toast.makeText(AppController.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastShort(@StringRes int msgResId) {
        toastShort(AppController.getInstance().getApplicationContext().getString(msgResId));
    }

    public static void toastLong(String msg) {
        Toast.makeText(AppController.getInstance().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public static void toastLong(@StringRes int msgResId) {
        toastLong(AppController.getInstance().getApplicationContext().getString(msgResId));
    }

}
