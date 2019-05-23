package com.wangzijie.nutrition_user.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.model.bean.ShopData;

import java.util.List;

import androidx.annotation.Nullable;

public class ShopAdapter extends BaseQuickAdapter<ShopData.DataBeanX.DataBean, BaseViewHolder> {


    public ShopAdapter(int layoutResId, @Nullable List<ShopData.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ShopData.DataBeanX.DataBean dataBean) {

    }
}
