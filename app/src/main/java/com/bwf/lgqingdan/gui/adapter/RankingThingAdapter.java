package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/7.
 */

public class RankingThingAdapter extends BaseRecycleViewAdapter<ThingsBean> {
    //item类型
    private static final int ITEM_TYPE_CONTENT = 0;
    private static final int ITEM_TYPE_FOOTER = 1;
    private static final int ITEM_TYPE_FOOTER2 = 2;
    public static final int STATE_GONE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE_DATA = 2;
    public static final int STATE_LOAD_FAILED = 3;
    public static final int STATE_NO_SEARCH_DATA = 4;
    private int state;


    public void updateFooterState(int state) {
        this.state = state;
        notifyDataSetChanged();
    }

    public RankingThingAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getHeaderItemCount() {
        return 0;
    }

    @Override
    protected int getFooterItemCount() {
        return 2;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return ITEM_TYPE_FOOTER2;
        }
        if (position == getItemCount() - 2) {
            return ITEM_TYPE_FOOTER;
        }
        return ITEM_TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_FOOTER) {
            return createFooterHolder(parent);
        }
        if (viewType == ITEM_TYPE_FOOTER2) {
            View view = inflaterView(R.layout.layout_ranking_thing_footer, parent);
            return new FooterHolder2(view);
        }
        View view = inflaterView(R.layout.list_item_ranking_thing, parent);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_TYPE_FOOTER) {
            bindFooterViewHolder(holder, position);
            return;
        }
        if(getItemViewType(position) == ITEM_TYPE_FOOTER2){
            FooterHolder2 footerHolder2 = (FooterHolder2) holder;
            if(state == STATE_NO_SEARCH_DATA || state == STATE_NO_MORE_DATA){
                footerHolder2.footerView.setVisibility(View.VISIBLE);
            }else{
                footerHolder2.footerView.setVisibility(View.GONE);
            }
            return;
        }
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        ThingsBean bean = getItem(position);
        viewHolder.imgItemRankingThingCover.setImageURI(bean.getFeaturedImageUrl());
        viewHolder.tvItemRankingThingName.setText(bean.getFullName().replace(bean.getName(), ""));
        viewHolder.tvItemRankingThingTitle.setText(bean.getName());
        if(bean.isShowRatingScore()){
            viewHolder.tvScoreNum.setText(getContext().getString(R.string.score_and_review, bean.getRatingScore() + "", bean.getReviewCount()));
        }else {
            viewHolder.tvScoreNum.setText(getContext().getString(R.string.text_no_rating_score));
        }

        viewHolder.ratingScore.setRating(bean.getRatingScore());
    }

    protected RecyclerView.ViewHolder createFooterHolder(ViewGroup parent) {
        return new FooterHolder(inflaterView(R.layout.subview_recycleview_loadfooter, parent));
    }

    protected void bindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        FooterHolder mHolder = (FooterHolder) holder;
        switch (state) {
            case STATE_GONE:
                return;
            case STATE_LOADING:
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                break;
            case STATE_NO_MORE_DATA:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.noMoreData));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(false);
                break;
            case STATE_LOAD_FAILED:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.loadDataFailedAndClickRetry));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(true);
                break;
            case STATE_NO_SEARCH_DATA:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.no_Search_data));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(false);
                break;
        }
        mHolder.layoutSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
    }

    class ItemViewHolder extends BaseViewHolder {
        @BindView(R.id.img_item_ranking_thing_cover)
        SimpleDraweeView imgItemRankingThingCover;
        @BindView(R.id.tv_item_ranking_thing_name)
        TextView tvItemRankingThingName;
        @BindView(R.id.tv_item_ranking_thing_title)
        TextView tvItemRankingThingTitle;
        @BindView(R.id.img_review)
        ImageView imgReview;
        @BindView(R.id.tv_review_btn)
        TextView tvReviewBtn;
        @BindView(R.id.ll_review)
        LinearLayout llReview;
        @BindView(R.id.rating_score)
        RatingBar ratingScore;
        @BindView(R.id.tv_score_num)
        TextView tvScoreNum;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressbar_subview_recycleview_loadfooter)
        ProgressBar progressbarSubviewRecycleviewLoadfooter;
        @BindView(R.id.textview_subview_recycleview_loadfooter)
        TextView textviewSubviewRecycleviewLoadfooter;
        @BindView(R.id.layout_subview_recycleview_loadfooter)
        RelativeLayout layoutSubviewRecycleviewLoadfooter;

        FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            textviewSubviewRecycleviewLoadfooter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onRetryClick();
                    }
                }
            });
        }
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }

    private BaseMainRecycleViewAdapter.OnRetryClickListener listener;

    public void setOnRetryClickListener(BaseMainRecycleViewAdapter.OnRetryClickListener listener) {
        this.listener = listener;
    }

    static class FooterHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_prompt)
        TextView tvPrompt;
        @BindView(R.id.tv_btn_review_other_thing)
        TextView tvBtnReviewOtherThing;
        View footerView;
        FooterHolder2(View view) {
            super(view);
            this.footerView = view;
            ButterKnife.bind(this, view);
        }
    }
}
