package com.wangzijie.nutrition_user.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.SiteData;

import java.util.List;

import androidx.annotation.Nullable;

public class SiteAdapter extends BaseQuickAdapter<SiteData, BaseViewHolder> {
    private Context mcontext;

    public SiteAdapter(int layoutResId, @Nullable List<SiteData> data, Context mcontext) {
        super(layoutResId, data);
        this.mcontext = mcontext;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, SiteData siteData) {
        baseViewHolder.setText(R.id.site_itemtext, siteData.getRegion());
    }
}
