package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseBriefReviews;
import com.bwf.lgqingdan.entity.ResponseIncludeArticles;
import com.bwf.lgqingdan.mvp.model.ThingDetailModel;
import com.bwf.lgqingdan.mvp.model.impl.ThingDetailModelImpl;
import com.bwf.lgqingdan.mvp.presenter.ThingDetailPresenter;
import com.bwf.lgqingdan.mvp.view.ThingDetailView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public class ThingDetailPresenterImpl implements ThingDetailPresenter, ThingDetailModel.Callback {
    private ThingDetailModel model;
    private ThingDetailView view;

    public ThingDetailPresenterImpl(ThingDetailView view) {
        this.view = view;
        this.model = new ThingDetailModelImpl();
    }

    @Override
    public void loadData(int thingId) {
        model.loadData(thingId,this);
    }

    @Override
    public void loadReviewsSuccess(List<ResponseBriefReviews.DataBean.ReviewsBean> brifeReviews) {
        view.showReviews(brifeReviews);
    }
    @Override
    public void noReviews() {
        view.showNoReviews();
    }

    @Override
    public void loadArticlesSuccess(List<ResponseIncludeArticles.DataBean.ArticlesBean> articles) {
        view.showArticles(articles);
    }


    @Override
    public void noArticles() {
        view.showNoArticles();
    }
}
