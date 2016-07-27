package com.adorkable.acientdict.entity;

/**
 * Created by liuqiang
 * Date: 2015-12-25
 * Time: 21:57
 * 查询历史
 */
public class SearchHistory extends BaseEntity{

    public int id;
    public String word;   //搜索的字或者词
    public int updateTime;    //最近一次搜查时间

}
