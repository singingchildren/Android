package com.wangzijie.nutrition_user.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.DzhServiceBean;

import java.util.List;

public class DzhServiceAdapter extends BaseQuickAdapter<DzhServiceBean, BaseViewHolder> {
    public DzhServiceAdapter(@Nullable List<DzhServiceBean> data) {
        super(R.layout.item_dzhservice, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DzhServiceBean dzhServiceBean) {
        baseViewHolder.setText(R.id.name,dzhServiceBean.getProjects()+"")
                .setText(R.id.day,dzhServiceBean.getDays()+"天")
                .setText(R.id.price,"¥"+dzhServiceBean.getPrice()+"/");
        ImageView select = baseViewHolder.getView(R.id.select);
        if (dzhServiceBean.isSelect()){
            Glide.with(mContext).load(R.drawable.icon_dzh_yes).into(select);
        }else {
            Glide.with(mContext).load(R.drawable.icon_dzh_no).into(select);
        }
        baseViewHolder.addOnClickListener(R.id.select);
    }
}
