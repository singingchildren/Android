package com.wangzijie.nutrition_user.push;

import android.content.Context;

import com.hyphenate.chat.EMMipushReceiver;
import com.wangzijie.nutrition_user.utils.Log.AppLogMessageUtil;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;

/**
 * 集成小米推送相关推送广播接收器，处理推送相关数据信息，这里只是接受环信离线消息通知，不做任何处理
 */
public class MIPushReceiver extends EMMipushReceiver {
    private String Tag = MIPushReceiver.class.getSimpleName();

    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageClicked(context, miPushMessage);
        AppLogMessageUtil.e(Tag,"aaaaa");
    }

    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
    }

    @Override
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onCommandResult(context, miPushCommandMessage);
    }

    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
    }


}
