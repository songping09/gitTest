package com.bwf.lgqingdan.mvp.presenter.impl;

import android.util.Log;

import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.entity.ResponseReputation;
import com.bwf.lgqingdan.mvp.model.MainListModel;
import com.bwf.lgqingdan.mvp.model.impl.MainListModelImpl;
import com.bwf.lgqingdan.mvp.presenter.MainListPresenter;
import com.bwf.lgqingdan.mvp.view.MainListView;
import com.bwf.lgqingdan.utils.UrlHandler;

import java.util.List;

/**
 * Created by LG on 2016/10/25.
 * Tips:
 */

public class MainListPresenterImpl implements MainListPresenter {
    private MainListModel model;
    private MainListView view;
    private int nextPage = 1;
    private String urlTag;

    public MainListPresenterImpl(MainListView view, String urlTag) {
        this.view = view;
        this.urlTag = urlTag;
        model = new MainListModelImpl();
    }
    @Override
    public void loadNextPageDatas() {
        view.showRecycleViewFooterLoading();
        String url = UrlHandler.handlUrl(urlTag,nextPage);
        Log.d("MainListPresenterImpl", "正在获取第" + nextPage + "页的数据");
        model.loadNextPageDatas(url, new MainListModel.Callback() {
            @Override
            public void loadCollectionsSuccess(List<ResponseMainListData.DataBean.CollectionsBean> collections) {
                view.showCollectionsToView(collections);
            }

            @Override
            public void loadNodesSuccess(List<ResponseMainListData.DataBean.NodesBean> nodes) {
                view.showNodesToView(nodes);
            }

            @Override
            public void loadArticlesSuccess(List<ResponseMainListData.DataBean.ArticlesBean> articles) {
                view.showArticlesToView(articles);
            }

            @Override
            public void loadFailed() {
                view.showRecycleViewFooterLoadFailed();
                nextPage--;
            }

            @Override
            public void noMoreData() {
                view.showRecycleViewFooterNoMoreData();
            }
        });
        nextPage++;
    }

    @Override
    public void loadReputations() {
        model.loadReputations(new MainListModel.ReputationsCallback() {
            @Override
            public void loadReputationsSuccess(List<ResponseReputation.DataBean.RankingsBean> reputations) {
                view.showReputations(reputations);
            }
        });
    }

    @Override
    public void refreshData() {
        nextPage = 1;
        loadNextPageDatas();
    }
}





