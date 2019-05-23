package com.wangzijie.nutrition_user.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.ReplyData;

import java.util.List;

import androidx.annotation.Nullable;

public class ReplyAdapter extends BaseQuickAdapter<ReplyData.DataBeanX.DataBean.DoubleDeckBean, BaseViewHolder> {


    public ReplyAdapter(int layoutResId, @Nullable List<ReplyData.DataBeanX.DataBean.DoubleDeckBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ReplyData.DataBeanX.DataBean.DoubleDeckBean doubleDeckBean) {

        baseViewHolder.setText(R.id.tv_auter,doubleDeckBean.getNickname());
        baseViewHolder.setText(R.id.tv_comment,doubleDeckBean.getContent());
        baseViewHolder.setText(R.id.tv_zan,doubleDeckBean.getAgree_count()+"");


    }
}
