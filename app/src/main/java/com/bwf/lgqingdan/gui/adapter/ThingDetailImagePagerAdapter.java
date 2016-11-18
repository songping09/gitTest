package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.lgqingdan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public class ThingDetailImagePagerAdapter extends PagerAdapter {
    private List<String> imgUrls;
    private List<View> views;

    public ThingDetailImagePagerAdapter(Context context, List<String> imgUrls) {
        this.imgUrls = imgUrls;
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        for (int i = 0; i < imgUrls.size(); i++) {
            View view = inflater.inflate(R.layout.subview_main_list_slide,null);
            view.setTag(view.findViewById(R.id.imageView_slide));
            views.add(view);
            view.findViewById(R.id.imageView_slide).setTag(i);
        }
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position%views.size());
        container.addView(view);
        SimpleDraweeView imageView = (SimpleDraweeView) view.getTag();
        imageView.setImageURI(imgUrls.get(position));
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position%views.size());
        container.removeView(view);
    }

}
