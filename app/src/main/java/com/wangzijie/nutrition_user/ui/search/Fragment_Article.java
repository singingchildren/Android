package com.wangzijie.nutrition_user.ui.search;

import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;

/**
 * 搜索文章
 */
public class Fragment_Article extends BaseFragment {


    public static Fragment_Article getInstance(){
         return new Fragment_Article();
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
