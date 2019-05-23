package com.wangzijie.nutrition_user.adapter.nutritionist;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hyphenate.chat.EMGroup;
import com.wangzijie.nutrition_user.R;

import java.util.List;

public class GroupListAdapter extends BaseQuickAdapter<EMGroup, BaseViewHolder> {
    public GroupListAdapter(@Nullable List<EMGroup> data) {
        super(R.layout.item_group_list, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, EMGroup group) {
        baseViewHolder.setText(R.id.tv_name,group.getGroupName()).addOnClickListener(R.id.tv_name);

    }
}
