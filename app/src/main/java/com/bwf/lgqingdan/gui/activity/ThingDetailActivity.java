package com.bwf.lgqingdan.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bwf.lgqingdan.QingdanApplication;
import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseBriefReviews;
import com.bwf.lgqingdan.entity.ResponseIncludeArticles;
import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.gui.adapter.IncludeArticlesAdapter;
import com.bwf.lgqingdan.gui.adapter.ThingDetailImagePagerAdapter;
import com.bwf.lgqingdan.gui.adapter.ThingDetailReviewListAdapter;
import com.bwf.lgqingdan.gui.view.NestingGridView;
import com.bwf.lgqingdan.gui.widget.PagerDotIndicator;
import com.bwf.lgqingdan.mvp.presenter.ThingDetailPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.ThingDetailPresenterImpl;
import com.bwf.lgqingdan.mvp.view.ThingDetailView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/10.
 */

public class ThingDetailActivity extends ActivityBase implements ThingDetailView, AdapterView.OnItemClickListener {
    @BindView(R.id.root)
    View root;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.listView_thing_details)
    ListView listViewThingDetails;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;


    private ThingDetailReviewListAdapter reviewListAdapter;
    public static final String THING_ID = "thingId";
    private int thingId;
    private ThingDetailPresenter presenter;
    private IncludeArticlesAdapter articlesAdapter;
    private ThingsBean thingsBean;
    @Override
    public int getContentViewResID() {
        return R.layout.activity_thing_details;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText(getString(R.string.thing_detail));
        root.setPadding(0, getStatusHeight(), 0, 0);


        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadData(thingId);
            }
        });
    }


    private HeaderViewHolder headerViewHolder;
    private FooterViewHolder footerViewHolder;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //将ViewPage的高度设置成跟宽度一样
        if (hasFocus && headerViewHolder.viewPagerThingDetailsImage.getWidth() !=
                headerViewHolder.viewPagerThingDetailsImage.getHeight()) {
            ViewGroup.LayoutParams params = headerViewHolder.viewPagerThingDetailsImage.getLayoutParams();
            params.height = headerViewHolder.viewPagerThingDetailsImage.getWidth();
            headerViewHolder.viewPagerThingDetailsImage.setLayoutParams(params);
        }
    }
    /**
     * 返回脚部师视图（xml中默认设置了隐藏，获取到数据之后才显示并绑定数据）
     *
     * @return
     */
    private View getFooter() {
        View footerView = LayoutInflater.from(this).inflate(R.layout.subview_thing_details_footer, listViewThingDetails, false);
        footerViewHolder = new FooterViewHolder(footerView);
        articlesAdapter = new IncludeArticlesAdapter(this);
        footerViewHolder.gridViewThindDetailFooter.setAdapter(articlesAdapter);
        footerViewHolder.gridViewThindDetailFooter.setOnItemClickListener(this);
        return footerView;
    }

    /**
     * 返回头部师视图并初始化控件数据
     *
     * @return
     */
    private View getHeader() {
        View headerView = LayoutInflater.from(this).inflate(R.layout.subview_thing_details_header, listViewThingDetails, false);
        headerViewHolder = new HeaderViewHolder(headerView);
        initHeaderData(headerViewHolder);
        return headerView;
    }

    /**
     * 初始化控件数据
     *
     * @param headerViewHolder
     */
    private void initHeaderData(HeaderViewHolder headerViewHolder) {
        headerViewHolder.textViewThingBrand.setText(thingsBean.getFullName().replace(thingsBean.getName(), ""));//商品品牌
        headerViewHolder.textViewThingTitle.setText(thingsBean.getName());//商品名称
        //商品图片
        ThingDetailImagePagerAdapter imagePagerAdapter = new ThingDetailImagePagerAdapter(this, thingsBean.getImageUrls());
        headerViewHolder.viewPagerThingDetailsImage.setAdapter(imagePagerAdapter);
        PagerDotIndicator dotIndicator = new PagerDotIndicator(this, headerViewHolder.linearLayoutPagerIndicatorThingImage, headerViewHolder.viewPagerThingDetailsImage);
        dotIndicator.setNumberDots(thingsBean.getImageUrls().size());
        dotIndicator.setCurrentDot(0);
        //商品的评分
        if (thingsBean.getRatingScore() != 0) {
            headerViewHolder.ratingbarNoScore.setVisibility(View.GONE);
            headerViewHolder.tvRatingbarNoScore.setVisibility(View.GONE);
            headerViewHolder.ratingbar.setVisibility(View.VISIBLE);
            headerViewHolder.tvRatingbarScore.setVisibility(View.VISIBLE);
            headerViewHolder.ratingbar.setRating(thingsBean.getRatingScore());
            headerViewHolder.tvRatingbarScore.setText(getString(R.string.score_and_review2, thingsBean.getRatingScore() + "", thingsBean.getReviewCount()));
        }
        //商品描述的显示和隐藏
        if (!thingsBean.isHasDescription()) {
            headerViewHolder.thingDescribeLayout.setVisibility(View.GONE);
        }
        //购买渠道价格
        headerViewHolder.textViewPrice.setText(getString(R.string.thing_price, thingsBean.getPrice()));
        //喜欢的个数
        headerViewHolder.textViewThingDetailLikeNum.setText(getString(R.string.thing_detail_like_num, thingsBean.getLikeCount()));
        //拥有的个数
        headerViewHolder.textViewThingDetailHaving.setText(getString(R.string.thing_detail_having_num, thingsBean.getHavingCount()));

        //全部点评个数
        headerViewHolder.textViewAllReviews.setText(getString(R.string.all_reviews_count, thingsBean.getHasBodyReviewCount()));
    }

    @Override
    protected void initDatas() {
        thingId = getIntent().getIntExtra(THING_ID, 0);
        thingsBean = QingdanApplication.thingsBean;

        reviewListAdapter = new ThingDetailReviewListAdapter(this);
        listViewThingDetails.addHeaderView(getHeader());
        listViewThingDetails.addFooterView(getFooter());
        listViewThingDetails.setAdapter(reviewListAdapter);

        presenter = new ThingDetailPresenterImpl(this);
        presenter.loadData(thingId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public void showReviews(List<ResponseBriefReviews.DataBean.ReviewsBean> brifeReviews) {
        reviewListAdapter.setDatas(brifeReviews);
        refreshLayout.finishRefresh();
    }

    @Override
    public void showNoReviews() {
        refreshLayout.finishRefresh();
    }

    @Override
    public void showArticles(List<ResponseIncludeArticles.DataBean.ArticlesBean> articles) {
        footerViewHolder.rootThindDetailFooter.setVisibility(View.VISIBLE);
        articlesAdapter.setDatas(articles);
    }

    @Override
    public void showNoArticles() {
        footerViewHolder.rootThindDetailFooter.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent == footerViewHolder.gridViewThindDetailFooter){
            Intent intent = new Intent(this, ArticleDetailActivity.class);
            ResponseIncludeArticles.DataBean.ArticlesBean article =
                    (ResponseIncludeArticles.DataBean.ArticlesBean) parent.getAdapter().getItem(position);
            intent.putExtra(ArticleDetailActivity.ARTICLE_ID, article.getId());
            startActivity(intent);
        }
    }

    class HeaderViewHolder implements View.OnClickListener {
        @BindView(R.id.viewPager_thing_details_image)
        ViewPager viewPagerThingDetailsImage;
        @BindView(R.id.linearLayout_pager_indicator_thing_image)
        LinearLayout linearLayoutPagerIndicatorThingImage;
        @BindView(R.id.textView_thing_brand)
        TextView textViewThingBrand;
        @BindView(R.id.textView_thing_title)
        TextView textViewThingTitle;
        @BindView(R.id.ratingbar)
        RatingBar ratingbar;
        @BindView(R.id.tv_ratingbar_score)
        TextView tvRatingbarScore;
        @BindView(R.id.ratingbar_no_score)
        RatingBar ratingbarNoScore;
        @BindView(R.id.tv_ratingbar_no_score)
        TextView tvRatingbarNoScore;
        @BindView(R.id.rela_temp)
        RelativeLayout relaTemp;
        @BindView(R.id.thingDescribeLayout)
        RelativeLayout thingDescribeLayout;
        @BindView(R.id.textView_price)
        TextView textViewPrice;
        @BindView(R.id.buyChannelLayout)
        RelativeLayout buyChannelLayout;
        @BindView(R.id.toggleButton_like)
        ToggleButton toggleButtonLike;
        @BindView(R.id.textView_thing_detail_like_num)
        TextView textViewThingDetailLikeNum;
        @BindView(R.id.linear_thing_detail_like)
        LinearLayout linearThingDetailLike;
        @BindView(R.id.toggleButton_having)
        ToggleButton toggleButtonHaving;
        @BindView(R.id.textView_thing_detail_having)
        TextView textViewThingDetailHaving;
        @BindView(R.id.linear_thing_detail_having)
        LinearLayout linearThingDetailHaving;
        @BindView(R.id.textView_all_reviews)
        TextView textViewAllReviews;
        @BindView(R.id.layout_user_reviews)
        RelativeLayout layoutUserReviews;

        HeaderViewHolder(View view) {
            ButterKnife.bind(this, view);
            thingDescribeLayout.setOnClickListener(this);
            buyChannelLayout.setOnClickListener(this);
            linearThingDetailLike.setOnClickListener(this);
            linearThingDetailHaving.setOnClickListener(this);
            layoutUserReviews.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO
            if (v == thingDescribeLayout) {
                Intent intent = new Intent(ThingDetailActivity.this,ThingDescribeActivity.class);
//                intent.putExtra(ThingDescribeActivity.HTML_STRING,thingsBean.getDescription());
                intent.putExtra(ThingDescribeActivity.HTML_URL,thingsBean.getLinks().getHtml());
                startActivity(intent);
            } else if (v == buyChannelLayout) {
                Intent intent = new Intent(ThingDetailActivity.this,BuyLinksActivity.class);
                intent.putExtra(BuyLinksActivity.THING_ID,thingsBean.getId());
                startActivity(intent);
            } else if (v == linearThingDetailLike) {
                Toast.makeText(ThingDetailActivity.this, "喜欢", Toast.LENGTH_SHORT).show();
            } else if (v == linearThingDetailHaving) {
                Toast.makeText(ThingDetailActivity.this, "拥有", Toast.LENGTH_SHORT).show();
            } else if (v == layoutUserReviews) {
                Toast.makeText(ThingDetailActivity.this, "全部点评", Toast.LENGTH_SHORT).show();
            }
        }
    }

     class FooterViewHolder {
        @BindView(R.id.gridView_thind_detail_footer)
        NestingGridView gridViewThindDetailFooter;
        @BindView(R.id.root_thind_detail_footer)
        RelativeLayout rootThindDetailFooter;

         FooterViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
