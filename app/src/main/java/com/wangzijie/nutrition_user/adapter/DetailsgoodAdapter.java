package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.utils.DetailsData;

import java.util.List;

import androidx.annotation.Nullable;

public class DetailsgoodAdapter extends BaseQuickAdapter<DetailsData, BaseViewHolder> {
    private Context mcontent;

    public DetailsgoodAdapter(int layoutResId, @Nullable List<DetailsData> data, Context mcontent) {
        super(layoutResId, data);
        this.mcontent = mcontent;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DetailsData detailsData) {
        Glide.with(mcontent).load(R.drawable.stop).into((ImageView) baseViewHolder.getView(R.id.zsimage));

    }
}
