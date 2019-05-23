package com.wangzijie.nutrition_user.ui.home;

import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.ContentPagerAdapter;
import com.wangzijie.nutrition_user.base.BaseFragment;
import com.wangzijie.nutrition_user.model.bean.FindContent;
import com.wangzijie.nutrition_user.model.bean.NewsData;
import com.wangzijie.nutrition_user.ui.find.Fragment_Dietitian;
import com.wangzijie.nutrition_user.ui.find.Fragment_Recommend;
import com.wangzijie.nutrition_user.ui.find.Fragment_Recommend_Studio;
import com.wangzijie.nutrition_user.ui.find.findContent.FindContentContract;
import com.wangzijie.nutrition_user.ui.find.findContent.FindContentPersenter;
import com.wangzijie.nutrition_user.utils.JumpUtil;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发现Fragment
 */
public class Fragment_Find extends BaseFragment<FindContentPersenter> implements FindContentContract.View {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpageer)
    ViewPager viewpageer;
    @BindView(R.id.find_find)
    EditText findFind;

    private List<String> tabIndicators;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private ContentPagerAdapter adapter;

    public static Fragment_Find getInstance() {
        return new Fragment_Find();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected FindContentPersenter createPresenter() {
        return new FindContentPersenter();
    }

    @Override
    protected void initUI() {
        super.initUI();
        initContent();
        initTab();


    }

    /**
     * 用来改变tabLayout选中后的字体大小及颜色
     *
     * @param tab
     * @param isSelect
     */
    private void updateTabView(TabLayout.Tab tab, boolean isSelect) {
        //找到自定义视图的控件ID
        TextView tv_tab = (TextView) tab.getCustomView().findViewById(R.id.tv_menu_itemone);
        if (isSelect) {
            //设置标签选中
            tv_tab.setSelected(true);
            TextPaint tp = tv_tab.getPaint();
            tp.setFakeBoldText(true);
            //选中后字体变大
            tv_tab.setTextColor(ToastUtil.getColor(R.color.greens));
        } else {
            //设置标签取消选中
            tv_tab.setSelected(false);
            TextPaint tp = tv_tab.getPaint();
            tp.setFakeBoldText(false);
            //恢复为默认字体大小
            tv_tab.setTextColor(ToastUtil.getColor(R.color.tab));
        }
    }


    private void initTab() {
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(tab, 10);
        tab.setupWithViewPager(viewpageer);
        for (int i = 0; i < tabIndicators.size(); i++) {
            TabLayout.Tab itemTab = tab.getTabAt(i);
            if (itemTab != null) {
                itemTab.setCustomView(R.layout.item_tab_layout_custom);
                TextView itemTv = (TextView) itemTab.getCustomView().findViewById(R.id.tv_menu_itemone);
                itemTv.setText(tabIndicators.get(i));
            }
        }
        tab.getTabAt(0).getCustomView().setSelected(true);
        TextView tv_tab = tab.getTabAt(0).getCustomView().findViewById(R.id.tv_menu_itemone);
        tv_tab.setTextColor(ToastUtil.getColor(R.color.greens));
        TextPaint tp = tv_tab.getPaint();
        tp.setFakeBoldText(true);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabView(tab, true);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabView(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                updateTabView(tab, true);
            }
        });
    }

    private void initContent() {
      //  String[] titles = {"推荐", "营养师工作室", "营养师"};
        String[] titles = { "营养师工作室", "营养师"};
        tabIndicators = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            tabIndicators.add(titles[i]);
        }
        fragmentList = new ArrayList<>();
      //  fragmentList.add(Fragment_Recommend.getInstance());
        fragmentList.add(Fragment_Recommend_Studio.getInstance());
        fragmentList.add(Fragment_Dietitian.getInstance());

        adapter = new ContentPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, tabIndicators);
        viewpageer.setAdapter(adapter);
    }


    @OnClick(R.id.find_find)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.find_find:
                JumpUtil.overlay(getContext(), SeekActivity.class);
                break;
        }
    }

    @Override
    public void CommentSucess(NewsData newsData) {

    }

    @Override
    public void CommentErr(String msg) {

    }

    @Override
    public void FindContentSucess(FindContent findContent) {

    }

    @Override
    public void FindContentErr(String msg) {

    }
}
