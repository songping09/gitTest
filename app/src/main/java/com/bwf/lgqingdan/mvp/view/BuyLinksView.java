package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseBuyLinks;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public interface BuyLinksView {
    void showBuyLinks(List<ResponseBuyLinks.DataBean.BuylinksBean> buylinks);
    void showLoading();
    void hideLoading();
    void showLoadFailed(String failedMsg);
}
