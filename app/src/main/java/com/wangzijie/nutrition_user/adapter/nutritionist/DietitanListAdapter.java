package com.wangzijie.nutrition_user.adapter.nutritionist;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.DietitianBean;

import java.util.List;

/**
 * @author fanjiangpeng
 * 首页营养师列表适配器
 */
public class DietitanListAdapter extends BaseQuickAdapter<DietitianBean, BaseViewHolder> {
    public DietitanListAdapter(@Nullable List<DietitianBean> data) {
        super(R.layout.item_dieditian, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DietitianBean dietitianBean) {
        baseViewHolder.setText(R.id.name,dietitianBean.getNickname()).addOnClickListener(R.id.image);
        ImageView imageView = baseViewHolder.getView(R.id.image);
        Glide.with(mContext).load(dietitianBean.getAvatar()).error(R.drawable.head).into(imageView);
    }
}
