package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.bwf.lgqingdan.entity.ResponseReviews;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;

/**
 * Created by LG on 2016/11/10.
 * Tips:
 */

public class ThingDetailRecucleViewAdapter
        extends BaseRecycleViewAdapter<ResponseReviews.DataBean.ReviewsBean> {
    public ThingDetailRecucleViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getHeaderItemCount() {
        return 0;
    }

    @Override
    protected int getFooterItemCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
