package com.wangzijie.nutrition_user.adapter.news;

import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.find.NewsListAdapter;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;

public class RightPicNewsItemProvider extends BaseNewsItemProvider {


    public RightPicNewsItemProvider() {
        super();
    }

    @Override
    protected void setData(BaseViewHolder helper, NewsListBean news) {

    }

    @Override
    public int viewType() {
        return NewsListAdapter.ITEM_TYPE2;
    }

    @Override
    public int layout() {
        return R.layout.item_pic_news;
    }


}
