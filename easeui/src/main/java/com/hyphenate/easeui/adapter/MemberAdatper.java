package com.hyphenate.easeui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hyphenate.easeui.R;

import java.util.List;

import androidx.annotation.Nullable;

public class MemberAdatper extends BaseQuickAdapter<String, BaseViewHolder> {
    public MemberAdatper(@Nullable List<String> data) {
        super(R.layout.item_member, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.friend_name,s);
    }
}
