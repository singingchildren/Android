package com.wangzijie.nutrition_user.base.contract;

import android.util.Log;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BasePresenter<T extends BaseView> {


    //控制层要要控制的视图对象
    protected T view;
    protected int currentPage;

    //引用对象，防止内存泄漏
    private Reference<T> mViewRef;

    /**
     * 控制层和视图层绑定的方法
     *
     * @param view 视图层对象
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
        this.view = mViewRef.get();
        if (view!=null)
            Log.d("BasePresenter", "1");
    }

    /**
     * 得到视图层对象
     *
     * @return 视图层对象
     */
    public T getView() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }


    /**
     * 查看控制层和视图层是否处于绑定状态
     *
     * @return true是绑定 ，false是未绑定
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解绑控制层和视图层，在视图层摧毁时调用，防止相互引用带来的内存泄漏
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
