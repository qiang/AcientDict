package com.adorkable.acientdict.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;

import com.adorkable.acientdict.annotation.InjectContentView;
import com.umeng.analytics.MobclickAgent;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected static String LOG_TAG = null;

    public Context mContext;

    /**
     * 当前activity是否可见
     */
    protected boolean isVisible = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG_TAG = this.getClass().getSimpleName();

        int resId;
        resId = getContentViewId();
        if (resId == -1) {
            if (getClass().isAnnotationPresent(InjectContentView.class)) {
                InjectContentView annotation = getClass()
                        .getAnnotation(InjectContentView.class);
                if (annotation != null) {
                    resId = annotation.value();
                }
            }
        }
        if (resId == -1) {
            throw new RuntimeException(
                    "当前 Activity 没有对应布局！");
        }
        setContentView(resId);

        if (isBindButterKnife()) {
            ButterKnife.bind(this);
        }

        mContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBindButterKnife()) {
//            ButterKnife.unbind(this);
        }
    }

    @Override
    public void finish() {
        onActivityFinish();
        super.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    /**
     * 在activity finish之前做一些操作
     */
    protected void onActivityFinish() {

    }

    /**
     * 向子类暴漏是不是加载ButterKnife库
     *
     * @return
     */
    protected boolean isBindButterKnife() {
        return true;
    }

    /**
     * 向子类暴漏是不是加载EventBus库
     *
     * @return
     */
    protected boolean isBindEventBus() {
        return false;
    }

    protected int getContentViewId() {
        return -1;
    }

}
