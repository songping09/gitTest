package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ThingsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public interface RelatedThingView {
    void showlatedThings(List<ThingsBean> things);
    void showLoading();
    void showLoadFailed(String failedMsg);
}
