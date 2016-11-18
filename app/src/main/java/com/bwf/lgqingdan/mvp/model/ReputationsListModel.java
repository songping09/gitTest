package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseReputationsList;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public interface ReputationsListModel {
    void loadData(String url,Callback callback);
    public interface Callback{
        void loadSuccess(List<ResponseReputationsList.DataBean.RankingsBean> rankings);
        void noMoreDatas();
        void loadFailed(String failedMsg);
    }
}
