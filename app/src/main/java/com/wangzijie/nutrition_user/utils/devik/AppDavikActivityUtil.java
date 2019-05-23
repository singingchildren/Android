package com.wangzijie.nutrition_user.utils.devik;

import android.app.Activity;
import android.content.Context;

import com.wangzijie.nutrition_user.ui.act.LoginActivity;
import com.wangzijie.nutrition_user.utils.JumpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * activity 堆栈管理工具
 */
public class AppDavikActivityUtil {


    /**
     * 存储activityStack
     */
    private static Stack<Activity> activityStack = new Stack<>();

    private static List<Activity> activityList = new ArrayList<>();

    /**
     * 单例模式
     */
    private static AppDavikActivityUtil instance;

    /**
     * 单例堆栈集合对象
     *
     * @return AppDavikActivityUtil 单例堆栈集合对象
     */
    public static AppDavikActivityUtil getScreenManager() {
        if (instance == null) {
            synchronized (AppDavikActivityUtil.class) {
                instance = new AppDavikActivityUtil();
            }
        }
        return instance;
    }

    /**
     * 堆栈中销毁并移除
     *
     * @param activity 指定act 对象
     */
    public void removeActivity(Activity activity) {
        if (null != activity) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;

        }
    }

    /**
     * 栈中销毁并移除所有Act对象
     */
    public void removeAllActivity() {
        if (null != activityStack && activityStack.size() > 0) {
            //创建临时集合对象
            Stack<Activity> activityTemp = new Stack<Activity>();
            for (Activity activity : activityStack) {
                if (null != activity) {
                    //添加到零时集合中
                    activityTemp.add(activity);
                    //结束Activity
                    activity.finish();
                }
            }
            activityStack.removeAll(activityTemp);

        }
        System.gc();
        System.exit(0);

    }

    /**
     * 栈中销毁并移除所有Act对象
     */
    public void jumpLogin(Context context) {
        if (null != activityStack && activityStack.size() > 0) {
            //创建临时集合对象
            Stack<Activity> activityTemp = new Stack<Activity>();
            for (Activity activity : activityStack) {
                if (null != activity) {
                    //添加到零时集合中
                    activityTemp.add(activity);
                    //结束Activity
                    activity.finish();
                }
            }
            activityStack.removeAll(activityTemp);

        }
        JumpUtil.overlay(context, LoginActivity.class);

    }


    /**
     * 获取当前act对象
     *
     * @return activity 当前act
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (!activityStack.empty()) {
            activity = activityStack.lastElement();
        }
        return activity;
    }

    /**
     * 获得当前Act的类名
     *
     * @return String
     */
    public String getCurrentActivityName() {
        String actSimpleName = "";
        if (!activityStack.empty()) {
            actSimpleName = activityStack.lastElement().getClass().getSimpleName();
        }
        return actSimpleName;
    }

    /**
     * 将act纳入堆栈集合中
     *
     * @param activity act对象
     */
    public void addAcitivy(Activity activity) {
        if (null == activityStack) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public void clearActiivty() {
        for (int i = 0; i < activityList.size(); i++) {
            activityList.get(i).finish();
        }
    }

    /**
     * 推出栈中所有activity
     *
     * @param cls return void
     */
    public void exitApp(Class<?> cls) {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            removeActivity(activity);
        }
        System.gc();
        System.exit(0);
    }
}
