package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseBuyLinks;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public interface BuyLinksModel {
    void loadBuyLinks(int thingId, Callback callback);
    public interface Callback{
        void loadBuyLinksSuccess(List<ResponseBuyLinks.DataBean.BuylinksBean> buylinks);
        void loadFailed(String failedMsg);
    }
}
