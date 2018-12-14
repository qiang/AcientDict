package com.adorkable.acientdict;

import android.app.Application;

import com.adorkable.acientdict.util.VolleyHelper;

/**
 * Created by liuqiang on 15/12/8.
 */
public class DictApplication extends Application {

    private static DictApplication me;

    public String weiXinCode = "";    //用来换取微信的access token

    public static DictApplication getInstance() {
        return me;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        me = this;
        VolleyHelper.getInstance().init(this);
    }

}
