package com.adorkable.acientdict.db.raw;


import com.adorkable.acientdict.entity.AccountInfo;

/**
 * Created by liuqiang
 * Date: 2016-01-11
 * Time: 16:26
 */
public interface AccountInfoDao {

    public void insertInfo(AccountInfo info);

    public void deleteInfo(AccountInfo info);

    public AccountInfo selectInfo();

    void deleteAll();
}
