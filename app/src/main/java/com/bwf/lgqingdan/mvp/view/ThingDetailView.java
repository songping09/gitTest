package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseBriefReviews;
import com.bwf.lgqingdan.entity.ResponseIncludeArticles;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public interface ThingDetailView {
    void showReviews(List<ResponseBriefReviews.DataBean.ReviewsBean> brifeReviews);
    void showNoReviews();
    void showArticles(List<ResponseIncludeArticles.DataBean.ArticlesBean> articles);
    void showNoArticles();
}
