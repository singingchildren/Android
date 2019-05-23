package com.wangzijie.nutrition_user.adapter.nutritionist;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.RecommendBean;

import java.util.List;

/**
 * @author fanjiangpeng
 * 健康咨询界面
 */
public class RecommendAdapter extends BaseQuickAdapter<RecommendBean, BaseViewHolder> {
    public RecommendAdapter(@Nullable List<RecommendBean> data) {
        super(R.layout.item_health_advisory, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RecommendBean recommendBean) {
//        ImageView imageView = baseViewHolder.getView(R.id.imageView26);
//        Glide.with(mContext).load(recommendBean.getImg_url()).error(R.drawable.banner1).into(imageView);
//        baseViewHolder.setText(R.id.textView56,recommendBean.getAbstractX())
//                .setText(R.id.textView51,recommendBean.getPageviews()+"")
//                .setText(R.id.textView53,recommendBean.getPrivate_count()+"");
//        baseViewHolder.addOnClickListener(R.id.item);
    }
}
