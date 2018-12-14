package com.adorkable.acientdict.mvp;


public abstract class BasePresenter<V extends IView> {

    protected V mView;

    public BasePresenter(V view) {
        mView = view;
    }
}
