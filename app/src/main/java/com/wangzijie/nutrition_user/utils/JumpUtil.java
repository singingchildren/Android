package com.wangzijie.nutrition_user.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.wangzijie.nutrition_user.Constant;
import com.wangzijie.nutrition_user.MainActivity;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.SimpleWebActivity;
import com.wangzijie.nutrition_user.WebActivity;
import com.wangzijie.nutrition_user.model.bean.LoginData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.ui.act.LocalVideoActivity;
import com.wangzijie.nutrition_user.ui.mine.MoneyActivity;

/**
 * 界面跳转 工具类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.util
 * @fileName: JumpUtil
 * @date: 2018/7/20  17:17
 * @author: ymc
 * @QQ:745612618
 */

public class JumpUtil {

    /**
     * 不带参数的跳转
     *
     * @param context
     * @param targetClazz
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz) {
        Intent mIntent = new Intent(context, targetClazz);
//        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mIntent);
    }

    /**
     * 带参数不带动画的跳转
     *
     * @param context
     * @param targetClazz
     * @param bundle
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz, Bundle bundle) {
        Intent mIntent = new Intent(context, targetClazz);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        context.startActivity(mIntent);
    }

    public static void jumpWebActivity(Context context, String name, String id, String url) {
        Intent mIntent = new Intent(context, WebActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("id", id);
        bundle.putString("name", name);
        mIntent.putExtras(bundle);
        context.startActivity(mIntent);
    }

    public static void jumpSimpleWebActivity(Context context, String url, String name, String id) {
        Intent mIntent = new Intent(context, SimpleWebActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("name", name);
        bundle.putString("url", url);
        mIntent.putExtras(bundle);
        context.startActivity(mIntent);
    }



    /**
     * 带参数,共享元素跳转
     *
     * @param context
     * @param targetClazz
     * @param bundle
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz, Bundle bundle, Bundle options) {
        Intent mIntent = new Intent(context, targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mIntent, options);
    }

    /**
     * @param context
     * @param targetClazz
     * @param bundle
     * @param flags
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz, Bundle bundle, Integer flags) {
        Intent mIntent = new Intent(context, targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        if (flags != null) {
            mIntent.setFlags(flags);
        }
        context.startActivity(mIntent);
    }


    /**
     * 界面跳转带 result
     *
     * @param context
     * @param targetClazz
     * @param requestCode
     * @param bundle
     */
    public static void startForResult(Activity context, Class<? extends Activity> targetClazz, int requestCode, Bundle bundle) {
        Intent mIntent = new Intent(context, targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        context.startActivityForResult(mIntent, requestCode);
    }

    /**
     * fragment 界面跳转 带result
     *
     * @param fragment
     * @param targetClazz
     * @param requestCode
     * @param bundle
     */
    public static void startForResult(Fragment fragment, Class<? extends Activity> targetClazz, int requestCode, Bundle bundle) {
        Intent mIntent = new Intent(fragment.getActivity(), targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        fragment.startActivityForResult(mIntent, requestCode);
    }

    /**
     * 登录成功后跳转到主页面
     *
     * @param activity
     * @param loginData
     */
    public static void jumpMain(Activity activity, LoginData loginData) {
        if (loginData.getData()==null) {
            Toast.makeText(activity, "登录失败", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean nutritionist = loginData.getData().getType().equals(Constant.DIETICIAN);
        MyApplication.globalData.setNutritionist(nutritionist);
        MyApplication.globalData.setToken(loginData.getData().getToken());
        MyApplication.globalData.setHxLogId(loginData.getData().getHxLogId());
        MyApplication.globalData.setHxPwd(loginData.getData().getHxPwd());
        MyApplication.globalData.setAreaName(loginData.getData().getAreaName());
        MyApplication.globalData.setAreaId(loginData.getData().getAreaId());
        Intent mIntent = new Intent(activity, MainActivity.class);
        activity.startActivity(mIntent);
        activity.finish();
    }


    public static void jumpLocalVideo(Activity activity,String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        Intent mIntent = new Intent(activity, LocalVideoActivity.class);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);
        activity.finish();
    }


    /**
     *  跳转到支付页面
     * @param activity
     * @param orderBean
     */
    public static void jumpMoney(Activity activity, OrderBean orderBean) {
        Intent intent2 = new Intent(activity, MoneyActivity.class);
        intent2.putExtra("bean",orderBean);
        activity.startActivityForResult(intent2,Constant.REQUEST_CODE_PAY);
    }
}
