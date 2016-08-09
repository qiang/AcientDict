package com.adorkable.acientdict.mvp.presenter.impl;

import com.adorkable.acientdict.mvp.presenter.BasePresenter;
import com.adorkable.acientdict.network.RequestCallback;

/**
 * Author: liuqiang
 * Date: 2016-08-09
 * Time: 15:03
 */
public class BasePresenterImpl<T> implements BasePresenter, RequestCallback<T> {


    @Override
    public void onSuccess(T response) {

    }

    @Override
    public void onError(Exception e) {

    }
}
