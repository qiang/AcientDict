package com.adorkable.acientdict.db.dao;

import android.content.Context;

import com.adorkable.acientdict.db.DbHelper;
import com.adorkable.acientdict.entity.SearchHistory;

import java.util.Set;

/**
 * Created by liuqiang
 * Date: 2015-12-25
 * Time: 21:49
 */
public class SearchHistoryDao {
    private DbHelper dbHelper;

    public SearchHistoryDao(Context context) {
        dbHelper = DbHelper.getInstance(context);
    }

    public void insert(SearchHistory history) {

    }

    public void delete(SearchHistory history) {

    }

    public void update(SearchHistory searchHistory){

    }

    public Set<String> selectTags() {
        return null;
    }

    public void deleteAll() {

    }
}
