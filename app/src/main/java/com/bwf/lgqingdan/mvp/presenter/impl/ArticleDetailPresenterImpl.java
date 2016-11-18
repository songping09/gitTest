package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseArticleTitle;
import com.bwf.lgqingdan.entity.ResponseComments;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;
import com.bwf.lgqingdan.mvp.model.ArticleDetailModel;
import com.bwf.lgqingdan.mvp.model.impl.ArticleDetailModelImpl;
import com.bwf.lgqingdan.mvp.presenter.ArticleDetailPresenter;
import com.bwf.lgqingdan.mvp.view.ArticleDetailView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public class ArticleDetailPresenterImpl implements ArticleDetailPresenter {
    private ArticleDetailModel model;
    private ArticleDetailView view;

    public ArticleDetailPresenterImpl(ArticleDetailView view) {
        this.view = view;
        this.model = new ArticleDetailModelImpl();
    }

    @Override
    public void loadDatas(int articleId) {
        model.loadDatas(articleId, new ArticleDetailModel.Callback() {
            @Override
            public void loadTitleDataSuccess(ResponseArticleTitle articleTitle) {
                view.showArticleTitle(articleTitle);
                view.showLikeCount(articleTitle.getData().getLikeCount());
                view.showCommentsCount(articleTitle.getData().getCommentCount());
                view.showLookupGoods(articleTitle.getData().getThingCount() > 0);
            }

            @Override
            public void loadCommentsSuccess(List<ResponseComments.DataBean.CommentsBean> comments) {
                if(comments == null || comments.size() == 0){
                    view.showNoComments();
                }else{
                    view.showComments(comments);
                }
            }

            @Override
            public void loadRelateArticlesSuccess(List<ResponseRelatedArticles.DataBean.ArticlesBean> relateArticles) {
                view.showRelatedArticles(relateArticles);
            }

            @Override
            public void loadArticleSuccess(String url) {
                view.showArticleDetail(url);
            }

            @Override
            public void loadFailed() {
                view.showLoadFailed();
            }
        });
    }
}
