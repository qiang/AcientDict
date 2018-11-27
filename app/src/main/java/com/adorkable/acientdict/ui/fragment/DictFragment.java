package com.adorkable.acientdict.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.entity.DictInitEntity;
import com.adorkable.acientdict.mvp.presenter.DictPresenter;
import com.adorkable.acientdict.mvp.presenter.impl.DictPresenterImpl;
import com.adorkable.acientdict.mvp.view.DictView;
import com.adorkable.acientdict.ui.activity.SearchActivity;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 查词
 */
public class DictFragment extends BaseFragment implements DictView {

    private DictPresenter dictPresenter;

    @BindView(R.id.rl_search_btn_wrapper)
    RelativeLayout searchBtnWrapper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dictPresenter = new DictPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dict, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dictPresenter.loadData();
        initEvent();
    }

    private void initEvent() {
        searchBtnWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public String toString() {
        return "词典";
    }

    @Override
    public void updateView(DictInitEntity dictInitEntity) {
        //给界面赋值数据


    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("Q_M:","-00-"+isVisibleToUser);
    }
}
