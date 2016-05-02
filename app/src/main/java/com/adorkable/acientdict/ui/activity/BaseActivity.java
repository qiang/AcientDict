package com.adorkable.acientdict.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.adorkable.acientdict.MyApplication;
import com.adorkable.acientdict.mvp.view.BaseView;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    /**
     * Log tag
     */
    protected static String LOG_TAG = null;

    public Context mContext;
    public MyApplication mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG_TAG = this.getClass().getSimpleName();
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            ButterKnife.bind(this);
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }

        mContext = getApplicationContext();
        mApplication = (MyApplication) mContext;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
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


    /**
     * bind layout resource file
     *
     * @return id of layout resource
     */
    protected abstract int getContentViewLayoutID();
}
