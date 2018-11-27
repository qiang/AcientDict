package com.adorkable.acientdict.ui.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adorkable.acientdict.R;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 发现页
 */
public class DiscoverFragment extends BaseFragment {

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);
//        return rootView;
//    }
//
//
    @Override
    public String toString() {
        return "发现";
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("Q_M:","-00-"+isVisibleToUser);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Q_M:","-onCreateView-");

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Q_M:","-onActivityCreated-");

        super.onActivityCreated(savedInstanceState);
    }
}
