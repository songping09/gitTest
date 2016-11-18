package com.bwf.lgqingdan.utils;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public class ReverseImageView extends SimpleDraweeView{
    public ReverseImageView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public ReverseImageView(Context context) {
        super(context);
    }

    public ReverseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private String selectedUrl;
    private String unSelectedUrl;

    public void setSelectedUrl(String selectedUrl) {
        this.selectedUrl = selectedUrl;
    }
    public void setUnSelectedUrl(String unSelectedUrl) {
        this.unSelectedUrl = unSelectedUrl;
    }
    public void select(){
        setImageURI(selectedUrl);
    }
    public void unSelect(){
        setImageURI(unSelectedUrl);
    }

}
