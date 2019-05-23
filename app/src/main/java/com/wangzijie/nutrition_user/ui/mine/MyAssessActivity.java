package com.wangzijie.nutrition_user.ui.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.adapter.AssAdapter;
import com.wangzijie.nutrition_user.base.BaseActivity;
import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.utils.DateTimeUtils;
import com.wangzijie.nutrition_user.utils.toast.ToastUtil;
import com.wangzijie.nutrition_user.weight.MyViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 会员我的评估Activity // 营养师评估报告Activity
 */
public class MyAssessActivity extends BaseActivity {

    @BindView(R.id.mess_image)
    ImageView messImage;
    @BindView(R.id.assess_table)
    TabLayout assessTable;
    @BindView(R.id.assess_vp)
    MyViewPager assessVp;



    public static String ntpTime;
    private ArrayList<Fragment> asslist = new ArrayList<>();
    private ArrayList<String> astablist = new ArrayList<>();
    private AssAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_assess;
    }

    @Override
    protected void initView() {
        astablist.add("饮食");
        astablist.add("睡眠");
        astablist.add("运动");
        astablist.add("心理");

        asslist.add(new Ass_FoodFragment());
        asslist.add(new Ass_SleepFragment());
        asslist.add(new Ass_SportsFragment());
        asslist.add(new Ass_MentalityFragment());

        adapter = new AssAdapter(getSupportFragmentManager(), this, asslist, astablist);

        assessVp.setAdapter(adapter);

        assessTable.setupWithViewPager(assessVp);

        assessVp.setOffscreenPageLimit(1);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        DateTimeUtils.getNTPTime(time -> ntpTime=time);
        initTab();
        TextView tv_tab = assessTable.getTabAt(0).getCustomView().findViewById(R.id.tv_menu_itemone);
        tv_tab.setTextColor(ToastUtil.getColor(R.color.greens));
        assessTable.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

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

    private void updateTabView(TabLayout.Tab tab, boolean isSelect) {
        //找到自定义视图的控件ID
        TextView tv_tab = (TextView) tab.getCustomView().findViewById(R.id.tv_menu_itemone);
        if (isSelect) {
            //设置标签选中
            tv_tab.setSelected(true);
            //选中后字体变大
            tv_tab.setTextColor(ToastUtil.getColor(R.color.greens));

        } else {
            //设置标签取消选中
            tv_tab.setSelected(false);
            //恢复为默认字体大小
            tv_tab.setTextColor(ToastUtil.getColor(R.color.tab));

        }
    }

    private void initTab() {
        assessTable.setTabMode(TabLayout.MODE_FIXED);
        assessTable.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(assessTable, 10);
        assessTable.setupWithViewPager(assessVp);
        for (int i = 0; i < astablist.size(); i++) {
            TabLayout.Tab itemTab = assessTable.getTabAt(i);
            if (itemTab != null) {
                itemTab.setCustomView(R.layout.item_tab_layout_custom);
                TextView itemTv = (TextView) itemTab.getCustomView().findViewById(R.id.tv_menu_itemone);
                itemTv.setText(astablist.get(i));
            }
        }
        assessTable.getTabAt(0).getCustomView().setSelected(true);

    }

    @OnClick(R.id.mess_image)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mess_image:
                finish();
                break;
        }
    }
}
