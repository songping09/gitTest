package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseCollectionDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public interface CollectionDetailView {

    void showLoadFailedView();

    void showListView(List<ResponseCollectionDetail.Data.CollectionsBean.BodyBean.DataBean.ArticlesBean> articles);

    void showHeaderView(ResponseCollectionDetail.Data.CollectionBean.BodyBean.DataBean data);
}
