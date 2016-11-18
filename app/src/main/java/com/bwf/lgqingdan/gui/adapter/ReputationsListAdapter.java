package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseReputationsList;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/13.
 * tips:口碑清单界面 Adapter
 */

public class ReputationsListAdapter extends BaseRecycleViewAdapter<ResponseReputationsList.DataBean.RankingsBean> {

    public ReputationsListAdapter(Context context) {
        super(context);
    }

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View headerView = inflaterView(R.layout.subview_reputations_list_header, parent);
            return new RecyclerView.ViewHolder(headerView){};
        }
        View view = inflaterView(R.layout.list_item_reputations_list, parent);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_ITEM){
            ResponseReputationsList.DataBean.RankingsBean rankingsBean = getItem(position);
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.tvItemReputationsListOfAllTitle.setText(rankingsBean.getTitle());
            itemViewHolder.tvThingNum.setText(rankingsBean.getThingCount()+"");
            itemViewHolder.tvReviewNum.setText(rankingsBean.getReviewCount()+"");
            itemViewHolder.imgItemReputationsListOfAllBg.setImageURI(rankingsBean.getFeaturedImageUrl());
        }
    }

    class ItemViewHolder extends BaseViewHolder {
        @BindView(R.id.img_item_reputations_list_of_all_bg)
        SimpleDraweeView imgItemReputationsListOfAllBg;
        @BindView(R.id.tv_item_reputations_list_of_all_title)
        TextView tvItemReputationsListOfAllTitle;
        @BindView(R.id.tv_thing_num)
        TextView tvThingNum;
        @BindView(R.id.tv_review_num)
        TextView tvReviewNum;
        @BindView(R.id.img_mark)
        ImageView imgMark;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

//    class HeaderViewHolder extends RecyclerView.ItemViewHolder{
//        @BindView(R.id.img)
//        ImageView img;
//        HeaderViewHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//            Toast.makeText(getContext(), "img.getDrawable().getIntrinsicHeight():" + img.getDrawable().getIntrinsicHeight(), Toast.LENGTH_SHORT).show();
//        }
//    }
}
