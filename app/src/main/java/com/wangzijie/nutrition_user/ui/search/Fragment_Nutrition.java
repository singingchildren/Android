package com.wangzijie.nutrition_user.ui.search;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

/**
 * 搜索营养师
 */
public class Fragment_Nutrition extends BaseFragment {

    public static Fragment_Nutrition getInstance(){
        return new Fragment_Nutrition();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initUI() {
        super.initUI();
    }
}
