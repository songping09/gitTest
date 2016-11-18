package com.bwf.lgqingdan.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

;

/**
 * Created by Administrator on 2016/11/6.
 */

public class ChooseTagAdapter extends BaseAdapter {
    private List<TagsBean> datas;
    private LayoutInflater inflater;
    private Context context;

    public ChooseTagAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
    }

    public void setDatas(List<TagsBean> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size() == 0 ? 0 : datas.size() + 1;
    }

    @Override
    public TagsBean getItem(int position) {
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
            convertView = inflater.inflate(R.layout.list_item_hot_tag, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == getCount() - 1) {
            holder.tvItemHotTag.setVisibility(View.GONE);
            holder.ivItemHotTagBg.setVisibility(View.GONE);
            holder.tvItemHotCheckMore.setVisibility(View.VISIBLE);
        } else {
            TagsBean bean = getItem(position);
            holder.tvItemHotTag.setVisibility(View.VISIBLE);
            holder.ivItemHotTagBg.setVisibility(View.VISIBLE);
            holder.tvItemHotCheckMore.setVisibility(View.GONE);
            holder.tvItemHotTag.setText(bean.getName());
            holder.ivItemHotTagBg.setImageURI(bean.getCoverImage().getThumbnail().getImageUrl());
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_item_hot_tag_bg)
        SimpleDraweeView ivItemHotTagBg;
        @BindView(R.id.tv_item_hot_tag)
        TextView tvItemHotTag;
        @BindView(R.id.tv_item_hot_check_more)
        TextView tvItemHotCheckMore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
