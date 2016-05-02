package com.adorkable.acientdict.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adorkable.acientdict.R;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 发现页
 */
public class DiscoverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);
        return rootView;
    }


    @Override
    public String toString() {
        return "发现";
    }
}
