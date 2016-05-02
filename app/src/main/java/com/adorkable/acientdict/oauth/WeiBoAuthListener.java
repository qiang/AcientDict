package com.adorkable.acientdict.oauth;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;


import com.adorkable.acientdict.config.Constants;
import com.adorkable.acientdict.db.AccountInfoDaoImpl;
import com.adorkable.acientdict.db.dao.AccountInfoDao;
import com.adorkable.acientdict.entity.weibo.User;
import com.adorkable.acientdict.oauth.weibo.UsersAPI;
import com.adorkable.acientdict.util.Log;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuqiang on 10/21/15.
 */
public class WeiBoAuthListener implements WeiboAuthListener {


    private Context mContext;
    private UsersAPI mUsersAPI;
    private Oauth2AccessToken mAccessToken;

    private Callback callback;

    private AccountInfoDao accountInfoDao;

    public WeiBoAuthListener(Context mContext, Callback callback) {
        this.mContext = mContext;
        this.callback = callback;
        accountInfoDao = new AccountInfoDaoImpl(mContext);
    }

    @Override
    public void onComplete(Bundle values) {
        // 从 Bundle 中解析 Token
        mAccessToken = Oauth2AccessToken.parseAccessToken(values);
        if (mAccessToken != null && mAccessToken.isSessionValid()) {
            // 保存 Token 到 SharedPreferences
            //AccessTokenKeeper.writeAccessToken(mContext, mAccessToken);

            Log.i("Q_M:", mAccessToken.getToken());

            // 获取用户信息接口
            mUsersAPI = new UsersAPI(mContext, Constants.WEI_BO_APP_KEY, mAccessToken);

            //String uid = mAccessToken.getUid();
            long uid = Long.parseLong(mAccessToken.getUid());
            mUsersAPI.show(uid, mListener);

        } else {
            // 当您注册的应用程序签名不正确时，就会收到 Code，请确保签名正确
            //String code = values.getString("code", "");
            loginFail("微博授权失败");
            cancelDialog();
        }
    }

    @Override
    public void onCancel() {
        loginFail("取消微博授权");
        cancelDialog();
    }

    @Override
    public void onWeiboException(WeiboException e) {
        cancelDialog();
        loginFail("微博授权失败");
    }

    /**
     * 微博 OpenAPI 回调接口。
     */
    private RequestListener mListener = new RequestListener() {
        @Override
        public void onComplete(String response) {
            if (!TextUtils.isEmpty(response)) {
                // 调用 User#parse 将JSON串解析成User对象
                User user = User.parse(response);
                if (user != null) {
//                    Toast.makeText(mContext,
//                            "获取User信息成功，用户昵称：" + user.screen_name,
//                            Toast.LENGTH_LONG).show();
                    //向5tv服务器发消息
                    accessFiveTvServer(user);
                } else {
                    Toast.makeText(mContext, response, Toast.LENGTH_LONG).show();
                }
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {

        }
    };

    //和5tv的服务器通讯
    private void accessFiveTvServer(User user) {

        Log.i("Q_M:", user.toString());

        Map<String, String> params = new HashMap<>();

        params.put("token", mAccessToken.getToken());
        params.put("weibo_uid", user.idstr);
        params.put("headimgurl", user.avatar_hd == null ? user.profile_image_url : user.avatar_hd);
        params.put("nickname", user.name);
        params.put("autograph", user.description);    //个性签名
//        params.put("birthday", user.);    //
        params.put("gender", user.gender.equals("n") ? "unknown" : (user.gender.equals("f") ? "female" : "male"));    //

//        HttpUtil.postData(PostApi.postLogin(), params, new ResultCallback<AccountInfoModel>() {
//            @Override
//            public void onError(Request request, Exception e) {
//                Log.i("Q_M:", "" + e.toString());
//            }
//
//            @Override
//            public void onResponse(AccountInfoModel response) {
//                //设置内存数据
//                MyApplication.getInstance().setAccount(response.getData());
//                //更新界面和用户数据库
//                callback.updateMenu();
//                accountInfoDao.insertInfo(response.getData());
//            }
//        });
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    //取消dialog
    private void cancelDialog() {
//        Message msg = mHandler.obtainMessage();
//        msg.what = LoginActivity.MSG_DIALOG_DISMISS;
//        mHandler.sendMessage(msg);
    }

    private void loginSuccess() {
//        Message msg = mHandler.obtainMessage();
//        msg.what = LoginActivity.MSG_LOGIN_SUCCESS;
//        mHandler.sendMessage(msg);
    }

    private void loginFail(String msgStr) {
//        Message msg = mHandler.obtainMessage();
//        msg.what = LoginActivity.MSG_LOGIN_FAIL;
//        msg.obj = msgStr;
//        mHandler.sendMessage(msg);
    }

    /**
     * 登陆完成获取5tv服务器的数据后的回调
     */
    public interface Callback {
        void updateMenu();
    }
}