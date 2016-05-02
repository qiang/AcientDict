package com.adorkable.acientdict.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.adorkable.acientdict.MyApplication;
import com.adorkable.acientdict.R;
import com.adorkable.acientdict.config.Constants;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI mWeiXinApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);

        mWeiXinApi = WXAPIFactory.createWXAPI(this, Constants.WEI_XIN_APP_ID, false);

        mWeiXinApi.handleIntent(getIntent(), this);

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {

        String toastMsg = "";
        int scene = -1;    //微信好友分享，还是朋友圈分享

        SendMessageToWX.Resp sendMsgResp = null;
        SendAuth.Resp authResp = null;


        if (baseResp instanceof SendAuth.Resp) {
            authResp = (SendAuth.Resp) baseResp;
        }else if(baseResp instanceof SendMessageToWX.Resp){
            sendMsgResp = (SendMessageToWX.Resp)baseResp;

            try {
                String sceneStr = sendMsgResp.transaction.substring(sendMsgResp.transaction.indexOf("_")+1);
                scene = Integer.parseInt(sceneStr);
            } catch (NumberFormatException e) {
                scene = -1;
            }

        }

        // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                if (authResp !=null){
                    MyApplication.getInstance().weiXinCode = authResp.code;
                    toastMsg = "微信登陆成功";
                }else if (sendMsgResp!=null){
                    //为了获取是微信好友分享，还是朋友圈分享
                    if (scene !=-1){
                        switch (scene){
                            case SendMessageToWX.Req.WXSceneSession:    //好友
                                toastMsg = "微信好友分享成功";
                                break;
                            case SendMessageToWX.Req.WXSceneTimeline:    //朋友圈
                                toastMsg = "微信朋友圈分享成功";
                                break;
                            case SendMessageToWX.Req.WXSceneFavorite:   //收藏
                                toastMsg = "微信收藏成功";
                                break;
                        }
                    }
                }
                break;

            case BaseResp.ErrCode.ERR_SENT_FAILED:    //发送失败
                if (authResp !=null){
                    toastMsg = "微信登陆失败";
                }else if(sendMsgResp!=null){
                    //为了获取是微信好友分享，还是朋友圈分享
                    if (scene !=-1){
                        switch (scene){
                            case SendMessageToWX.Req.WXSceneSession:    //好友
                                toastMsg = "微信好友分享失败";
                                break;
                            case SendMessageToWX.Req.WXSceneTimeline:    //朋友圈
                                toastMsg = "微信朋友圈分享失败";
                                break;
                            case SendMessageToWX.Req.WXSceneFavorite:   //收藏
                                toastMsg = "微信收藏失败";
                                break;
                        }
                    }
                }

                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:    //取消操作
                if (authResp !=null){
                    toastMsg = "取消微信登陆";
                }else if(sendMsgResp!=null){
                    //为了获取是微信好友分享，还是朋友圈分享
                    if (scene !=-1){
                        switch (scene){
                            case SendMessageToWX.Req.WXSceneSession:    //好友
                                toastMsg = "取消微信分享";
                                break;
                            case SendMessageToWX.Req.WXSceneTimeline:    //朋友圈
                                toastMsg = "取消微信分享";
                                break;
                            case SendMessageToWX.Req.WXSceneFavorite:   //收藏
                                toastMsg = "取消微信收藏";
                                break;
                        }
                    }
                }
                break;
            default:
                break;
        }

        if (!"".equals(toastMsg)){
            Toast.makeText(this,toastMsg, Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
