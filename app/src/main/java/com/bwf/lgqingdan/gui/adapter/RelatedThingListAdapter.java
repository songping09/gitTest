package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.gui.adapter.base.BaseAdapterViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/14.
 */

public class RelatedThingListAdapter extends BaseAdapterViewAdapter<ThingsBean> {
    public RelatedThingListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseAdapterViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = getInflater().inflate(R.layout.list_item_related_thing, null);
        return new ItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(BaseAdapterViewAdapter.ViewHolder holder, int position) {
        ThingsBean thingsBean = getItem(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.imgItemTagDetailsThingsCover.setImageURI(thingsBean.getFeaturedImageUrl());
        viewHolder.tvItemTagDetailsThingsTitle.setText(thingsBean.getFullName().replace(thingsBean.getName(),""));
        viewHolder.tvItemTagDetailsThingsContent.setText(thingsBean.getName());
        viewHolder.tvItemTagDetailsThingsPrice.setText(thingsBean.getPrice());
        viewHolder.tvItemTagDetailsThingsLikeCount.setText(thingsBean.getLikeCount()+"");
    }

    class ItemViewHolder extends BaseAdapterViewAdapter.ViewHolder{
        @BindView(R.id.img_item_tag_details_things_cover)
        SimpleDraweeView imgItemTagDetailsThingsCover;
        @BindView(R.id.tv_item_tag_details_things_title)
        TextView tvItemTagDetailsThingsTitle;
        @BindView(R.id.tv_item_tag_details_things_content)
        TextView tvItemTagDetailsThingsContent;
        @BindView(R.id.tv_item_tag_details_things_price)
        TextView tvItemTagDetailsThingsPrice;
        @BindView(R.id.tv_item_tag_details_things_like_count)
        TextView tvItemTagDetailsThingsLikeCount;
        @BindView(R.id.img_item_tag_details_things_like)
        ImageView imgItemTagDetailsThingsLike;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
