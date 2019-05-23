package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.HomeData;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;

import java.util.ArrayList;

/**
 * @author WangZequan
 * @time 2019/5/2 12:20
 * @describe
 */
public class HomeDietitianAdapter extends BaseQuickAdapter<HomeData.DataBean.DietitianBean, BaseViewHolder> {

    private Context context;

    public HomeDietitianAdapter(int item_health_advisory, ArrayList<HomeData.DataBean.DietitianBean> dietitianBeans, Context context) {
        super(item_health_advisory, dietitianBeans);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomeData.DataBean.DietitianBean dietitianBean) {

        if ("".equals( dietitianBean.getNickname())){
            baseViewHolder.setText(R.id.tv_dietitian_name_home_item, "昵称");
        }else{
            baseViewHolder.setText(R.id.tv_dietitian_name_home_item, dietitianBean.getNickname());
        }


        if ("".equals( dietitianBean.getAvatar())){

            ImageView imageView = baseViewHolder.getView(R.id.iv_dietitian_logo_home_item);
            Glide.with(context)
                    .asBitmap()
                    .load(R.drawable.my3)
                    .error(R.drawable.head)
                    .into(new MyGlideHeaderLoader(imageView,context));

        }else{
            ImageView imageView = baseViewHolder.getView(R.id.iv_dietitian_logo_home_item);
            Glide.with(context)
                    .asBitmap()
                    .load(dietitianBean.getAvatar())
                    .error(R.drawable.head)
                    .into(new MyGlideHeaderLoader(imageView,context));
        }



    }

}
