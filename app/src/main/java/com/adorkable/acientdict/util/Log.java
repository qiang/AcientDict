package com.adorkable.acientdict.util;


import com.adorkable.acientdict.BuildConfig;

/**
 * Created by liuqiang on 15/12/2.
 */
public class Log {
    private Log() {
    }

    @SuppressWarnings("unused")
    public static int v(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.v(tag, msg);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int v(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.v(tag, msg, tr);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int d(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.d(tag, msg);
        }
        return 0;
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.d(tag, msg, tr);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int i(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.i(tag, msg);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int i(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.i(tag, msg, tr);
        }
        return 0;
    }

    public static int i(String tag, int value) {
        return i(tag, String.valueOf(value));
    }

    public static int i(String tag, long value) {
        return i(tag, String.valueOf(value));
    }

    public static int i(String tag, float value) {
        return i(tag, String.valueOf(value));
    }

    @SuppressWarnings("unused")
    public static int w(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.w(tag, msg);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int w(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.w(tag, msg, tr);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int e(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.e(tag, msg);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int e(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.e(tag, msg, tr);
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static int t(String msg, Object... args) {
        if (BuildConfig.LOG_DEBUG) {
            return android.util.Log.v("test", String.format(msg, args));
        }
        return 0;
    }
}
