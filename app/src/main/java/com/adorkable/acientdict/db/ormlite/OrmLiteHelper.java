package com.adorkable.acientdict.db.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.adorkable.acientdict.entity.SearchHistory;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库操作管理工具类
 * <p>
 * 我们需要自定义一个类继承自ORMlite给我们提供的OrmLiteSqliteOpenHelper，创建一个构造方法，重写两个方法onCreate()和onUpgrade()
 * 在onCreate()方法中使用TableUtils类中的createTable()方法初始化数据表
 * 在onUpgrade()方法中我们可以先删除所有表，然后调用onCreate()方法中的代码重新创建表
 * 我们需要对这个类进行单例，保证整个APP中只有一个SQLite Connection对象
 * 这个类通过一个Map集合来管理APP中所有的DAO，只有当第一次调用这个DAO类时才会创建这个对象（并存入Map集合中）
 * 其他时候都是直接根据实体类的路径从Map集合中取出DAO对象直接调用
 * https://www.cnblogs.com/itgungnir/p/6210949.html
 */
public class OrmLiteHelper extends OrmLiteSqliteOpenHelper {
    // 数据库名称
    private static final String DATABASE_NAME = "dict.db";

    // 本类的单例实例
    private static OrmLiteHelper instance;

    // 存储APP中所有的DAO对象的Map集合
    private Map<String, Dao> daoMap = new HashMap<>();

    // 获取本类单例对象的方法
    public static synchronized OrmLiteHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (OrmLiteHelper.class) {
                if (instance == null) {
                    instance = new OrmLiteHelper(context);
                }
            }
        }
        return instance;
    }

    // 私有的构造方法
    private OrmLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    // 根据传入的DAO的路径获取到这个DAO的单例对象（要么从daos这个Map中获取，要么新创建一个并存入daos）
    @Override
    public synchronized <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daoMap.containsKey(className)) {
            dao = daoMap.get(className);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daoMap.put(className, dao);
        }
        @SuppressWarnings("unchecked")
        D castDao = (D) dao;
        return castDao;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        // 创建数据库时调用的方法
        try {
            TableUtils.createTable(connectionSource, SearchHistory.class);
//            TableUtils.createTable(connectionSource, ArticleBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        // 数据库版本更新时调用的方法
        try {
            TableUtils.dropTable(connectionSource, SearchHistory.class, true);
//            TableUtils.dropTable(connectionSource, ArticleBean.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 释放资源
    @Override
    public void close() {
        super.close();
        for (String key : daoMap.keySet()) {
            Dao dao = daoMap.get(key);
            dao = null;
        }
    }
}