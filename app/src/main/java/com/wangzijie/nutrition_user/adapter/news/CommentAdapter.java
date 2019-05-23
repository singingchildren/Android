package com.wangzijie.nutrition_user.adapter.news;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.NewsData;
import java.util.List;

import androidx.annotation.Nullable;

public class CommentAdapter extends BaseQuickAdapter<NewsData, BaseViewHolder> {
    public CommentAdapter( @Nullable List<NewsData> data) {
        super(R.layout.item_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NewsData commentData) {
//        baseViewHolder.setText(R.id.tv_name, commentData.getUser_name())
//                .setText(R.id.tv_auter, String.valueOf(commentData.getDigg_count()))
//                .setText(R.id.tv_comment, commentData.getText());
        baseViewHolder.addOnClickListener(R.id.tv_reply);
    }
}
