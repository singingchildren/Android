package com.wangzijie.nutrition_user.adapter.nutritionist;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.HealthParkBean;

import java.util.List;

public class HealthParkAdapter extends BaseQuickAdapter<HealthParkBean.DataBean.MenuListBean, BaseViewHolder> {
    public HealthParkAdapter(@Nullable List<HealthParkBean.DataBean.MenuListBean> data) {
        super(R.layout.item_home_paradise, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HealthParkBean.DataBean.MenuListBean dataBean) {
        baseViewHolder.setText(R.id.grenn_live,dataBean.getTitle())
                .setText(R.id.read_numder, dataBean.getPrivate_count()+"")
                .setText(R.id.transmit_numder,dataBean.getPageviews()+"");
        Glide.with(mContext)
                .load(dataBean.getImg_url())
//                .error(R.drawable.home_experience)
                .apply((RequestOptions.bitmapTransform(new RoundedCorners(70))))
                .into((ImageView) baseViewHolder.getView(R.id.green_image));
        baseViewHolder.addOnClickListener(R.id.item);
    }
}
