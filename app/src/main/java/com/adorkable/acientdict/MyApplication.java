package com.adorkable.acientdict;

import android.app.Application;

import com.adorkable.acientdict.config.Config;
import com.adorkable.acientdict.db.AccountInfoDaoImpl;
import com.adorkable.acientdict.db.dao.AccountInfoDao;
import com.adorkable.acientdict.entity.AccountInfo;
import com.adorkable.acientdict.util.ConfigUtil;
import com.adorkable.acientdict.util.VolleyHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuqiang on 15/12/8.
 */
public class MyApplication extends Application {

    private static MyApplication me;

    private Map<String, String> defaultHttpsHeader;

    private AccountInfo accountInfo;

    public String weiXinCode = "";    //用来换取微信的access token

    @Override
    public void onCreate() {
        super.onCreate();

        updataConfFile();    //更新配置文件

        VolleyHelper.getInstance().init(this);
    }

    public Map<String, String> getHttpsHeader() {
        if (defaultHttpsHeader == null) {
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "application/vnd.5tv.v3+json");
            defaultHttpsHeader = headers;
        }
        return defaultHttpsHeader;
    }

    public static MyApplication getInstance() {
        if (me == null) {
            synchronized (MyApplication.class) {
                if (me == null) {
                    me = new MyApplication();
                }
            }
        }
        return me;
    }

    public AccountInfo getAccount() {

        if (accountInfo == null) {
            //查询本地数据库
            AccountInfoDao accountInfoDao = new AccountInfoDaoImpl(this);
            accountInfo = accountInfoDao.selectInfo();
        }
        if (accountInfo != null) {
            getHttpsHeader().put("Authorization", accountInfo.getAccess_token());
        }
        return this.accountInfo;
    }

    public void setAccount(AccountInfo account) {
        this.accountInfo = account;
        if (accountInfo != null) {
            getHttpsHeader().put("Authorization", accountInfo.getAccess_token());
        }
    }


    /**
     * 更改配置文件中的一些数据
     */
    private void updataConfFile() {
        //第一次打开的时候设置接收推送信息
        if (ConfigUtil.getBoolean(getApplicationContext(), Config.IS_ONCE_OPEN, true)) {
            ConfigUtil.setBoolean(this, Config.IS_ACCEPT_JPUSH_MSG, true);
            ConfigUtil.setBoolean(this, Config.NOTIFICATION_2G_3G_4G, true);
        }
    }
}
