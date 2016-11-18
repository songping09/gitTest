package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseBriefReviews;
import com.bwf.lgqingdan.entity.ResponseIncludeArticles;
import com.bwf.lgqingdan.mvp.model.ThingDetailModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.UrlHandler;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */

public class ThingDetailModelImpl implements ThingDetailModel{
    private Callback callback;
    private int thingId;
    @Override
    public void loadData(int thingId,Callback callback) {
        this.callback = callback;
        this.thingId = thingId;
        loadReviews();
        loadArticles();
    }

    @Override
    public void loadReviews() {
        Request.Builder builder = new Request.Builder()
                .url(UrlHandler.handlUrl(Apis.API_BRIEF_REVIEWS_THING_DETAIL,thingId))
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseBriefReviews responseBriefReviews = JSON.parseObject(response,ResponseBriefReviews.class);
                List<ResponseBriefReviews.DataBean.ReviewsBean> reviews = responseBriefReviews.getData().getReviews();
                if(reviews == null || reviews.size() == 0){
                    callback.noReviews();
                    return;
                }
                callback.loadReviewsSuccess(reviews);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void loadArticles() {
        Request.Builder builder = new Request.Builder()
                .url(UrlHandler.handlUrl(Apis.API_ACTIVLES_THING_DETAIL,thingId))
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseIncludeArticles responseBriefReviews = JSON.parseObject(response,ResponseIncludeArticles.class);
                List<ResponseIncludeArticles.DataBean.ArticlesBean> articles = responseBriefReviews.getData().getArticles();
                if(articles == null || articles.size() == 0){
                    callback.noArticles();
                    return;
                }
                callback.loadArticlesSuccess(articles);
            }

            @Override
            public void onError() {

            }
        });
    }
}
