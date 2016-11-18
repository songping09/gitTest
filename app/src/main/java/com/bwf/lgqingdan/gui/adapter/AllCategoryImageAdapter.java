package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseAllCategory;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public class AllCategoryImageAdapter extends BaseRecycleViewAdapter<ResponseAllCategory.DataBean.CategoriesBean> {
    public AllCategoryImageAdapter(Context context) {
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
        View view = inflaterView(R.layout.list_item_all_category_image, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ResponseAllCategory.DataBean.CategoriesBean bean = getItem(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        if(selectedPosition == position){
            viewHolder.imageview.setImageURI(bean.getIcons().getActive().getImageUrl());
        }else{
            viewHolder.imageview.setImageURI(bean.getIcons().getInactive().getImageUrl());
        }
    }

    class ViewHolder extends BaseViewHolder{
        @BindView(R.id.imageview)
        SimpleDraweeView imageview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    private int selectedPosition;

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
}
