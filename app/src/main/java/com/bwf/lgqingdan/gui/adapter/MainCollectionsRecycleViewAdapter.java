package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;

/**
 * Created by LG on 2016/10/20.
 * Tips:
 */

public class MainCollectionsRecycleViewAdapter extends BaseMainRecycleViewAdapter<ResponseMainListData.DataBean.CollectionsBean> {

    public MainCollectionsRecycleViewAdapter(Context context) {
        super(context);
    }
    //item类型
    private static final int ITEM_TYPE_CONTENT = 0;
    private static final int ITEM_TYPE_FOOTER = 1;
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
        ResponseMainListData.DataBean.CollectionsBean collectionsBean = getItem(position);
        mHolder.linearBottomCount.setVisibility(View.GONE);
        mHolder.imageViewFrontTopImage.setImageURI(collectionsBean.getFeaturedImageUrl());
        mHolder.textViewFrontMainTitle.setText(collectionsBean.getTitle());
        mHolder.textViewFrontSubtitle.setText(collectionsBean.getSubtitle());
        mHolder.textViewFrontNumLiked.setText(collectionsBean.getLikeCount()+"");
        mHolder.relaSpecialTag.setText("专题");
        mHolder.rotateTextViewDate.setText(parseDate(collectionsBean.getPublishedAt()));
    }

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
}
