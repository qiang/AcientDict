package com.adorkable.acientdict.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.mvp.contract.SplashContract;
import com.adorkable.acientdict.mvp.presenter.SplashPresenter;
import com.adorkable.acientdict.ui.base.BaseViewActivity;

import butterknife.BindView;

public class SplashActivity extends BaseViewActivity<SplashContract.Presenter>
        implements SplashContract.View {

    @BindView(R.id.splash_image)
    ImageView mSplashImage;

    @BindView(R.id.splash_version_name)
    TextView mVersionName;

    @BindView(R.id.splash_copyright)
    TextView mCopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.initialized();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void animateBackgroundImage(Animation animation) {
        mSplashImage.startAnimation(animation);
    }

    @Override
    public void initializeViews(String versionName, String copyright, int backgroundResId) {
        mCopyright.setText(copyright);
        mVersionName.setText(versionName);
        mSplashImage.setImageResource(backgroundResId);
    }

    @Override
    public void navigateToHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public SplashContract.Presenter setPresenter() {
        return new SplashPresenter(this, this);
    }
}
