package com.wangzijie.nutrition_user.adapter;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.MyDingData;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.utils.DisplayUtils;

import java.util.List;

public class MyDingAdapter extends BaseQuickAdapter<OrderBean, BaseViewHolder> {
    //标签布局和view的id数组
    @IdRes int [] labelIds=new int[]{R.id.tv1_label_order,R.id.tv2_label_order
            ,R.id.tv3_label_order,R.id.tv4_label_order,R.id.ll_label_order};
    public MyDingAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderBean orderBean) {
        baseViewHolder.setText(R.id.ding_bian,orderBean.getOrderNum());
        //先隐藏两种不同的订单信息
        DisplayUtils.goneHolderView(baseViewHolder,labelIds);
        DisplayUtils.goneHolderView(baseViewHolder,R.id.tv_content_order);
        //根据不同的订单信息
        if (orderBean.getTypeArr()!=null&&orderBean.getTypeArr().length>0) {
            DisplayUtils.showHolderView(baseViewHolder,R.id.ll_label_order);
            for (int i = 0; i < orderBean.getTypeArr().length; i++) {
                DisplayUtils.showHolderView(baseViewHolder,labelIds[i]);
                baseViewHolder.setText(labelIds[i],orderBean.getTypeArr()[i]);
            }
        }else {
            DisplayUtils.showHolderView(baseViewHolder,R.id.tv_content_order);
            baseViewHolder.setText(R.id.tv_content_order,orderBean.getType());
        }
        if (orderBean.getState()==1){ //已完成
            baseViewHolder.setGone(R.id.ding_no,false);
            baseViewHolder.setGone(R.id.ding_go,false);
        }else if(orderBean.getState()==0) {
            baseViewHolder.setVisible(R.id.ding_no,true);
            baseViewHolder.setVisible(R.id.ding_go,true);
            baseViewHolder.addOnClickListener(R.id.ding_no);
            baseViewHolder.addOnClickListener(R.id.ding_go);

        }else {
            baseViewHolder.setGone(R.id.ding_no,false);
            baseViewHolder.setGone(R.id.ding_go,false);
        }

    }


}
