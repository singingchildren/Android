package com.wangzijie.nutrition_user.adapter;

import android.content.Context;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class VpAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tablist;
    private ArrayList<Fragment> flist;
    private Context mcontext;

    public VpAdapter(FragmentManager fm, ArrayList<String> tablist, ArrayList<Fragment> flist, Context mcontext) {
        super(fm);
        this.tablist = tablist;
        this.flist = flist;
        this.mcontext = mcontext;
    }

    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return tablist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }
}
