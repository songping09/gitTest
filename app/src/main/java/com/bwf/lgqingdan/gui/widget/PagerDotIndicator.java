package com.bwf.lgqingdan.gui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.lgqingdan.R;

import java.util.ArrayList;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class PagerDotIndicator implements ViewPager.OnPageChangeListener {
    private Context context;
    private ArrayList<View> dotsViews;
    private LinearLayout container;
    private  int resCurrentDot;
    private int resRegularDot;

    public PagerDotIndicator(Context context, LinearLayout container, ViewPager viewPager){
        this.context = context;
        this.container = container;
        this.dotsViews = new ArrayList<>();
        this.resCurrentDot = R.drawable.home_page_controls_hl;
        this.resRegularDot = R.drawable.home_page_controls_nor;
        viewPager.addOnPageChangeListener(this);
    }
    public void setCurrentDot(int position){
        for (int i = 0; i < dotsViews.size(); i++) {
            if(i == position){
                ((ImageView)dotsViews.get(i)).setImageResource(resCurrentDot);
            }else{
                ((ImageView)dotsViews.get(i)).setImageResource(resRegularDot);
            }
        }
    }
    public void setDotResource(int resCurrentDot, int resRegularDot){
        this.resCurrentDot = resCurrentDot;
        this.resRegularDot = resRegularDot;
    }
    public void setNumberDots(int pageNums) {
        this.dotsViews.clear();
        this.container.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(context);
        for(int i = 0;i < pageNums;i++){
            View dotView = inflater.inflate(R.layout.subview_indicator_dots,null);
            dotsViews.add(dotView.findViewById(R.id.imageView_indicator_dot));
            ((ImageView)dotsViews.get(i)).setImageResource(resRegularDot);
            container.addView(dotView);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentDot(position%dotsViews.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
