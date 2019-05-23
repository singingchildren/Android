package com.wangzijie.nutrition_user.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.StopData;

import java.util.List;

public class StopAdapter extends BaseQuickAdapter<StopData.DataBean,BaseViewHolder> {

    public StopAdapter( @Nullable List<StopData.DataBean> data) {
        super(R.layout.item_stop,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StopData.DataBean dataBean) {
        baseViewHolder.setText(R.id.stop_name,dataBean.getTitle()).setText(R.id.stop_context,dataBean.getEnergyNum()+"千卡/h");
        baseViewHolder.setText(R.id.tv_import_stop_item,dataBean.getSumNum()+"");
        Glide.with(mContext).load(R.drawable.asspao).apply((RequestOptions.bitmapTransform
                (new RoundedCorners(30)))).into((ImageView) baseViewHolder.getView(R.id.stop_image));
        baseViewHolder.addOnClickListener(R.id.stop_con);
    }
}
