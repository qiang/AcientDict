package com.adorkable.acientdict;

import android.app.Application;

import com.adorkable.acientdict.config.Config;
import com.adorkable.acientdict.db.raw.AccountInfoDaoImpl;
import com.adorkable.acientdict.db.raw.AccountInfoDao;
import com.adorkable.acientdict.entity.AccountInfo;
import com.adorkable.acientdict.util.ConfigUtil;
import com.adorkable.acientdict.util.VolleyHelper;

import java.util.HashMap;
import java.util.Map;

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
