package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseIncludeArticles;
import com.bwf.lgqingdan.gui.adapter.base.BaseAdapterViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/3.
 * tips: 商品详情中 收录文章的Adapter
 */

public class IncludeArticlesAdapter extends BaseAdapterViewAdapter<ResponseIncludeArticles.DataBean.ArticlesBean> {

    public IncludeArticlesAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflaterView(R.layout.subview_article_item, parent);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResponseIncludeArticles.DataBean.ArticlesBean articlesBean = getItem(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.imgArticleItem.setImageURI(articlesBean.getFeaturedImageUrl());
        viewHolder.textViewArticleItem.setText(articlesBean.getTitle());
    }

     class ItemViewHolder extends ViewHolder{
        @BindView(R.id.img_article_item)
        SimpleDraweeView imgArticleItem;
        @BindView(R.id.textView_article_item)
        TextView textViewArticleItem;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
