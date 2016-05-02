package com.adorkable.acientdict.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.ui.activity.LoginActivity;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 个人页
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {


    private ImageView userAvatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        initView(rootView);
        initData();
        bindEvent();

        return rootView;
    }

    private void bindEvent() {
        userAvatar.setOnClickListener(this);
    }

    private void initData() {

    }

    public void initView(View view) {
        userAvatar = (ImageView) view.findViewById(R.id.iv_avatar);
    }


    @Override
    public String toString() {
        return "我的";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_avatar:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }
}
