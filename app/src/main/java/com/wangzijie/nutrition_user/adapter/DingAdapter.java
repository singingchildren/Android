package com.wangzijie.nutrition_user.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.DingData;

import java.util.List;

import androidx.annotation.Nullable;

public class DingAdapter extends BaseQuickAdapter<DingData, BaseViewHolder> {
    public DingAdapter(int layoutResId, @Nullable List<DingData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DingData dingData) {
        baseViewHolder.setText(R.id.ding_name,dingData.getName());
        baseViewHolder.setText(R.id.ding_money,dingData.getMoney());

    }
}
