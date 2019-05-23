package com.wangzijie.nutrition_user.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @author WangZequan
 * @time 2019/4/26 23:39
 * @describe    自定义viewpager解决滑动冲突
 */
public class MyViewPager extends ViewPager {
    private boolean isInterceptTouchEvent;
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isInterceptTouchEvent() {
        return isInterceptTouchEvent;
    }

    public void setInterceptTouchEvent(boolean interceptTouchEvent) {
        isInterceptTouchEvent = interceptTouchEvent;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
        return isInterceptTouchEvent;
    }

}
