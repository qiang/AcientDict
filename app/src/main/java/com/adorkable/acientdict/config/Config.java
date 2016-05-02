package com.adorkable.acientdict.config;

/**
 * 一些保存到SharedPreference文件中的配置信息的键
 */
public class Config {

    //1是不提醒，2是提醒，主要ConfigUtil有个默认返回值是0，所以用1、2来区别设置和未设置  2G,3G,4G
    public static final String NOTIFICATION_2G_3G_4G = "NOTIFICATION_2G_3G_4G";
    public static final String IS_ONCE_OPEN = "IS_ONCE_OPEN";    //app第一次打开？
    public static final String IS_ACCEPT_JPUSH_MSG = "IS_ACCEPT_JPUSH_MSG";    //是否接收JPUSH信息

}
