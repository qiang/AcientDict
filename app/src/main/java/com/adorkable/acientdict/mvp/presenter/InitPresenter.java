package com.adorkable.acientdict.mvp.presenter;

import com.adorkable.acientdict.apis.RetrofitClient;
import com.adorkable.acientdict.apis.service.RetrofitApi;
import com.adorkable.acientdict.entity.DictInitEntity;
import com.adorkable.acientdict.mvp.BasePresenter;
import com.adorkable.acientdict.mvp.contract.InitContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liuqiang
 * Date: 2016-05-02
 * Time: 20:58
 */
public class InitPresenter extends BasePresenter<InitContract.View>
        implements InitContract.Presenter {

    private RetrofitApi api;

    public InitPresenter(InitContract.View dictView) {
        super(dictView);
        api = RetrofitClient.getService(RetrofitApi.class);
    }

    @Override
    public void loadData() {
        mView.showLoading("");

        api.init().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<DictInitEntity>() {
                    @Override
                    public void onNext(DictInitEntity stateModel) {


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
