package com.adorkable.acientdict.wxapi;

import java.util.Arrays;

/**
 * Created by liuqiang on 10/22/15.
 */
public class WeiXinUserInfo {

    public String access_token;

    public String openid;    //普通用户的标识，对当前开发者帐号唯一

    public String nickname;    //普通用户昵称

    public int sex;    //普通用户性别，1为男性，2为女性

    public String province;    //普通用户个人资料填写的省份

    public String city;    //普通用户个人资料填写的城市

    public String country;    //国家，如中国为CN

    public String headimgurl;
    //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空

    public String[] privilege;    //用户特权信息，json数组，如微信沃卡用户为（chinaunicom）

    public String unionid;

    //出错的时候返回的field
    public String errcode;

    public String errmsg;


    @Override
    public String toString() {
        return "WeiXinUserInfo{" +
                "openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", privilege=" + Arrays.toString(privilege) +
                ", unionid='" + unionid + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
