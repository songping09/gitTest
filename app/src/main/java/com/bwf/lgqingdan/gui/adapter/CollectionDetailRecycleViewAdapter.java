package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseCollectionDetail;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/6.
 */

public class CollectionDetailRecycleViewAdapter extends BaseRecycleViewAdapter<ResponseCollectionDetail.Data.CollectionsBean.BodyBean.DataBean.ArticlesBean> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_CONTENT = 1;

    private ResponseCollectionDetail.Data.CollectionBean.BodyBean.DataBean headerData;

    public void setHeaderData(ResponseCollectionDetail.Data.CollectionBean.BodyBean.DataBean headerData) {
        this.headerData = headerData;
    }

    public CollectionDetailRecycleViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getHeaderItemCount() {
        return 1;
    }

    @Override
    protected int getFooterItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }
        return TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            return new ContentViewHolder(inflaterView(R.layout.list_item_collection_detail_article, parent));
        }
        return new HeaderViewHolder(inflaterView(R.layout.subview_collection_detail_header, parent));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position) == TYPE_HEADER){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            if(headerData != null){
                headerViewHolder.imageViewCollectionDetailTopImage.setImageURI(headerData.getFeaturedImageUrl());
                headerViewHolder.textViewCollectionDetailTitle.setText(headerData.getTitle());
                headerViewHolder.textViewCollectionDetailSubtitle.setText(headerData.getSubtitle());
            }
        }else{
            ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            ResponseCollectionDetail.Data.CollectionsBean.BodyBean.DataBean.ArticlesBean bean = getItem(position);
            contentViewHolder.imageViewCollectionDetailArticleIcon.setImageURI(bean.getFeaturedImageUrl());
            contentViewHolder.textViewCollectionDetailArticleTitle.setText(bean.getTitle());
            contentViewHolder.textViewArticleNumLiked.setText(bean.getLikeCount()+"");
            contentViewHolder.textViewNumReviews.setText(bean.getHitCount()+"");
        }
    }


    class ContentViewHolder extends BaseViewHolder {
        @BindView(R.id.imageView_collection_detail_article_icon)
        SimpleDraweeView imageViewCollectionDetailArticleIcon;
        @BindView(R.id.textView_collection_detail_article_title)
        TextView textViewCollectionDetailArticleTitle;
        @BindView(R.id.textView_article_num_liked)
        TextView textViewArticleNumLiked;
        @BindView(R.id.textView_num_reviews)
        TextView textViewNumReviews;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

     class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView_collection_detail_top_image)
        SimpleDraweeView imageViewCollectionDetailTopImage;
        @BindView(R.id.tag_view)
        TextView tagView;
        @BindView(R.id.textView_collection_detail_title)
        TextView textViewCollectionDetailTitle;
        @BindView(R.id.textView_collection_detail_subtitle)
        TextView textViewCollectionDetailSubtitle;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
