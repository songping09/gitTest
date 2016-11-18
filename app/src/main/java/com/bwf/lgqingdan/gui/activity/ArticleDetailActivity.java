package com.bwf.lgqingdan.gui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseArticleTitle;
import com.bwf.lgqingdan.entity.ResponseComments;
import com.bwf.lgqingdan.entity.ResponseRelatedArticles;
import com.bwf.lgqingdan.gui.adapter.RelatedArticlesAdapter;
import com.bwf.lgqingdan.gui.widget.QingdanWebviewClient;
import com.bwf.lgqingdan.mvp.presenter.ArticleDetailPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.ArticleDetailPresenterImpl;
import com.bwf.lgqingdan.mvp.view.ArticleDetailView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by LG on 2016/10/27.
 * Tips:文章详情界面
 */

public class ArticleDetailActivity extends ActivityBase implements ArticleDetailView, AdapterView.OnItemClickListener {
    @BindView(R.id.webview_activity_activle_detail)
    com.tencent.smtt.sdk.WebView webviewActivityActivleDetail;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.textView_article_detail_like_num)
    TextView textViewArticleDetailLikeNum;
    @BindView(R.id.linear_article_detail_like)
    LinearLayout linearArticleDetailLike;
    @BindView(R.id.textView_article_detail_comment_num)
    TextView textViewArticleDetailCommentNum;
    @BindView(R.id.linear_article_detail_review)
    LinearLayout linearArticleDetailReview;
    @BindView(R.id.linear_article_detail_share)
    LinearLayout linearArticleDetailShare;
    @BindView(R.id.button_thing_link)
    Button buttonThingLink;
    @BindView(R.id.root)
    RelativeLayout root;
    @BindView(R.id.title_bigimg_article_detail)
    SimpleDraweeView titleBigimgArticleDetail;
    @BindView(R.id.rela_special_tag)
    TextView relaSpecialTag;
    @BindView(R.id.textview_title_article_detail)
    TextView textviewTitleArticleDetail;
    @BindView(R.id.imageview_author_article_detail)
    SimpleDraweeView imageviewAuthorArticleDetail;
    @BindView(R.id.textview_author_article_detail)
    TextView textviewAuthorArticleDetail;
    @BindView(R.id.textview_tag_article_detail)
    TextView textviewTagArticleDetail;
    @BindView(R.id.textview_publish_time_article_detail)
    TextView textviewPublishTimeArticleDetail;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.rela_no_comments)
    RelativeLayout relaNoComments;
    @BindView(R.id.layout_comments)
    LinearLayout layoutComments;
    @BindView(R.id.gridView_related_articles)
    GridView gridViewRelatedArticles;
    @BindView(R.id.layout_container_subiew_related_articles)
    LinearLayout layoutContainerSubiewRelatedArticles;

    public static final String ARTICLE_ID = "articleId";
    private int articleId;
    private ArticleDetailPresenter presenter;

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        articleId = getIntent().getIntExtra(ARTICLE_ID, 0);
        Toast.makeText(this, "articleId:" + articleId, Toast.LENGTH_SHORT).show();
        initWebView();
        gridViewRelatedArticles.setOnItemClickListener(this);
        root.setPadding(0, getStatusHeight(), 0, 0);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas(articleId);
            }
        });
    }

    @Override
    protected void initDatas() {
        presenter = new ArticleDetailPresenterImpl(this);
//        presenter.loadMainDatas(articleId);

        new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                refreshLayout.autoRefresh();
            }
        }.sendEmptyMessageDelayed(0,350);

    }

    private void initWebView() {
        //WebViewClient就是帮助WebView处理各种通知、请求事件的
        webviewActivityActivleDetail.setWebViewClient(new QingdanWebviewClient() {
            @Override
            public void onArticleLinkClicked(int articleId) {
                Intent intent = new Intent(ArticleDetailActivity.this, ArticleDetailActivity.class);
                intent.putExtra(ArticleDetailActivity.ARTICLE_ID,articleId);
                startActivity(intent);
            }

            @Override
            public void onGeneralLinkClicked(String paramString) {
                Toast.makeText(ArticleDetailActivity.this, paramString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onThingLinkClicked(int thingId) {
                Toast.makeText(ArticleDetailActivity.this, "thingId:" + thingId, Toast.LENGTH_SHORT).show();
            }
        });


        //主要处理解析，渲染网页等浏览器做的事情
        //WebChromeClient辅助WebView处理Javascript的对话框，网站图标，网站title，加载进度等
        webviewActivityActivleDetail.setWebChromeClient(new com.tencent.smtt.sdk.WebChromeClient() {
            @Override
            public void onProgressChanged(com.tencent.smtt.sdk.WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

        });
        webviewActivityActivleDetail.addJavascriptInterface(new JavascriptInterface(this), "BWF");

        webviewActivityActivleDetail.getSettings().setJavaScriptEnabled(true);
    }
    private class JavascriptInterface{
        Context context;
        public JavascriptInterface(Context context) {
            super();
            this.context = context;
        }
        @android.webkit.JavascriptInterface
        public void clickImg(String src){
            Toast.makeText(context, src, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getContentViewResID() {
        return R.layout.activity_article_details;
    }


    @Override
    public void showArticleDetail(String url) {
        webviewActivityActivleDetail.loadUrl(url);
    }

    @Override
    public void showArticleTitle(ResponseArticleTitle title) {
        refreshLayout.finishRefresh();
        titleBigimgArticleDetail.setImageURI(title.getData().getFeaturedImageUrl());
        textviewTitleArticleDetail.setText(title.getData().getTitle());
        imageviewAuthorArticleDetail.setImageURI(title.getData().getAuthor().getAvatarUrl());
        textviewAuthorArticleDetail.setText(title.getData().getAuthor().getNickname());
        textviewTagArticleDetail.setText(title.getData().getAuthor().getTagline());
        textviewPublishTimeArticleDetail.setText(title.getData().getPublishedAtDiffForHumans());
        if (title.getData().getCategories() != null && title.getData().getCategories().size() != 0) {
            relaSpecialTag.setText(title.getData().getCategories().get(0).getName());
        }
    }

    @Override
    public void showComments(List<ResponseComments.DataBean.CommentsBean> comments) {
        LayoutInflater inflater = LayoutInflater.from(this);
        layoutComments.setVisibility(View.VISIBLE);
        layoutComments.removeAllViews();
        for (ResponseComments.DataBean.CommentsBean comment : comments) {
            View view = inflater.inflate(R.layout.list_item_comment, layoutComments, false);
            CommentItemViewHolder holder = new CommentItemViewHolder(view);
            holder.imageViewAuthorAvatar.setImageURI(comment.getUser().getAvatarUrl());//头像
            holder.textViewAuthorName.setText(comment.getUser().getNickname());//用户昵称
            holder.textViewCommentTimeTag.setText(comment.getCreatedAtDiffForHumans());//评论时间
            //评论内容
            if (comment.getReplyToUser() != null) {
                String replyToUserNickname = comment.getReplyToUser().getNickname();
                holder.textViewComments.setText("回复 " + replyToUserNickname + " ：" + comment.getBody());
            } else {
                holder.textViewComments.setText(comment.getBody());
            }
            //点赞数
            holder.textViewCommentLikeCount.setText(comment.getUpvoteCount() + "");
            layoutComments.addView(view);
        }
    }

    @Override
    public void showRelatedArticles(List<ResponseRelatedArticles.DataBean.ArticlesBean> relatedArticles) {
        if (relatedArticles == null || relatedArticles.size() == 0) {
            layoutContainerSubiewRelatedArticles.setVisibility(View.GONE);
        } else {
            layoutContainerSubiewRelatedArticles.setVisibility(View.VISIBLE);
            RelatedArticlesAdapter relatedArticlesAdapter = new RelatedArticlesAdapter(this);
            relatedArticlesAdapter.setDatas(relatedArticles);
            gridViewRelatedArticles.setAdapter(relatedArticlesAdapter);
        }
    }

    @Override
    public void showLookupGoods(boolean isShow) {
        buttonThingLink.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showLikeCount(int likeCount) {
        textViewArticleDetailLikeNum.setText(getString(R.string.article_lick_cont, likeCount));
    }

    @Override
    public void showCommentsCount(int commentsCount) {
        textViewArticleDetailCommentNum.setText(getString(R.string.article_comments_cont, commentsCount));
    }

    @Override
    public void showNoComments() {
        relaNoComments.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadFailed() {
        refreshLayout.finishRefresh();
    }

    @OnClick({R.id.back, R.id.linear_article_detail_like, R.id.linear_article_detail_review, R.id.linear_article_detail_share, R.id.imageview_author_article_detail,R.id.button_thing_link})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.linear_article_detail_like:
                break;
            case R.id.linear_article_detail_review:
                break;
            case R.id.linear_article_detail_share:
                break;
            case R.id.imageview_author_article_detail:
                break;
            case R.id.button_thing_link:
                Intent intent = new Intent(this,RelatedThingActivity.class);
                intent.putExtra(RelatedThingActivity.ARTICLE_ID,articleId);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ArticleDetailActivity.class);
        ResponseRelatedArticles.DataBean.ArticlesBean article =
                (ResponseRelatedArticles.DataBean.ArticlesBean) parent.getAdapter().getItem(position);
        intent.putExtra(ArticleDetailActivity.ARTICLE_ID, article.getId());
        startActivity(intent);
    }

    static class CommentItemViewHolder {
        @BindView(R.id.imageView_author_avatar)
        SimpleDraweeView imageViewAuthorAvatar;
        @BindView(R.id.textView_author_name)
        TextView textViewAuthorName;
        @BindView(R.id.textView_comment_time_tag)
        TextView textViewCommentTimeTag;
        @BindView(R.id.textView_comment_like_count)
        TextView textViewCommentLikeCount;
        @BindView(R.id.imageView_comment_like)
        ImageView imageViewCommentLike;
        @BindView(R.id.textView_comments)
        TextView textViewComments;

        CommentItemViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
