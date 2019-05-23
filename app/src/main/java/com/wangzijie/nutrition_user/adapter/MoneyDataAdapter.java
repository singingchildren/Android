package com.wangzijie.nutrition_user.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.model.bean.MoneyDingData;

import java.util.List;

import androidx.annotation.Nullable;

public class MoneyDataAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MoneyDataAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String  tag) {

    }
}
