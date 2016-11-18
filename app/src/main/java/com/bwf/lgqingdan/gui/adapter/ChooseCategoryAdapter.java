package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

;

/**
 * Created by Administrator on 2016/11/6.
 */

public class ChooseCategoryAdapter extends BaseAdapter {
    private List<CategoriesBean> datas;
    private LayoutInflater inflater;
    private Context context;
    //最多显示几个分类
    private static final int maxShowNum = 8;
    public ChooseCategoryAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
    }

    public void setDatas(List<CategoriesBean> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    public boolean isShowMore(){
        return maxShowNum != getCount();
    }
    @Override
    public int getCount() {
        return datas.size() > maxShowNum?maxShowNum+1:datas.size();
    }

    @Override
    public CategoriesBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_great_category, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if(getCount() > maxShowNum && position == getCount()-1){
            holder.ivItemGreatCategory.setVisibility(View.GONE);
            holder.tvItemGreatCategory.setVisibility(View.GONE);
            holder.tvItemGreatCategoryCheckMore.setVisibility(View.VISIBLE);
        }else{
            holder.ivItemGreatCategory.setVisibility(View.VISIBLE);
            holder.tvItemGreatCategory.setVisibility(View.VISIBLE);
            holder.tvItemGreatCategoryCheckMore.setVisibility(View.GONE);
            CategoriesBean bean = getItem(position);
            holder.ivItemGreatCategory.setImageURI(bean.getFeaturedImageUrl());
            holder.tvItemGreatCategory.setText(bean.getName());
            switch (position%4){
                case 0:
                    holder.tvItemGreatCategory.setBackgroundColor(context.getResources().getColor(R.color.great_category_bg_1));
                    break;
                case 1:
                    holder.tvItemGreatCategory.setBackgroundColor(context.getResources().getColor(R.color.great_category_bg_2));
                    break;
                case 2:
                    holder.tvItemGreatCategory.setBackgroundColor(context.getResources().getColor(R.color.great_category_bg_3));
                    break;
                case 3:
                    holder.tvItemGreatCategory.setBackgroundColor(context.getResources().getColor(R.color.great_category_bg_4));
                    break;
            }
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_item_great_category)
        TextView tvItemGreatCategory;
        @BindView(R.id.iv_item_great_category)
        SimpleDraweeView ivItemGreatCategory;
        @BindView(R.id.tv_item_great_category_check_more)
        TextView tvItemGreatCategoryCheckMore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
