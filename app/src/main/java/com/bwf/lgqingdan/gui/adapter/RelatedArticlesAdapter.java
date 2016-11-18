package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;
import com.bwf.lgqingdan.gui.adapter.base.BaseAdapterViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/3.
 * 文章详情中 相关文章 的Adapter
 */

public class RelatedArticlesAdapter extends BaseAdapterViewAdapter<ResponseRelatedArticles.DataBean.ArticlesBean> {

    public RelatedArticlesAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflaterView(R.layout.subview_article_item, parent);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResponseRelatedArticles.DataBean.ArticlesBean articlesBean = getItem(position);
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
