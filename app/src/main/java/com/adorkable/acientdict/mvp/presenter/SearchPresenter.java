package com.adorkable.acientdict.mvp.presenter;

import com.adorkable.acientdict.mvp.BasePresenter;
import com.adorkable.acientdict.mvp.contract.SearchContract;

/**
 * Author: liuqiang
 * Date: 2016-05-04
 * Time: 15:05
 * Description:
 */
public class SearchPresenter extends BasePresenter<SearchContract.View>
        implements SearchContract.Presenter {

    public SearchPresenter(SearchContract.View view) {
        super(view);
    }

}
