package com.wangzijie.nutrition_user.ui.mine;

import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.weight.MyTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的收藏act
 *
 * @author fanjiangpeng
 */
public class Act_Collection extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tab)
    MyTabLayout tab;

    private ArrayList<String> tablist = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.act_collection;
    }

    @Override
    protected void initView() {
        title.setText("我的收藏");

        tablist.add("文章");
        tablist.add("工作室");
        tab.setTitle(tablist);
        fragmentList = new ArrayList<>();
        fragmentList.add(new CollectionArticleFragment());
        fragmentList.add(new CollectionStudioFragment());

        selectFragment(0);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                selectFragment(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {

//        getCollections
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }


}
