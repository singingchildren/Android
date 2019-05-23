package com.wangzijie.nutrition_user.ui.message;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MessageFragmentPageAdapter extends FragmentPagerAdapter {

    //添加fragment的集合
    private List<Fragment> mFragmentList;
    //添加标题的集合
    private List<String> mTilteLis;

    public MessageFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tilteLis) {
        super(fm);
        mFragmentList = fragmentList;
        mTilteLis = tilteLis;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    //获取标题
    @Override
    public CharSequence getPageTitle(int position) {

        return mTilteLis.get(position);
    }

}
