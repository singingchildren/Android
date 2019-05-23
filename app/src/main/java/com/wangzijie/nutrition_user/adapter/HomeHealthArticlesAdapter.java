package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.HomeData;

import java.util.List;

public class HomeHealthArticlesAdapter extends BaseQuickAdapter<HomeData.DataBean.RecommendBean, BaseViewHolder> {
    private Context mcontext;


    public HomeHealthArticlesAdapter(int layoutResId, @Nullable List<HomeData.DataBean.RecommendBean> dietitian, Context mcontext) {
        super(layoutResId, dietitian);
        this.mcontext = mcontext;
    }


    @Override
    protected void convert(BaseViewHolder helper, HomeData.DataBean.RecommendBean data) {
        helper.setText(R.id.tv_home_information_itme,data.getAbstractX())
                .setImageResource(R.id.iv_home_information_itme,R.drawable.banner1)
                .setText(R.id.tv_read_item_home,data.getRead_count());
//                .setText(R.id.tv_collect_item_home,data.getPrivate_count()+"");

        Glide.with(mcontext)
                .load(data.getImg_url())
                .error(R.drawable.banner1)
                .into((ImageView)helper.getView(R.id.iv_home_information_itme));
    }
}
