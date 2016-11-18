package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;

/**
 * Created by LG on 2016/10/20.
 * Tips:
 */

public class MainArticlesRecycleViewAdapter extends BaseMainRecycleViewAdapter<ResponseMainListData.DataBean.ArticlesBean> {

    public MainArticlesRecycleViewAdapter(Context context) {
        super(context);
    }
    //item类型
    private static final int ITEM_TYPE_CONTENT = 0;
    private static final int ITEM_TYPE_FOOTER = 1;
    @Override
    protected int getHeaderItemCount() {
        return 0;
    }

    @Override
    protected int getFooterItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount()-1){
            return ITEM_TYPE_FOOTER;
        }
        return ITEM_TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE_FOOTER){
            return createFooterHolder(parent);
        }
        return new MyViewHolder(inflaterView(R.layout.main_list_item, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == ITEM_TYPE_FOOTER){
            bindFooterViewHolder(holder,position);
            return;
        }
        MyViewHolder mHolder = (MyViewHolder) holder;
        ResponseMainListData.DataBean.ArticlesBean articlesBean = getItem(position);
        mHolder.imageViewFrontTopImage.setImageURI(articlesBean.getFeaturedImageUrl());
        mHolder.textViewFrontMainTitle.setText(articlesBean.getTitle());
        mHolder.textViewFrontSubtitle.setText(articlesBean.getExcerpt());
        mHolder.textViewFrontNumLiked.setText(articlesBean.getLikeCount()+"");
        mHolder.textViewNumReviews.setText(articlesBean.getHitCount()+"");
        if(articlesBean.getCategories() != null && articlesBean.getCategories().size() != 0)
            mHolder.relaSpecialTag.setText(articlesBean.getCategories().get(0).getName());
        mHolder.rotateTextViewDate.setText(parseDate(articlesBean.getPublishedAt()));
    }
}
