package com.bwf.lgqingdan.gui.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public abstract class BaseAdapterViewAdapter<T> extends BaseAdapter{
    private List<T> datas;
    private Context context;
    private LayoutInflater inflater;

    public Context getContext() {
        return context;
    }
    public List<T> getDatas() {
        return datas;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public BaseAdapterViewAdapter(Context context) {
        this.datas = new ArrayList<>();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position){
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = onCreateViewHolder(parent,getItemViewType(position));
        }else{
            holder  = (ViewHolder) convertView.getTag();
        }
        holder.position = position;
        onBindViewHolder(holder,position);
        return holder.itemView;
    }

    public void setDatas(List<T> datas){
        this.datas.clear();
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }
    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void clearDatas(){
        datas.clear();
        notifyDataSetChanged();
    }
    protected View inflaterView(int layoutRes, ViewGroup viewGroup){
        return getInflater().inflate(layoutRes,viewGroup,false);
    }

    public abstract ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
    public abstract void onBindViewHolder(ViewHolder holder,int position);
    public static class ViewHolder{
        View itemView;
        int position;
        public ViewHolder(View itemView) {
            itemView.setTag(this);
            this.itemView = itemView;
        }
    }
}
