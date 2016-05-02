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
import com.adorkable.acientdict.oauth.WeiBoAuthListener;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    //登陆相关
    private SsoHandler mWeiBoSsoHandler;    //微博登陆

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

        //微博的回调
        if (mWeiBoSsoHandler != null) {
            mWeiBoSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }

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
                startWeiBoAuthPage();
                break;

            case R.id.iv_login_close_btn:
                finish();
                break;

            default:
                break;
        }
    }

    /**
     * 开启微博授权页面
     */
    private void startWeiBoAuthPage() {
        //封装授权信息
        AuthInfo mAuthInfo = new AuthInfo(mContext, Constants.WEI_BO_APP_KEY, Constants.WEI_BO_REDIRECT_URL, Constants.WEI_BO_SCOPE);
        mWeiBoSsoHandler = new SsoHandler(LoginActivity.this, mAuthInfo);
        //开启授权Activity
        mWeiBoSsoHandler.authorize(new WeiBoAuthListener(mContext, new WeiBoAuthListener.Callback() {
            @Override
            public void updateMenu() {
                finish();
            }
        }));
    }

    /**
     * 微博短信登陆
     */
    private void startWeiBoPhoneAuthPage() {
        //封装授权信息
        AuthInfo mAuthInfo = new AuthInfo(mContext, Constants.WEI_BO_APP_KEY, Constants.WEI_BO_REDIRECT_URL, Constants.WEI_BO_SCOPE);
        mWeiBoSsoHandler = new SsoHandler(LoginActivity.this, mAuthInfo);
        mWeiBoSsoHandler.registerOrLoginByMobile("", new WeiBoAuthListener(mContext, null));
    }


}
