package com.bwf.lgqingdan.test;

import android.util.Log;

import com.bwf.lgqingdan.entity.ResponseArticleTitle;
import com.bwf.lgqingdan.entity.ResponseComments;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;
import com.bwf.lgqingdan.mvp.presenter.ArticleDetailPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.ArticleDetailPresenterImpl;
import com.bwf.lgqingdan.mvp.view.ArticleDetailView;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class ArticleDetailPresenterImplTest implements ArticleDetailView {
    private ArticleDetailPresenter presenter;
    @Before
    public void setUp() throws Exception {
        presenter = new ArticleDetailPresenterImpl(this);
    }

    @Test
    public void loadDatas() throws Exception {
        presenter.loadDatas(806);
    }

    @Override
    public void showArticleDetail(String url) {
        Log.d("ArticleDetailPresenterI", "url:"+url);
    }

    @Override
    public void showArticleTitle(ResponseArticleTitle title) {

        Log.d("ArticleDetailPresenterI", "title:"+title.getData().getTitle());
    }

    @Override
    public void showComments(List<ResponseComments.DataBean.CommentsBean> comments) {
        Log.d("ArticleDetailPresenterI", "comments.size():" + comments.size());
    }

    @Override
    public void showRelatedArticles(List<ResponseRelatedArticles.DataBean.ArticlesBean> relatedArticles) {
        Log.d("ArticleDetailPresenterI", "relatedArticles.size():" + relatedArticles.size());
    }

    @Override
    public void showLookupGoods(boolean isShow) {
        Log.d("ArticleDetailPresenterI", "isShow:" + isShow);
    }

    @Override
    public void showLikeCount(int likeCount) {
        Log.d("ArticleDetailPresenterI", "likeCount:" + likeCount);
    }

    @Override
    public void showCommentsCount(int commentsCount) {
        Log.d("ArticleDetailPresenterI", "commentsCount:" + commentsCount);
    }

    @Override
    public void showNoComments() {

    }

    @Override
    public void showLoadFailed() {

    }
}