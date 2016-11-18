package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseReputationsList;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public interface ReputationsListView {
    void showReputations(List<ResponseReputationsList.DataBean.RankingsBean> rankings);
    void showNoMoreData();
    void showLoadFailed(String failedMsg);
}
