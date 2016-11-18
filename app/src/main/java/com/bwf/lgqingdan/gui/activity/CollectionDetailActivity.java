package com.bwf.lgqingdan.gui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseCollectionDetail;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;
import com.bwf.lgqingdan.gui.adapter.CollectionDetailRecycleViewAdapter;
import com.bwf.lgqingdan.mvp.presenter.CollectionDetailPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.CollectionDetailPresenterImpl;
import com.bwf.lgqingdan.mvp.view.CollectionDetailView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/5.
 */

public class CollectionDetailActivity extends ActivityBase implements CollectionDetailView, BaseMainRecycleViewAdapter.OnItemClickListener<ResponseCollectionDetail.Data.CollectionsBean.BodyBean.DataBean.ArticlesBean> {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.recycleView_collection_detail)
    RecyclerView recycleViewCollectionDetail;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    private CollectionDetailPresenter presenter;
    private CollectionDetailRecycleViewAdapter recycleViewAdapter;
    private int collectionId;
    public static final String COLLECTION_ID = "collectionId";

    @Override
    public int getContentViewResID() {
        return R.layout.activity_collection_details;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        root.setPadding(0, getStatusHeight(), 0, 0);
        title.setText(getString(R.string.collection_detail));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleViewCollectionDetail.setLayoutManager(layoutManager);
        recycleViewAdapter = new CollectionDetailRecycleViewAdapter(this);
        recycleViewCollectionDetail.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setOnItemClickListener(this);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadData();
            }
        });
    }

    private void loadData(){
        presenter.loadData(collectionId);
    }
    @Override
    protected void initDatas() {
        presenter = new CollectionDetailPresenterImpl(this);
        collectionId = getIntent().getIntExtra(COLLECTION_ID, 0);
        new Handler(){
            @Override
            public void handleMessage(Message msg) {
                refreshLayout.autoRefresh();
            }
        }.sendEmptyMessageDelayed(0,350);
    }

    @Override
    public void showLoadFailedView() {
        refreshLayout.finishRefresh();
    }

    @Override
    public void showListView(List<ResponseCollectionDetail.Data.CollectionsBean.BodyBean.DataBean.ArticlesBean> articles) {
        recycleViewAdapter.setDatas(articles);
    }

    @Override
    public void showHeaderView(ResponseCollectionDetail.Data.CollectionBean.BodyBean.DataBean data) {
        recycleViewAdapter.setHeaderData(data);
        refreshLayout.finishRefresh();
    }


    @OnClick({R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(int position,View view, ResponseCollectionDetail.Data.CollectionsBean.BodyBean.DataBean.ArticlesBean data) {
        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra(ArticleDetailActivity.ARTICLE_ID, data.getId());
        startActivity(intent);
    }

}
