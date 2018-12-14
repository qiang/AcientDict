package com.adorkable.acientdict.mvp.presenter;

import android.content.Context;
import android.view.animation.Animation;

import com.adorkable.acientdict.mvp.BasePresenter;
import com.adorkable.acientdict.mvp.contract.SplashContract;
import com.adorkable.acientdict.mvp.model.SplashInteractor;
import com.adorkable.acientdict.mvp.model.impl.SplashInteractorImpl;

/**
 * Created by liuqiang
 * Date: 2016-04-05
 * Time: 19:03
 */
public class SplashPresenter extends BasePresenter<SplashContract.View>
        implements SplashContract.Presenter {

    private Context mContext = null;
    private SplashInteractor mSplashInteractor = null;

    public SplashPresenter(Context context, SplashContract.View splashView) {
        super(splashView);
        if (null == splashView) {
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }
        mContext = context;
        mSplashInteractor = new SplashInteractorImpl();
    }


    @Override
    public void initialized() {
        mView.initializeViews(
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
                mView.navigateToHomePage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mView.animateBackgroundImage(animation);
    }
}
