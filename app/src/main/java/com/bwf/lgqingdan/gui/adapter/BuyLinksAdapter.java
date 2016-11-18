package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseBuyLinks;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/14.
 */

public class BuyLinksAdapter extends BaseRecycleViewAdapter<ResponseBuyLinks.DataBean.BuylinksBean> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public BuyLinksAdapter(Context context) {
        super(context);
    }

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
            View headerView = inflaterView(R.layout.subview_buy_links_header, parent);
            return new RecyclerView.ViewHolder(headerView) {
            };
        }
        View view = inflaterView(R.layout.list_item_buylink, parent);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_ITEM){
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            ResponseBuyLinks.DataBean.BuylinksBean buylinksBean = getItem(position);
            viewHolder.imgLogo.setImageURI(buylinksBean.getPlatform().getLogoImageUrl());
            viewHolder.textViewPlatform.setText(buylinksBean.getPlatform().getName());
            viewHolder.textViewPrice.setText(buylinksBean.getPrice());
            if(buylinksBean.isHasDescription()){
                viewHolder.llDesc.setVisibility(View.VISIBLE);
                viewHolder.tvDesc.setText(buylinksBean.getDescription());
            }else{
                viewHolder.llDesc.setVisibility(View.GONE);
            }
        }
    }

     class ItemViewHolder extends BaseViewHolder{
        @BindView(R.id.img_logo)
        SimpleDraweeView imgLogo;
        @BindView(R.id.textView_platform)
        TextView textViewPlatform;
        @BindView(R.id.textView_buy)
        TextView textViewBuy;
        @BindView(R.id.textView_price)
        TextView textViewPrice;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.ll_desc)
        LinearLayout llDesc;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
