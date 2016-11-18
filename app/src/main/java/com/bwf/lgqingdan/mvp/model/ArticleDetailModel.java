package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseArticleTitle;
import com.bwf.lgqingdan.entity.ResponseComments;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;

import java.util.List;

/**
 * Created by LG on 2016/10/28.
 * Tips:
 */

public interface ArticleDetailModel {

    void loadDatas(int articleId,Callback callback);
    void loadTitleData();
    void loadCommentsData();
    void loadRelatedArticles();
    void loadArticleDetail();

    public interface Callback{
        void loadTitleDataSuccess(ResponseArticleTitle articleTitle);
        void loadCommentsSuccess(List<ResponseComments.DataBean.CommentsBean> comments);
        void loadRelateArticlesSuccess(List<ResponseRelatedArticles.DataBean.ArticlesBean> relateArticles);
        void loadArticleSuccess(String url);
        void loadFailed();
    }
}
