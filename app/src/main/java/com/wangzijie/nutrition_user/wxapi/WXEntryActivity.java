package com.wangzijie.nutrition_user.wxapi;


import android.os.Bundle;

import com.umeng.socialize.weixin.view.WXCallbackActivity;
import com.wangzijie.nutrition_user.R;

/**
 *  微信登录\分享回调
 */
public class WXEntryActivity extends WXCallbackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);


    }
}
