package com.wangzijie.nutrition_user.adapter.nutritionist;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.model.bean.DietitianProgramBean;

import java.util.List;

/**
 * @author fanjiangpeng
 * 项目列表
 */
public class DietitianProgramAdapter extends BaseQuickAdapter<DietitianProgramBean, BaseViewHolder> {
    public DietitianProgramAdapter(@Nullable List<DietitianProgramBean> data) {
        super(R.layout.item_dietitian_add_program, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DietitianProgramBean dietitianProgramBean) {

    }
}
