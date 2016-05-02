package com.adorkable.acientdict.wxapi;

import java.util.Date;

/**
 * Created by liuqiang on 10/22/15.
 */
public class OAuthData {
    public String access_token;

    public long expires_in;

    public String refresh_token;

    public String openid;

    public String scope;

    public int errcode;

    public String errmsg;

    public boolean isExpired() {
        Date current = new Date();
        if (this.expires_in - (current.getTime() * 1000) > 0) {
            return false;
        } else {
            return true;
        }
    }
}
