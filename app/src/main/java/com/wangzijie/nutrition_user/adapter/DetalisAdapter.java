package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.utils.DetailsData;

import java.util.List;

public class DetalisAdapter extends BaseQuickAdapter<DetailsData, BaseViewHolder> {
    private Context mcontext;
    public DetalisAdapter(int layoutResId, @Nullable List<DetailsData> data, Context mcontext) {
        super(layoutResId, data);
        this.mcontext = mcontext;
    }



    @Override
    protected void convert(BaseViewHolder baseViewHolder, DetailsData detailsData) {
            Glide.with(mcontext).load(R.drawable.book).into((ImageView) baseViewHolder.getView(R.id.zsimage));
    }
}
