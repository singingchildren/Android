package com.wangzijie.nutrition_user.adapter.news;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.find.NewsListBean;
import com.wangzijie.nutrition_user.utils.TimeUtils;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

/**
 * @author fanjiangpeng
 * 将新闻中设置数据公共部分抽取
 */
public abstract class BaseNewsItemProvider extends BaseItemProvider<NewsListBean, BaseViewHolder> {

    public BaseNewsItemProvider() {
    }

    @Override
    public void convert(BaseViewHolder helper, NewsListBean findRecommendBean, int i) {
        if (TextUtils.isEmpty(findRecommendBean.getTitle())) {
            //如果没有标题，则直接跳过
            return;
        }


        //设置标题、底部作者、评论数、发表时间
        helper.setText(R.id.tv_title_item_news, findRecommendBean.getTitle())
                .setText(R.id.tv_author_item_news, findRecommendBean.getAuthor())
                .setText(R.id.tv_comments_item_news, findRecommendBean.getComment() + ToastUtil.getString(R.string.comment))
                .setText(R.id.tv_time_item_news, TimeUtils.getShortTime(findRecommendBean.getCreate_time() * 1000));

        setData(helper, findRecommendBean);
    }

    protected abstract void setData(BaseViewHolder helper, NewsListBean news);
}
