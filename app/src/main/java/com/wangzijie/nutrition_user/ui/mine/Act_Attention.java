package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.TextView;

import androidx.core.view.ViewCompat;

import com.google.android.material.tabs.TabLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.ContentPagerAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.ui.search.Fragment_Article;
import com.wangzijie.nutrition_user.ui.search.Fragment_Nutrition;
import com.wangzijie.nutrition_user.ui.search.Fragment_Studio;
import com.wangzijie.nutrition_user.weight.ControlScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我得关注
 */
public class Act_Attention extends BaseActivity {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpageer)
    ControlScrollViewPager viewpageer;

    private List<String> tabIndicators;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private ContentPagerAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.act_attention;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        initContent();
        initTab();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initTab(){
        tab.setTabMode(TabLayout.MODE_FIXED);
        ViewCompat.setElevation(tab, 10);
        tab.setupWithViewPager(viewpageer);
        for (int i = 0; i < tabIndicators.size(); i++) {
            TabLayout.Tab itemTab = tab.getTabAt(i);
            if (itemTab!=null){
                itemTab.setCustomView(R.layout.item_search_layout_custom);
                TextView itemTv = (TextView) itemTab.getCustomView().findViewById(R.id.tv_menu_item);
                View line = itemTab.getCustomView().findViewById(R.id.line);
                if (i == 0){
                    line.setVisibility(View.VISIBLE);
                }else{
                    line.setVisibility(View.GONE);
                }
                itemTv.setText(tabIndicators.get(i));
            }
        }
        tab.getTabAt(0).getCustomView().setSelected(true);

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view =  tab.getCustomView();
                View line =  view.findViewById(R.id.line);
                line.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view =  tab.getCustomView();
                View line =  view.findViewById(R.id.line);
                line.setVisibility(View.GONE);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initContent(){
        String[] titles ={"文章","营养师工作室","营养师"};
        tabIndicators = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            tabIndicators.add(titles[i]);
        }
        fragmentList = new ArrayList<>();
        fragmentList.add(Fragment_Article.getInstance());
        fragmentList.add(Fragment_Nutrition.getInstance());
        fragmentList.add(Fragment_Studio.getInstance());
        adapter = new ContentPagerAdapter(getSupportFragmentManager(),fragmentList,tabIndicators);
        viewpageer.setAdapter(adapter);
    }

}
