package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseReputationsList;
import com.bwf.lgqingdan.mvp.model.ReputationsListModel;
import com.bwf.lgqingdan.mvp.model.impl.ReputationsListModelImpl;
import com.bwf.lgqingdan.mvp.presenter.ReputationsListPresenter;
import com.bwf.lgqingdan.mvp.view.ReputationsListView;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.UrlHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public class ReputationsListPresenterImpl implements ReputationsListPresenter, ReputationsListModel.Callback {
    private ReputationsListModel model;
    private ReputationsListView view;
    private int nextPage;
    public ReputationsListPresenterImpl(ReputationsListView view) {
        this.view = view;
        model = new ReputationsListModelImpl();
    }

    @Override
    public void loadNextPageData() {
        String url = UrlHandler.handlUrl(Apis.API_REPUTATIONS_LIST,nextPage);
        model.loadData(url,this);
    }

    @Override
    public void refreshData() {
        nextPage = 1;
        loadNextPageData();
    }

    @Override
    public void loadSuccess(List<ResponseReputationsList.DataBean.RankingsBean> rankings) {
        view.showReputations(rankings);
        nextPage++;
    }

    @Override
    public void noMoreDatas() {
        view.showNoMoreData();
    }

    @Override
    public void loadFailed(String failedMsg) {
        view.showLoadFailed(failedMsg);
    }
}
