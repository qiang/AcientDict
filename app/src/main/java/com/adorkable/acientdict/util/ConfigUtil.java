package com.adorkable.acientdict.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Collections;
import java.util.Set;


public class ConfigUtil {

    public static final String PREFERENCE_NAME = "config";

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }

    public static int getInt(Context context, String key) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getInt(key, 0);
        } else {
            return 0;
        }
    }

    public static void setInt(Context context, String key, int value) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor editor = preferences.edit();
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public static long getLong(Context context, String key) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getLong(key, 0L);
        } else {
            return 0L;
        }
    }

    public static void setLong(Context context, String key, long value) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor editor = preferences.edit();
            editor.putLong(key, value);
            editor.commit();
        }
    }

    public static void addLong(Context context, String key, long value) {
        setLong(context, key, getLong(context, key) + value);
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getString(key, "");
        } else {
            return "";
        }
    }

    public static void setString(Context context, String key, String value) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor editor = preferences.edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getBoolean(key, false);
        } else {
            return false;
        }
    }

    public static boolean getBoolean(Context context, String key, boolean flag) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getBoolean(key, flag);
        } else {
            return false;
        }
    }

    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
        }
    }

    public static Set<String> getStringSet(Context context, String key) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getStringSet(key, Collections.EMPTY_SET);
        } else {
            return Collections.EMPTY_SET;
        }
    }

    public static void setStringSet(Context context, String key, Set<String> value) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor editor = preferences.edit();
            editor.putStringSet(key, value);
            editor.commit();
        }
    }
}
