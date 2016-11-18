package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ThingsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public interface ReputationThingModel {
    void loadData(String url,Callback callback);
    public interface Callback{
        void loadSuccess(List<ThingsBean> things);
        void loadFailed();
        void noMoreData();
        void noSearchData();

    }
}
