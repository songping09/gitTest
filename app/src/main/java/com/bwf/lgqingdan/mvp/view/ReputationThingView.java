package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ThingsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public interface ReputationThingView {
    void showThingsToView(int page,List<ThingsBean> things);
    void showLoading();
    void showFooterLoading();
    void showFooterLoadFailed();
    void showFooterNoMoreData();
    void showFooterNoSearchData();
}
