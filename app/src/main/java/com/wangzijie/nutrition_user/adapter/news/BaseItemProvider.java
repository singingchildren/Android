package com.wangzijie.nutrition_user.adapter.news;

import android.content.Context;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public abstract class BaseItemProvider<T, V extends BaseViewHolder> {

    public Context mContext;
    public List<T> mData;

    public BaseItemProvider() {
    }

    public abstract int viewType();

    public abstract int layout();

    public abstract void convert(V var1, T var2, int var3);

    public void onClick(V helper, T data, int position) {
    }

    public boolean onLongClick(V helper, T data, int position) {
        return false;
    }

}
