package com.adorkable.acientdict.mvp.model;

/**
 * Created by liuqiang on 2016/5/4.
 */
public interface SearchInteractor {
    //TODO 应该有参数用来回调
    void loadPresearchList();    //
    void loadSearchResult();
}
