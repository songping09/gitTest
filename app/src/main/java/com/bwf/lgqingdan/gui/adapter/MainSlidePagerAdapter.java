package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.gui.activity.ArticleDetailActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class MainSlidePagerAdapter extends PagerAdapter implements View.OnClickListener {
    private List<ResponseMainData.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> slides;

    private List<View> views;
    public MainSlidePagerAdapter(Context context,
                                 List<ResponseMainData.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> slides) {
        this.slides = slides;
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        for (int i = 0; i < slides.size(); i++) {
            View view = inflater.inflate(R.layout.subview_main_list_slide,null);
            view.setTag(view.findViewById(R.id.imageView_slide));
            views.add(view);
            view.findViewById(R.id.imageView_slide).setTag(i);
            view.setOnClickListener(this);
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
        imageView.setImageURI(slides.get(position%views.size()).getFeaturedImageUrl());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position%views.size());
        container.removeView(view);
    }

    @Override
    public void onClick(View v) {
        int index = (int) ((View)v.getTag()).getTag();
        ResponseMainData.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean slidesBean = slides.get(index);
        switch (slidesBean.getType()){
            case 1:
                Intent intent = new Intent(v.getContext(), ArticleDetailActivity.class);
                intent.putExtra(ArticleDetailActivity.ARTICLE_ID,Integer.parseInt(slidesBean.getTarget()));
                v.getContext().startActivity(intent);
                break;
            case 2:
                break;
        }


    }
}
