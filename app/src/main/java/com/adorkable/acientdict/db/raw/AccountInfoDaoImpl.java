package com.adorkable.acientdict.db.raw;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adorkable.acientdict.entity.AccountInfo;

/**
 * Created by liuqiang
 * Date: 2016-01-11
 * Time: 16:34
 */
public class AccountInfoDaoImpl implements AccountInfoDao {
    private SQLiteHelper dbHelper;

    public AccountInfoDaoImpl(Context context) {
        this.dbHelper = SQLiteHelper.getInstance(context);
    }

    @Override
    public void insertInfo(AccountInfo info) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL("insert into account_info " +
                        "( account_id  , " +
                        "avater  ," +
                        "name  ," +
                        "email  ," +
                        "phone  ," +
                        "birthday  ," +
                        "gender  ," +
                        "autograph  ," +
                        "openid  ," +
                        "weibo_uid  ," +
                        "unionid  ," +
                        " access_token   )" +
                        "values (?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{
                        info.getId(),
                        info.getAvatar(),
                        info.getName(),
                        info.getEmail(),
                        info.getPhone(),
                        info.getBirthday(),
                        info.getGender(),
                        info.getAutograph(),
                        info.getOpenid(),
                        info.getWeibo_uid(),
                        info.getUnionid(),
                        info.getAccess_token()
                });
    }

    @Override
    public void deleteInfo(AccountInfo info) {

    }

    @Override
    public AccountInfo selectInfo() {
        AccountInfo info = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("account_info", null, null, null, null, null, null);//查询并获得游标
        if (c.moveToFirst()) {//判断游标是否为空
            info = new AccountInfo();
            info.setId(c.getInt(c.getColumnIndex("account_id")));
            info.setAvatar(c.getString(c.getColumnIndex("avater")));
            info.setName(c.getString(c.getColumnIndex("name")));
            info.setEmail(c.getString(c.getColumnIndex("email")));
            info.setPhone(c.getString(c.getColumnIndex("phone")));
            info.setBirthday(c.getString(c.getColumnIndex("birthday")));
            info.setGender(c.getString(c.getColumnIndex("gender")));
            info.setOpenid(c.getString(c.getColumnIndex("openid")));
            info.setWeibo_uid(c.getString(c.getColumnIndex("weibo_uid")));
            info.setUnionid(c.getString(c.getColumnIndex("unionid")));
            info.setAccess_token(c.getString(c.getColumnIndex("access_token")));

        }
        c.close();
        return info;
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from account_info " +
                "where 1=1", new Object[]{
        });
    }
}
