package com.vihan.tracker.utils;

import android.util.Log;

public class Logger {
    public static final String TAG="LOGGER";
    public static void debug(String msg){
        Log.d(TAG,msg);
    }
}
