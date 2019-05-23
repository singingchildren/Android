package com.wangzijie.nutrition_user.adapter.nutritionist;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hyphenate.easeui.model.Userinfo;
import com.wangzijie.nutrition_user.R;

import java.util.List;

public class SelectAdapter extends BaseQuickAdapter<Userinfo, BaseViewHolder> {
    public SelectAdapter(@Nullable List<Userinfo> data) {
        super(R.layout.item_user_files, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Userinfo userinfo) {
        baseViewHolder.setText(R.id.tv_name,userinfo.getUserId());
        baseViewHolder.getView(R.id.iv_select).setVisibility(View.VISIBLE);
        baseViewHolder.addOnClickListener(R.id.iv_select);
        if (userinfo.isSelect()){
            Glide.with(mContext).load(R.drawable.icon_select).into((ImageView) baseViewHolder.getView(R.id.iv_select));
        }else {
            Glide.with(mContext).load(R.drawable.icon_no_select).into((ImageView) baseViewHolder.getView(R.id.iv_select));
        }

    }
}
