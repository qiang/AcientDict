package com.adorkable.acientdict.mvp.presenter.impl;

import com.adorkable.acientdict.entity.DictInitEntity;
import com.adorkable.acientdict.mvp.model.DictInteractor;
import com.adorkable.acientdict.mvp.model.impl.DictInteractorImpl;
import com.adorkable.acientdict.mvp.presenter.DictPresenter;
import com.adorkable.acientdict.mvp.view.DictView;

/**
 * Created by liuqiang
 * Date: 2016-05-02
 * Time: 20:58
 */
public class DictPresenterImpl implements DictPresenter, DictInteractor.OnLoadDataCallback {

    private DictInteractor dictInteractor;
    private DictView dictView;

    public DictPresenterImpl(DictView dictView) {
        this.dictInteractor = new DictInteractorImpl();
        this.dictView = dictView;
    }

    @Override
    public void loadData() {
        dictView.showLoading("");
        dictInteractor.loadInitData(this);
    }

    @Override
    public void onLoadSuccess(DictInitEntity dictInitEntity) {
        dictView.hideLoading();
        dictView.updateView(dictInitEntity);    //根据数据更新ui
    }

    @Override
    public void onLoadFailed() {
        dictView.hideLoading();
        dictView.showError("");
    }

}
