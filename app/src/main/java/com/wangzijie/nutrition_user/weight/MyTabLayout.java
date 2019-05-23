package com.wangzijie.nutrition_user.weight;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.wangzijie.nutrition_user.R;

import java.util.ArrayList;
import java.util.List;



public class MyTabLayout extends TabLayout {
    private List<String> titles;

    public MyTabLayout(Context context) {
        super(context);
        init();
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        titles = new ArrayList<>();

        this.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(Tab tab) {
                /**
                 * 设置当前选中的Tab为特殊高亮样式。
                 */
                if (tab != null && tab.getCustomView() != null) {
                    TextView tab_text = tab.getCustomView().findViewById(R.id.tv_menu_itemone);

                    TextPaint paint = tab_text.getPaint();
                    paint.setFakeBoldText(true);

                    tab_text.setTextColor(getResources().getColor(R.color.green));

                    ImageView tab_layout_indicator = tab.getCustomView().findViewById(R.id.tab_indicator);
                    tab_layout_indicator.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }

            @Override
            public void onTabUnselected(Tab tab) {
                /**
                 * 重置所有未选中的Tab颜色、字体、背景恢复常态(未选中状态)。
                 */
                if (tab != null && tab.getCustomView() != null) {
                    TextView tab_text = tab.getCustomView().findViewById(R.id.tv_menu_itemone);

                    tab_text.setTextColor(getResources().getColor(R.color.black));
                    TextPaint paint = tab_text.getPaint();
                    paint.setFakeBoldText(false);

                    ImageView tab_indicator = tab.getCustomView().findViewById(R.id.tab_indicator);
                    tab_indicator.setBackgroundResource(0);
                }
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    public void setTitle(List<String> titles) {
        this.titles = titles;

        /**
         * 开始添加切换的Tab。
         */
        for (String title : this.titles) {
            Tab tab = newTab();
            tab.setCustomView(R.layout.item_tab_layout_custom);

            if (tab.getCustomView() != null) {
                TextView tab_text = tab.getCustomView().findViewById(R.id.tv_menu_itemone);
                tab_text.setText(title);
            }

            this.addTab(tab);
        }
    }
}