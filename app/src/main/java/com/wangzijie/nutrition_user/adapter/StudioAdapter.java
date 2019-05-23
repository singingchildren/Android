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
import com.wangzijie.nutrition_user.model.bean.StudioListBean;

import java.util.List;
/**
 *  @author     WangZequan
 *  @time       2019/4/21  22:43
 *  @describe   工作室列表适配器
 */
public class StudioAdapter extends BaseQuickAdapter<StudioListBean.DataBean.StudioBean, BaseViewHolder> {
    private Context context;

    public StudioAdapter(int layoutResId, @Nullable List<StudioListBean.DataBean.StudioBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StudioListBean.DataBean.StudioBean dataBean) {
        baseViewHolder.setText(R.id.studio_title, dataBean.getSP_NAME());
        baseViewHolder.setText(R.id.studio_content, dataBean.getSP_DESC());
        baseViewHolder.setText(R.id.studio_mi, dataBean.getSP_ADDRESS());
        baseViewHolder.setText(R.id.studio_number, dataBean.getAgree_count());
        Glide.with(mContext).load(dataBean.getSP_LOGOURL()).apply((RequestOptions.bitmapTransform
                (new RoundedCorners(30)))).into((ImageView) baseViewHolder.getView(R.id.studio_image));
        baseViewHolder.addOnClickListener(R.id.studio_item);

    }

}
