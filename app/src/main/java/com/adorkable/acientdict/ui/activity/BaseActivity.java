package com.adorkable.acientdict.ui.activity;

import android.content.Context;
import android.os.Bundle;

import com.adorkable.acientdict.DictApplication;
import com.adorkable.acientdict.mvp.IView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Log tag
     */
    protected static String LOG_TAG = null;

    public Context mContext;
    public DictApplication mApplication;

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
        mApplication = (DictApplication) mContext;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getContentViewLayoutID();

}
