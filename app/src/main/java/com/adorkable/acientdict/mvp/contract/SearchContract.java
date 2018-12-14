package com.adorkable.acientdict.mvp.contract;

import com.adorkable.acientdict.mvp.IView;

/**
 * Author: liuqiang
 * Date: 2018-12-13
 * Time: 19:39
 * Description:
 */
public interface SearchContract {

    /**
     * Author: liuqiang
     * Date: 2016-05-03
     * Time: 18:20
     * Description:
     */
    interface Presenter {

    }

    /**
     * Created by liuqiang on 2016/5/4.
     */
    interface View extends IView{
        void showSearchResult();    //显示某个单词的搜索结果

        void showPreSearchList();    //预搜索
    }
}
