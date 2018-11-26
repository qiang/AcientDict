package com.adorkable.acientdict.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by liuqiang
 * Date: 2015-12-25
 * Time: 21:57
 * 查询历史
 */
@DatabaseTable(tableName = "SearchHistory")
public class SearchHistory extends BaseEntity {

    //2.id=true时id可以由我们自己赋值，如果使用generateId=true，则id由数据库自己维护，自动增长效果，auto increment。
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "word")
    private String word;   //搜索的字或者词
    @DatabaseField(columnName = "update_time")
    private int updateTime;    //最近一次搜查时间


    public SearchHistory() {
    }

    public SearchHistory(String word, int updateTime) {
        this.word = word;
        this.updateTime = updateTime;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
