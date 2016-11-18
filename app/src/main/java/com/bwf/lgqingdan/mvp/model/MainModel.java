package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.entity.ResponseDailyTips;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public interface MainModel {
    void loadDatas(Callback callback);
    void loadMainData(Callback callback);
    void loadDailyTips(Callback callback);
    public interface Callback{
        void loadMainDataSuccess(ResponseMainData mainData);
        void loadMainDataFailed(String failedMessage);
        void loadDailyTipsSuccess(ResponseDailyTips dailyTips);
        void loadDailyTipsFailed(String failedMessage);
    }
}
