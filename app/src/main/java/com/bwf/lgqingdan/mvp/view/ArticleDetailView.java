package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseArticleTitle;
import com.bwf.lgqingdan.entity.ResponseComments;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public interface ArticleDetailView {
    void showArticleDetail(String url);
    void showArticleTitle(ResponseArticleTitle title);
    void showComments(List<ResponseComments.DataBean.CommentsBean> comments);
    void showRelatedArticles(List<ResponseRelatedArticles.DataBean.ArticlesBean> relatedArticles);
    void showLookupGoods(boolean isShow);
    void showLikeCount(int likeCount);
    void showCommentsCount(int commentsCount);
    void showNoComments();

    void showLoadFailed();
}
