package com.wangzijie.nutrition_user.adapter.news;

import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.find.NewsListAdapter;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;

public class TextNewsItemProvider extends BaseNewsItemProvider {


    @Override
    public int viewType() {
        return NewsListAdapter.ITEM_TYPE1;
    }

    @Override
    public int layout() {
        return R.layout.item_text_news;
    }

    @Override
    protected void setData(BaseViewHolder helper, NewsListBean news) {

    }
}
