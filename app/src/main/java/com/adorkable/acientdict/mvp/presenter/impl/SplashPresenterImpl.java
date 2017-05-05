package com.adorkable.acientdict.mvp.presenter.impl;

import android.content.Context;
import android.view.animation.Animation;

import com.adorkable.acientdict.mvp.model.SplashInteractor;
import com.adorkable.acientdict.mvp.model.impl.SplashInteractorImpl;
import com.adorkable.acientdict.mvp.presenter.SplashPresenter;
import com.adorkable.acientdict.mvp.view.SplashView;

/**
 * Created by liuqiang
 * Date: 2016-04-05
 * Time: 19:03
 */
public class SplashPresenterImpl implements SplashPresenter {

    private Context mContext = null;
    private SplashView mSplashView = null;
    private SplashInteractor mSplashInteractor = null;

    public SplashPresenterImpl(Context context, SplashView splashView) {
        if (null == splashView) {
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }
        mContext = context;
        mSplashView = splashView;
        mSplashInteractor = new SplashInteractorImpl();
    }


    @Override
    public void initialized() {
        mSplashView.initializeViews(
                mSplashInteractor.getVersionName(mContext),
                mSplashInteractor.getCopyright(mContext),
                mSplashInteractor.getBackgroundImageResID()
        );

        Animation animation = mSplashInteractor.getBackgroundImageAnimation(mContext);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mSplashView.navigateToHomePage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashView.animateBackgroundImage(animation);
    }
}
