package com.adorkable.acientdict.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liuqiang on 10/20/15.
 * 存储所有的API 本地缓存
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "dict.db";
    private static final int DB_VERSION = 1;

    private static DbHelper sDbHelper = null;

    //保存授权信息的表
    private static final String SQL_CREATE_ACCOUNT_INFO_TABLE = "create table account_info(" +
            "_id integer primary key autoincrement," +    //数据库自增主键
            "account_id integer, "+
            "avater text,"+
            "name text,"+
            "email text,"+
            "phone text,"+
            "birthday text,"+
            "gender text,"+
            "autograph text,"+
            "openid text,"+
            "weibo_uid text,"+
            "unionid text,"+
            " access_token text )";    //
    //搜索记录
    private static final String SQL_CREATE_HISTORY_INFO_TABLE = "create table history_info(" +
            "_id integer primary key autoincrement," +
            " key_word text," +
            " created_at text )";


    private DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ACCOUNT_INFO_TABLE);
        db.execSQL(SQL_CREATE_HISTORY_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 单例
     *
     * @param context
     * @return
     */
    public static DbHelper getInstance(Context context) {
        if (null == sDbHelper) {
            synchronized (DbHelper.class) {
                if (null == sDbHelper) {
                    sDbHelper = new DbHelper(context);
                }
            }
        }
        return sDbHelper;
    }
}
