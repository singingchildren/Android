package com.wangzijie.nutrition_user.adapter.nutritionist;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.ShopHeadData;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;

import java.util.List;

public class ShopDietitianAdapter extends BaseQuickAdapter<ShopHeadData.DataBean, BaseViewHolder> {
    public ShopDietitianAdapter(@Nullable List<ShopHeadData.DataBean> data) {
        super(R.layout.item_shop_dietitian, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder,ShopHeadData.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_name,dataBean.getNickname()).addOnClickListener(R.id.item);
        ImageView imageView = baseViewHolder.getView(R.id.imageView61);
        Glide.with(mContext)
                .asBitmap()
                .load(dataBean.getAvatar())
                .error(R.drawable.head)
                .into(new MyGlideHeaderLoader(imageView, mContext));
    }


}
