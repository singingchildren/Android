package com.wangzijie.nutrition_user.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.MoreData;

import java.util.List;

import androidx.annotation.Nullable;

public class DinMoreAdapter extends BaseQuickAdapter<MoreData.DataBeanX.DataBean, BaseViewHolder> {

    public DinMoreAdapter(@Nullable List<MoreData.DataBeanX.DataBean> data) {
        super(R.layout.item_dingoodnutrition, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MoreData.DataBeanX.DataBean dataBean) {
        baseViewHolder.setText(R.id.din_more_name,dataBean.getNickname());
        baseViewHolder.setText(R.id.dinmore_matter,dataBean.getDescr());
        Glide.with(mContext).load(dataBean.getAvatar()).apply((RequestOptions.bitmapTransform
                (new RoundedCorners(120)))).into((ImageView) baseViewHolder.getView(R.id.dinmore_head));
        baseViewHolder.addOnClickListener(R.id.dinitem_more);
        baseViewHolder.addOnClickListener(R.id.din_morebtn);
    }


}
