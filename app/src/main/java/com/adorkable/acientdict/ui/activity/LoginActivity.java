package com.adorkable.acientdict.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.config.Constants;
import com.adorkable.acientdict.db.AccountInfoDaoImpl;
import com.adorkable.acientdict.db.dao.AccountInfoDao;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private AccountInfoDao accountInfoDao;
    private Context mContext;
    //
    private ImageView closeBtn;
    private View weiboLoginBtn;
    private View weixinLoginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        accountInfoDao = new AccountInfoDaoImpl(this);

        closeBtn = (ImageView) this.findViewById(R.id.iv_login_close_btn);
        weiboLoginBtn = this.findViewById(R.id.ll_weibo_login_wrapper);
        weixinLoginBtn = this.findViewById(R.id.ll_weixin_login_wrapper);

        closeBtn.setOnClickListener(this);
        weiboLoginBtn.setOnClickListener(this);
        weixinLoginBtn.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_weibo_login_wrapper:

                break;

            case R.id.iv_login_close_btn:
                finish();
                break;

            default:
                break;
        }
    }


}
