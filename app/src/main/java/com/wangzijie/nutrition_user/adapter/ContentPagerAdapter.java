package com.wangzijie.nutrition_user.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wangzijie.nutrition_user.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class
ContentPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragmentList = new ArrayList<>();
    private List<String> tabIndicators = new ArrayList<>();

    public ContentPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList, List<String> tabIndicators) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabIndicators = tabIndicators;
    }

    public ContentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return tabIndicators.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabIndicators.get(position);
    }
}
