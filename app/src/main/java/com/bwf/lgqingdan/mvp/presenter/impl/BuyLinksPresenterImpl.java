package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseBuyLinks;
import com.bwf.lgqingdan.mvp.model.BuyLinksModel;
import com.bwf.lgqingdan.mvp.model.impl.BuyLinksModelImpl;
import com.bwf.lgqingdan.mvp.presenter.BuyLinksPresenter;
import com.bwf.lgqingdan.mvp.view.BuyLinksView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public class BuyLinksPresenterImpl implements BuyLinksPresenter, BuyLinksModel.Callback {
    private BuyLinksModel model;
    private BuyLinksView view;

    public BuyLinksPresenterImpl(BuyLinksView view) {
        this.view = view;
        this.model = new BuyLinksModelImpl();
    }

    @Override
    public void loadBuyLinks(int thingId) {
        model.loadBuyLinks(thingId,this);
        view.showLoading();
    }

    @Override
    public void loadBuyLinksSuccess(List<ResponseBuyLinks.DataBean.BuylinksBean> buylinks) {
        view.showBuyLinks(buylinks);
        view.hideLoading();
    }

    @Override
    public void loadFailed(String failedMsg) {
        view.showLoadFailed(failedMsg);
        view.hideLoading();
    }
}
