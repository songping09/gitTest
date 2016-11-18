package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseArticleTitle;
import com.bwf.lgqingdan.entity.ResponseComments;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;
import com.bwf.lgqingdan.mvp.model.ArticleDetailModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.UrlHandler;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by LG on 2016/10/28.
 * Tips:文章详情
 */

public class ArticleDetailModelImpl implements ArticleDetailModel{
    private int articleId;
    private Callback callback;
    @Override
    public void loadDatas(int articleId,Callback callback) {
        this.articleId = articleId;
        this.callback = callback;
        loadArticleDetail();
        loadTitleData();
        loadCommentsData();
        loadRelatedArticles();
    }

    @Override
    public void loadTitleData() {
        Request.Builder builder = new Request.Builder()
                .url(UrlHandler.handlUrl(Apis.API_ARTICLE_TITLE,articleId))
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseArticleTitle responseArticleTitle = JSON.parseObject(response, ResponseArticleTitle.class);
                callback.loadTitleDataSuccess(responseArticleTitle);
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });

    }

    @Override
    public void loadCommentsData() {
        Request.Builder builder = new Request.Builder()
                .url(UrlHandler.handlUrl(Apis.API_ARTICLE_COMMENTS,articleId))
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseComments responseComments = JSON.parseObject(response, ResponseComments.class);
                callback.loadCommentsSuccess(responseComments.getData().getComments());
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });
    }

    @Override
    public void loadRelatedArticles() {
        Request.Builder builder = new Request.Builder()
                .url(UrlHandler.handlUrl(Apis.API_RELATED_ARTICLES,articleId))
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseRelatedArticles responseRelatedArticles = JSON.parseObject(response, ResponseRelatedArticles.class);
                callback.loadRelateArticlesSuccess(responseRelatedArticles.getData().getArticles());
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });
    }

    @Override
    public void loadArticleDetail() {
        callback.loadArticleSuccess(UrlHandler.handlUrl(Apis.API_ARTICLE_DETAIL,articleId));
    }
}
