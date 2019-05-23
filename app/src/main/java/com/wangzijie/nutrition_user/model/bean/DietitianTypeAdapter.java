package com.wangzijie.nutrition_user.model.bean;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;

import java.util.List;


/**
 *  标签
 */
public class DietitianTypeAdapter extends BaseQuickAdapter<DieticianDetailsData.DataBean.LabelBean, BaseViewHolder> {
    public DietitianTypeAdapter(@Nullable List<DieticianDetailsData.DataBean.LabelBean>data) {
        super(R.layout.item_type, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DieticianDetailsData.DataBean.LabelBean labelBean) {
        baseViewHolder.setText(R.id.name,labelBean.getTag());
    }
}
