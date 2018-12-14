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

package com.adorkable.acientdict.ui.base;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adorkable.acientdict.annotation.InjectContentView;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
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
    protected View mRootView;

    //ButterKnife
    private Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LOG_TAG = this.getClass().getSimpleName();
        //this.mActivity = getActivity();
        this.mContext = getContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mRootView) {
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
                        "当前 Fragment 没有对应布局！");
            }
            mRootView = inflater.inflate(resId, container, false);
        }
        if (isBindButterKnife()) {
            unbinder = ButterKnife.bind(this, mRootView);
        }

        if (isBindEventBus()) {
            EventBus.getDefault().register(this);
        }

        return mRootView;
    }

    /**
     * fragment 初次加载数据
     */
//    protected abstract void initData();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initData();
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
        if (isBindButterKnife() && unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
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

    /**
     * Author: liuqiang
     * Time: 2018-12-14 11:53
     * Description: 设置内容的两种方式，要么使用注解要么复写这个方法
     */
    protected int getContentViewId() {
        return -1;
    }
}
