package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseBriefReviews;
import com.bwf.lgqingdan.gui.adapter.base.BaseAdapterViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/13.
 */

public class ThingDetailReviewListAdapter extends BaseAdapterViewAdapter<ResponseBriefReviews.DataBean.ReviewsBean> implements View.OnClickListener {
    public ThingDetailReviewListAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflaterView(R.layout.list_item_thing_detail_review, parent);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResponseBriefReviews.DataBean.ReviewsBean reviewsBean = getItem(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.imgReviewsItemAvatar.setImageURI(reviewsBean.getUser().getAvatarUrl());
        viewHolder.tvReviewsItemName.setText(reviewsBean.getUser().getNickname());
        viewHolder.ratingbarReviewsItemScore.setRating(reviewsBean.getRatingValue());
        viewHolder.tvReviewsItemTime.setText(reviewsBean.getCreatedAtDiffForHumans());
        viewHolder.tvReviewsItemContent.setText(reviewsBean.getBody());
        viewHolder.tvReviewsItemLikeNum.setText("" + reviewsBean.getLikeCount());
        viewHolder.tvReviewsItemCommentNum.setText(""+reviewsBean.getCommentCount());
        viewHolder.tvReviewsItemLikeNum.setTag(position);
        viewHolder.imgReviewsItemLike.setTag(position);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_reviews_item_like_num:
            case R.id.img_reviews_item_like:
                //TODO
                int position = (int) v.getTag();
                Toast.makeText(getContext(), "为" + getItem(position).getUser().getNickname()+"点赞", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    class ItemViewHolder extends ViewHolder {
        @BindView(R.id.img_reviews_item_avatar)
        SimpleDraweeView imgReviewsItemAvatar;
        @BindView(R.id.tv_reviews_item_name)
        TextView tvReviewsItemName;
        @BindView(R.id.ratingbar_reviews_item_score)
        RatingBar ratingbarReviewsItemScore;
        @BindView(R.id.tv_reviews_item_like_num)
        TextView tvReviewsItemLikeNum;
        @BindView(R.id.img_reviews_item_like)
        ImageView imgReviewsItemLike;
        @BindView(R.id.tv_reviews_item_comment_num)
        TextView tvReviewsItemCommentNum;
        @BindView(R.id.tv_reviews_item_time)
        TextView tvReviewsItemTime;
        @BindView(R.id.tv_reviews_item_content)
        TextView tvReviewsItemContent;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.tvReviewsItemLikeNum.setOnClickListener(ThingDetailReviewListAdapter.this);
            this.imgReviewsItemLike.setOnClickListener(ThingDetailReviewListAdapter.this);
        }
    }

}
