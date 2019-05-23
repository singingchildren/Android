package com.wangzijie.nutrition_user.adapter;

import android.content.Context;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;

import java.util.List;

public class SchemeAdapter extends BaseQuickAdapter<MyHealthGuidePlan2Bean.DataBean.PlanListBean, BaseViewHolder> {
    private Context context;

    public SchemeAdapter(@Nullable List<MyHealthGuidePlan2Bean.DataBean.PlanListBean> data) {
        super(R.layout.layout_schemeitem, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MyHealthGuidePlan2Bean.DataBean.PlanListBean schemeData) {
        baseViewHolder.setText(R.id.scheme_name,schemeData.getTimeStr());
        baseViewHolder.setText(R.id.scheme_content,schemeData.getContent());
        baseViewHolder.addOnClickListener(R.id.scheme_conone);
        baseViewHolder.addOnClickListener(R.id.scheme_contwo);



    }
}
