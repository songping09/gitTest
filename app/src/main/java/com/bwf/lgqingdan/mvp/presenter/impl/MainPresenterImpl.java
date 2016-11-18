package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.entity.ResponseDailyTips;
import com.bwf.lgqingdan.mvp.model.MainModel;
import com.bwf.lgqingdan.mvp.model.impl.MainModelImpl;
import com.bwf.lgqingdan.mvp.presenter.MainPresenter;
import com.bwf.lgqingdan.mvp.view.MainView;

import java.util.List;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class MainPresenterImpl implements MainPresenter, MainModel.Callback {
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl();
    }
    @Override
    public void loadMainDatas() {
        mainModel.loadDatas(this);
    }

    @Override
    public void loadDailyTips() {
        mainModel.loadDailyTips(this);
    }

    @Override
    public void loadMainDataSuccess(ResponseMainData mainData) {
        List<ResponseMainData.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> slides =
                mainData.getData().getSlides().getBody().getData().getSlides();
        mainView.showBatching(slides);
        mainView.showTabs(mainData.getData().getChannels().getBody().getData().getChannels());
    }

    @Override
    public void loadMainDataFailed(String failedMessage) {

    }

    @Override
    public void loadDailyTipsSuccess(ResponseDailyTips dailyTips) {
        mainView.showDailyTips(dailyTips);
    }

    @Override
    public void loadDailyTipsFailed(String failedMessage) {

    }
}
