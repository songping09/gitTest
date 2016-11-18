package com.bwf.lgqingdan.gui.adapter.base;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LG on 2016/11/10.
 * Tips:
 */

public abstract class BaseHeaderFooterRecycleViewAdapter<T> extends BaseRecycleViewAdapter<T>{


    private List<Header> headers;
    public BaseHeaderFooterRecycleViewAdapter(Context context) {
        super(context);
    }

    public void addHeader(Header header){
        if(this.headers == null){
            this.headers = new ArrayList<>();
        }
        this.headers.add(header);
    }

    public static class Header{

    }
}
