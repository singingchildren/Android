package com.wangzijie.nutrition_user.adapter.nutritionist;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.FriendBean;

import java.util.List;

public class FriendAdapter extends BaseQuickAdapter<FriendBean.DataBean, BaseViewHolder> {
    public FriendAdapter(@Nullable List<FriendBean.DataBean> data) {
        super(R.layout.item_friend, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FriendBean.DataBean friendBean) {
        if (friendBean.getId() == 0 && friendBean.getId() ==1){
            baseViewHolder.getView(R.id.iv_message).setVisibility(View.GONE);
        }else {

        }
        if (friendBean.getTags()!= null) {
            if (friendBean.getTags().size() > 0) {
                if (friendBean.getTags().size() == 1) {
                    baseViewHolder.setVisible(R.id.type1, true).setText(R.id.type1, friendBean.getTags().get(0).getName());
                } else if (friendBean.getTags().size() == 2) {
                    baseViewHolder.setVisible(R.id.type1, true).setText(R.id.type1, friendBean.getTags().get(0).getName());
                    baseViewHolder.setVisible(R.id.type2, true).setText(R.id.type2, friendBean.getTags().get(1).getName());
                }
            } else {
                baseViewHolder.setVisible(R.id.type1, false).setVisible(R.id.type2, false);
            }
        }
        baseViewHolder.setText(R.id.tv_name,friendBean.getNickname());
        baseViewHolder.addOnClickListener(R.id.item);

    }
}
