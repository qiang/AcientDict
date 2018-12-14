package com.adorkable.acientdict.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.annotation.InjectContentView;
import com.adorkable.acientdict.ui.activity.LoginActivity;
import com.adorkable.acientdict.ui.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 个人页
 */
@InjectContentView(R.layout.fragment_profile)
public class ProfileFragment extends BaseFragment
        implements View.OnClickListener {


    @BindView(R.id.iv_avatar)
    ImageView userAvatar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindEvent();
    }

    private void bindEvent() {
        userAvatar.setOnClickListener(this);
    }

    @NonNull
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
