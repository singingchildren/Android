package com.wangzijie.nutrition_user.ui.search;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

/**
 * 搜索营养师工作室
 */
public class Fragment_Studio extends BaseFragment {

    public static Fragment_Studio getInstance(){
        return new Fragment_Studio();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {
    }
}
