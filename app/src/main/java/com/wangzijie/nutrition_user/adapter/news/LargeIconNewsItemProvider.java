package com.wangzijie.nutrition_user.adapter.news;

import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.find.NewsListAdapter;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;

public class LargeIconNewsItemProvider extends BaseNewsItemProvider {



    @Override
    public int viewType() {
        return NewsListAdapter.ITEM_TYPE4;
    }

    @Override
    public int layout() {
        return R.layout.item_large_icon_news;
    }

    @Override
    protected void setData(BaseViewHolder helper, NewsListBean news) {

    }
}
