package com.wangzijie.nutrition_user.adapter;

import android.content.Context;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AssAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<Fragment> asslist;
    private ArrayList<String> astablist;

    public AssAdapter(FragmentManager fm, Context context, ArrayList<Fragment> asslist, ArrayList<String> astablist) {
        super(fm);
        this.context = context;
        this.asslist = asslist;
        this.astablist = astablist;
    }

    @Override
    public Fragment getItem(int position) {
        return asslist.get(position);
    }

    @Override
    public int getCount() {
        return astablist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return astablist.get(position);
    }
}
