package com.bwf.lgqingdan.gui.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LG on 2016/10/23.
 * Tips:
 */

public abstract class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<T> datas = new ArrayList<>();

    private LayoutInflater inflater;

    private Context context;

    public List<T> getDatas() {
        return datas;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public Context getContext() {
        return context;
    }

    public BaseRecycleViewAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public T getItem(int position){
        return datas.get(position-getHeaderItemCount());
    }
    @Override
    public int getItemCount() {
        return getHeaderItemCount()+getContentItemCount()+getFooterItemCount();
    }

    protected abstract int getHeaderItemCount();
    protected abstract int getFooterItemCount();
    protected  int getContentItemCount(){
        return datas.size();
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

    protected  class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        T bean =  getItem(getAdapterPosition());
                        onItemClickListener.onItemClick(getAdapterPosition()-getHeaderItemCount(),v,bean);
                    }
                }
            });
        }
    }


    public interface OnItemClickListener<T>{
        void onItemClick(int position,View view,T data);
    }
    private BaseMainRecycleViewAdapter.OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(BaseMainRecycleViewAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
