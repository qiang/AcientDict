package com.adorkable.acientdict.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.annotation.InjectContentView;
import com.adorkable.acientdict.entity.DictInitEntity;
import com.adorkable.acientdict.mvp.contract.InitContract;
import com.adorkable.acientdict.mvp.presenter.InitPresenter;
import com.adorkable.acientdict.ui.activity.SearchActivity;
import com.adorkable.acientdict.ui.base.BaseViewFragment;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 查词
 */

@InjectContentView(R.layout.fragment_dict)
public class DictFragment extends BaseViewFragment<InitContract.Presenter>
        implements InitContract.View {

    private InitContract.Presenter dictPresenter;

    @BindView(R.id.rl_search_btn_wrapper)
    RelativeLayout searchBtnWrapper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dictPresenter = new InitPresenter(this);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dictPresenter.loadData();
        initEvent();
    }

    private void initEvent() {
        searchBtnWrapper.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
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
        Log.i("Q_M:", "-00-" + isVisibleToUser);
    }

    @Override
    public InitContract.Presenter setPresenter() {
        return new InitPresenter(this);
    }
}
