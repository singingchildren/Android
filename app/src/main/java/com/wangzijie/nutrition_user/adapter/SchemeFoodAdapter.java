package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.HealthPlanBean;
import com.wangzijie.nutrition_user.presenter.FoodBean;
import com.wangzijie.nutrition_user.utils.SchemeFood;

import java.util.List;

public class SchemeFoodAdapter extends BaseQuickAdapter<FoodBean, BaseViewHolder> {
    private Context context;

    public SchemeFoodAdapter(int layoutResId, @Nullable List<FoodBean> data, Context context) {
        super(layoutResId,data);
        this.context = context;
    }



    public SchemeFoodAdapter(int layoutResId, Context context) {
        super(layoutResId);
        this.context = context;
    }

    public void setData(List<FoodBean> data){
        mData=data;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FoodBean bean) {
        baseViewHolder.setText(R.id.schemefood_name,bean.name);

        Glide.with(context).load(bean.iconResId).apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                .into((ImageView) baseViewHolder.getView(R.id.schemefood_image));


    }
}
