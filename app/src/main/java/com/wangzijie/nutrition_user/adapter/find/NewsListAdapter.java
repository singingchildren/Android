package com.wangzijie.nutrition_user.adapter.find;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.MultipleItemRvAdapter;
import com.wangzijie.nutrition_user.adapter.news.LargeIconNewsItemProvider;
import com.wangzijie.nutrition_user.adapter.news.RightPicNewsItemProvider;
import com.wangzijie.nutrition_user.adapter.news.TextNewsItemProvider;
import com.wangzijie.nutrition_user.adapter.news.ThreePicNewsItemProvider;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 *  @author     WangZequan
 *  @time       2019/4/21  18:47
 *  @describe   新闻列表的适配器
 */
public class NewsListAdapter extends MultipleItemRvAdapter<NewsListBean, BaseViewHolder> {

    /**
     * 纯文字布局
     */
    public static final int ITEM_TYPE1 = 1;
    /**
     * 右侧小图布局(
     */
    public static final int ITEM_TYPE2 = 2;
    /**
     * 三张图片布局
     */
    public static final int ITEM_TYPE3 = 3;

    /**
     * 显示头像和大图新闻
     */
    public static final int ITEM_TYPE4 = 4;

    public NewsListAdapter(@Nullable List<NewsListBean> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(NewsListBean findRecommendBean) {
        return findRecommendBean.getNewsType();
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new TextNewsItemProvider());
        mProviderDelegate.registerProvider(new RightPicNewsItemProvider());
        mProviderDelegate.registerProvider(new ThreePicNewsItemProvider());
        mProviderDelegate.registerProvider(new LargeIconNewsItemProvider());
    }
}
