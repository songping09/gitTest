package com.bwf.lgqingdan.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by LG on 2016/10/15.
 * Tips: 主Acivity中的ViewPager的Adapter
 */

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public ScreenSlidePagerAdapter(List<Fragment> fragments,FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
