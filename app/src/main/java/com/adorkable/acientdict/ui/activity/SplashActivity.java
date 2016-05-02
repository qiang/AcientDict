package com.adorkable.acientdict.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.mvp.presenter.SplashPresenter;
import com.adorkable.acientdict.mvp.presenter.SplashPresenterImpl;
import com.adorkable.acientdict.mvp.view.SplashView;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;

public class SplashActivity extends BaseActivity implements SplashView {

    @Bind(R.id.splash_image)
    ImageView mSplashImage;

    @Bind(R.id.splash_version_name)
    TextView mVersionName;

    @Bind(R.id.splash_copyright)
    TextView mCopyright;

    private SplashPresenter mSplashPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSplashPresenter = new SplashPresenterImpl(this, this);
        mSplashPresenter.initialized();
    }

    @Override
    protected int getContentViewLayoutID() {
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
}
