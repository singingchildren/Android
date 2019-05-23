package com.wangzijie.nutrition_user.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.MyApplication;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.utils.DisplayUtils;
import com.wangzijie.nutrition_user.utils.glide.MyGlideHeaderLoader;

import java.util.List;

public class MoreAdapter extends BaseQuickAdapter<MoreNutritionBean.DietListBean, BaseViewHolder> {


    public MoreAdapter(int layoutResId) {
        super(layoutResId);

    }

    public void setData(List<MoreNutritionBean.DietListBean> list){
        mData.clear();
        mData=list;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MoreNutritionBean.DietListBean dataBean) {
        Log.e(TAG, "创建营养师列表");
        baseViewHolder.setText(R.id.more_name,dataBean.getNickname());
//        baseViewHolder.setText(R.id.more_matter,dataBean.getDescr());
        ImageView  iv1= baseViewHolder.getView(R.id.more_head);

        if (MyApplication.globalData.isNutritionist()){
            DisplayUtils.goneHolderView(baseViewHolder,R.id.morebtn,R.id.btn_consult_dietician_item);
        }
        Glide.with(mContext)
                .asBitmap()
                .load(dataBean.getAvatar())
                .error(R.drawable.my3)
                .into(new MyGlideHeaderLoader(iv1, mContext));
        baseViewHolder.addOnClickListener(R.id.more_item);
        baseViewHolder.addOnClickListener(R.id.morebtn);
        baseViewHolder.addOnClickListener(R.id.btn_consult_dietician_item);

    }


}
