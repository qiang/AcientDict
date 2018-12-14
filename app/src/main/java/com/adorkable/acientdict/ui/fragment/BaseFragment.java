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

import android.view.View;

import com.adorkable.acientdict.mvp.IView;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Author:  liuqiang
 * Date:    2016/5/2
 * Description:
 */
public abstract class BaseFragment extends Fragment {

    protected static String LOG_TAG = null;
    protected Context mContext;
    //ButterKnife
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LOG_TAG = this.getClass().getSimpleName();
        super.onCreate(savedInstanceState);
        this.mContext = getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isBindEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) unbinder.unbind();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (isBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 是不是加载EventBus库
     */
    public boolean isBindEventBus() {
        return false;
    }
}
