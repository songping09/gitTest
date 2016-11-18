package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ThingsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public interface RelatedThingModel {
    void loadData(int articlleId,Callback callback);
    public interface Callback{
        void loadSuccess(List<ThingsBean> things);
        void loadFailed(String failedMsg);
    }
}
