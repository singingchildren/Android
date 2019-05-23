package com.wangzijie.nutrition_user.adapter.nutritionist;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.UserFileListBean;

import java.util.List;

/**
 * @author fanjiangpeng
 */
public class UserFileAdapter extends BaseQuickAdapter<UserFileListBean.DataBean.ListBean, BaseViewHolder> {
    public UserFileAdapter(@Nullable List<UserFileListBean.DataBean.ListBean> data) {
        super(R.layout.item_user_files, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, UserFileListBean.DataBean.ListBean userFileBean) {
        baseViewHolder.setText(R.id.tv_name,userFileBean.getNickname()).setText(R.id.type,userFileBean.getGroup());
        baseViewHolder.addOnClickListener(R.id.item);
    }
}
