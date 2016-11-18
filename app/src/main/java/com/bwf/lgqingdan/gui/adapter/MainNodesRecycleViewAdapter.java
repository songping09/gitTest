package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.entity.ResponseReputation;
import com.bwf.lgqingdan.gui.activity.ReputationThingActivity;
import com.bwf.lgqingdan.gui.activity.ReputationsListActivity;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LG on 2016/10/20.
 * Tips:
 */

public class MainNodesRecycleViewAdapter extends BaseMainRecycleViewAdapter<ResponseMainListData.DataBean.NodesBean> {
    private List<ResponseReputation.DataBean.RankingsBean> reputations;
    //item类型
    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_CONTENT = 1;
    private static final int ITEM_TYPE_FOOTER = 2;

    public MainNodesRecycleViewAdapter(Context context) {
        super(context);
        reputations = new ArrayList<>();
    }
    /**
     * 设置口碑数据
     *
     * @param reputations
     */
    public void setReputations(List<ResponseReputation.DataBean.RankingsBean> reputations) {
        this.reputations.clear();
        this.reputations.addAll(reputations);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_HEADER;
        } else if (position == getItemCount() - 1) {
            return ITEM_TYPE_FOOTER;
        }
        return ITEM_TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderHolder(inflaterView(R.layout.layout_head_enter_rankings, parent));
        } else if (viewType == ITEM_TYPE_FOOTER) {
            return createFooterHolder(parent);
        }
        return new MyViewHolder(inflaterView(R.layout.main_list_item, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_TYPE_HEADER) {
            HeaderHolder mHolder = (HeaderHolder) holder;
            if (mHolder.llItemRankingEnter.getChildCount() == 0 && reputations.size() != 0) {
                mHolder.imageViews = new ArrayList<>();
                for (int i = 0; i < reputations.size(); i++) {
                    View view = inflaterView(R.layout.subview_reputation, mHolder.llItemRankingEnter);
                    mHolder.imageViews.add((SimpleDraweeView) view.findViewById(R.id.img_ranking_all_topic_enter));
                    mHolder.llItemRankingEnter.addView(view);
                    view.setTag(i);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), ReputationThingActivity.class);
                            int index = (int) v.getTag();
                            intent.putExtra(ReputationThingActivity.RANKING_ID, reputations.get(index).getId());
                            intent.putExtra(ReputationThingActivity.RANKING_TITLE, reputations.get(index).getTitle());
                            getContext().startActivity(intent);
                        }
                    });
                }
            }
            if (mHolder.llItemRankingEnter.getChildCount() != 0 && reputations.size() != 0) {
                for (int i = 0; i < mHolder.imageViews.size(); i++) {
                    mHolder.imageViews.get(i).setImageURI(reputations.get(i).getThumbnailImageUrl());
                }
            }
            return;
        }
        if (getItemViewType(position) == ITEM_TYPE_FOOTER) {
            bindFooterViewHolder(holder, position);
            return;
        }
        MyViewHolder mHolder = (MyViewHolder) holder;
        ResponseMainListData.DataBean.NodesBean nodesBean = null;
        nodesBean = getItem(position);
        mHolder.imageViewFrontTopImage.setImageURI(nodesBean.getFeaturedImageUrl());
        mHolder.textViewFrontMainTitle.setText(nodesBean.getTitle());
        mHolder.textViewFrontSubtitle.setText(nodesBean.getSubtitle());
        mHolder.textViewFrontNumLiked.setText(nodesBean.getLikeCount() + "");
        mHolder.textViewNumReviews.setText(nodesBean.getHitCount() + "");
        if (nodesBean.getCategories() != null && nodesBean.getCategories().size() != 0)
            mHolder.relaSpecialTag.setText(nodesBean.getCategories().get(0).getName());
        mHolder.rotateTextViewDate.setText(parseDate(nodesBean.getPublishedAt()));
    }

    @Override
    protected int getHeaderItemCount() {
        return 1;
    }

    @Override
    protected int getFooterItemCount() {
        return 1;
    }

     class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_item_ranking_enter)
        LinearLayout llItemRankingEnter;
        @BindView(R.id.img_ranking_all_topic_enter)
        ImageView imgRankingAllTopicEnter;
        List<SimpleDraweeView> imageViews;

        public HeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            llItemRankingEnter = (LinearLayout) itemView.findViewById(R.id.ll_item_ranking_enter);
            imgRankingAllTopicEnter.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ReputationsListActivity.class);
                    getContext().startActivity(intent);
                }
            });
        }
    }


}
