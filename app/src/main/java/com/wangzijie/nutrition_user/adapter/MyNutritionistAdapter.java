package com.wangzijie.nutrition_user.adapter;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.MyDietitianBean;
import com.wangzijie.nutrition_user.utils.DisplayUtils;

import java.util.List;

/**
 * @author WangZequan
 * @time 2019/4/25 23:10
 * @describe
 */
public class MyNutritionistAdapter extends BaseQuickAdapter<MyDietitianBean.DataBean, BaseViewHolder> {
    @IdRes
    int[] labelIds = new int[]{R.id.tv1_label_my_nutritionist, R.id.tv2_label_my_nutritionist
            , R.id.tv3_label_my_nutritionist, R.id.tv4_label_my_nutritionist};

    public MyNutritionistAdapter(int layoutResId, @Nullable List<MyDietitianBean.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, MyDietitianBean.DataBean myNutritionistBean) {
        DisplayUtils.goneHolderView(baseViewHolder, labelIds);
        baseViewHolder.setText(R.id.details_name, myNutritionistBean.getRealname())
                .setText(R.id.details_username, myNutritionistBean.getNickname())
                .setText(R.id.detalis_id, myNutritionistBean.getAccount())
                .setText(R.id.details_region, myNutritionistBean.getLocation());
//        Glide.with(mContext).load(myNutritionistBean.getAvatar()).into();
        for (int i = 0; i < myNutritionistBean.getLabel().size(); i++) {
            DisplayUtils.showHolderView(baseViewHolder, labelIds[i]);
            baseViewHolder.setText(labelIds[i], myNutritionistBean.getLabel().get(i).getTag());
        }
    }
}
