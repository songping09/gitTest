package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseCollectionDetail;
import com.bwf.lgqingdan.mvp.model.CollectionDetailModel;
import com.bwf.lgqingdan.mvp.model.impl.CollectionDetailModelImpl;
import com.bwf.lgqingdan.mvp.presenter.CollectionDetailPresenter;
import com.bwf.lgqingdan.mvp.view.CollectionDetailView;

/**
 * Created by Administrator on 2016/11/6.
 */

public class CollectionDetailPresenterImpl implements CollectionDetailPresenter, CollectionDetailModel.Callback {
    private CollectionDetailView view;
    private CollectionDetailModel model;

    public CollectionDetailPresenterImpl(CollectionDetailView view) {
        this.view = view;
        this.model = new CollectionDetailModelImpl();
    }

    @Override
    public void loadData(int collectionId) {
        model.loadData(collectionId,this);
    }

    @Override
    public void loadSuccess(ResponseCollectionDetail responseCollectionDetail) {
        view.showHeaderView(responseCollectionDetail.getData().getCollection().getBody().getData());
        view.showListView(responseCollectionDetail.getData().getCollections().getBody().getData().getArticles());
    }

    @Override
    public void loadFailed() {
        view.showLoadFailedView();
    }
}
