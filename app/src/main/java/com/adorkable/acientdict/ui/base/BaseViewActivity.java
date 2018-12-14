package com.adorkable.acientdict.ui.base;

import android.os.Bundle;

import com.adorkable.acientdict.mvp.IView;

/**
 * Author: liuqiang
 * Time: 2018-12-14 11:25
 * Description: 既然某个Activity实现了 IView 接口，那么理论来说他肯定有Presenter
 */
public abstract class BaseViewActivity<P> extends BaseActivity
        implements IView {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setPresenter();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    public abstract P setPresenter();

}
