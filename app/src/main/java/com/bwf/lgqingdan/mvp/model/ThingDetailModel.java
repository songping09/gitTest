package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseBriefReviews;
import com.bwf.lgqingdan.entity.ResponseIncludeArticles;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public interface ThingDetailModel {
    void loadData(int thingId,Callback callback);
    void loadReviews();
    void loadArticles();
    public interface Callback{
        void loadReviewsSuccess(List<ResponseBriefReviews.DataBean.ReviewsBean> brifeReviews);
        void noReviews();
        void loadArticlesSuccess(List<ResponseIncludeArticles.DataBean.ArticlesBean> articles);
        void noArticles();
    }
}
