package com.wangzijie.nutrition_user.adapter;

import android.content.Context;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.SiteBean;

import java.util.List;

public class SitewinAdapter extends BaseQuickAdapter<SiteBean.DataBean.AreaListBean, BaseViewHolder> {

    private Context mcontext;

    public SitewinAdapter(int layoutResId, @Nullable List<SiteBean.DataBean.AreaListBean> data, Context mcontext) {
        super(layoutResId, data);
        this.mcontext = mcontext;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, SiteBean.DataBean.AreaListBean data) {
        baseViewHolder.setText(R.id.site_site, data.getAreaName());
//        baseViewHolder.setText(R.id.site_chens, data.getCounty());
//        baseViewHolder.setText(R.id.site_guoj, data.getState());
    }
}
