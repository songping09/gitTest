package com.bwf.lgqingdan.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.gui.fragment.MainListFragment;
import com.bwf.lgqingdan.utils.Contants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class MainSlideFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<MainListFragment> fragments;
    List<ResponseMainData.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean> channels;
    public MainSlideFragmentPagerAdapter(
            List<ResponseMainData.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean> channels,
            FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        this.channels = channels;
        fragments.add(MainListFragment.newInstance(Contants.TAG_NODES,"http://api.eqingdan.com/v1/front?page={0}"));
        for (int i = 0; i < channels.size(); i++) {
            String type = channels.get(i).getType();
            String urlTag = null;
            if("articles_belong_to_category".equals(type)){
                urlTag = "http://api.eqingdan.com/v1/categories/"+channels.get(i).getExtra().getCategory_slug()+"/articles?page={0}";
                fragments.add(MainListFragment.newInstance(Contants.TAG_ARTICLES,urlTag));
            }else if("articles_belong_to_collection".equals(type)){
                urlTag = "http://api.eqingdan.com/v1/collections/"
                        + channels.get(i).getExtra().getCollection_id()
                        +"/articles?page={0}";
                fragments.add(MainListFragment.newInstance(Contants.TAG_ARTICLES,urlTag));
            }else if("collections".equals(type)){
                urlTag = "http://api.eqingdan.com/v1/collections?page={0}";
                fragments.add(MainListFragment.newInstance(Contants.TAG_COLLECTIONS,urlTag));
            }

        }
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return  "最新";
        }
        return channels.get(position-1).getTitle();
    }

    public void refreshData() {
        for (int i = 0; i < fragments.size(); i++) {
            fragments.get(i).refreshData();
        }
    }
}
