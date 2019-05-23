package com.wangzijie.nutrition_user;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.model.bean.HealthArticlesBean;

import java.util.List;

public class HealthArticlesAdapter extends BaseQuickAdapter<HealthArticlesBean.DataBean.InfoListBean, BaseViewHolder> {
    private Context mcontext;


    public HealthArticlesAdapter(int layoutResId, @Nullable List<HealthArticlesBean.DataBean.InfoListBean> dietitian, Context mcontext) {
        super(layoutResId, dietitian);
        this.mcontext = mcontext;
    }


    @Override
    protected void convert(BaseViewHolder helper, HealthArticlesBean.DataBean.InfoListBean data) {
        helper.setText(R.id.tv_home_information_itme,data.getTitle())
                .setImageResource(R.id.iv_home_information_itme,R.drawable.banner1)
                .setText(R.id.tv_read_item_home,data.getRead_count());
//                .setText(R.id.tv_collect_item_home,data.getPrivate_count()+"");

        Glide.with(mcontext)
                .load(data.getImg_url())
                .error(R.drawable.banner1)
                .into((ImageView)helper.getView(R.id.iv_home_information_itme));
    }
}
