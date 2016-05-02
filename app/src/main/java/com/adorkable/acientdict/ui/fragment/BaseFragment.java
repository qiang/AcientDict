/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.adorkable.acientdict.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.adorkable.acientdict.mvp.view.BaseView;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;


/**
 * Author:  liuqiang
 * Date:    2016/5/2
 * Description:
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    /**
     * Log tag
     */
    protected static String LOG_TAG = null;

    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LOG_TAG = this.getClass().getSimpleName();
        super.onCreate(savedInstanceState);
        this.mContext = getContext();

        if (isBindEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void showError(String msg) {
    }

    @Override
    public void showLoading(String msg) {
    }

    @Override
    public void hideLoading() {

    }

    /**
     * 向外面暴漏是不是加载EventBus库
     *
     * @return
     */
    public boolean isBindEventBus() {
        return false;
    }
}
