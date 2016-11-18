package com.bwf.lgqingdan.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseReputationsList;
import com.bwf.lgqingdan.gui.adapter.ReputationsListAdapter;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.bwf.lgqingdan.mvp.presenter.ReputationsListPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.ReputationsListPresenterImpl;
import com.bwf.lgqingdan.mvp.view.ReputationsListView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/11/13.
 * tips:口碑清单界面
 */

public class ReputationsListActivity extends ActivityBase implements ReputationsListView, BaseRecycleViewAdapter.OnItemClickListener<ResponseReputationsList.DataBean.RankingsBean> {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.root)
    LinearLayout root;

    ReputationsListAdapter reputationsListAdapter;
    LinearLayoutManager linearLayoutManager;
    ReputationsListPresenter presenter;
    boolean isLoading;
    boolean isNoMoreData;
    @Override
    public int getContentViewResID() {
        return R.layout.reputations_list;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        root.setPadding(0,getStatusHeight(),0,0);
        title.setText(getString(R.string.reputations_list));
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isNoMoreData) {
                    return;
                }
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = linearLayoutManager.getItemCount();
                //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载，各位自由选择
                // dy>0 表示向下滑动
                Log.d("MainListFragment", "lastVisibleItem:" + lastVisibleItem + ",totalItemCount:" + totalItemCount + ",dy:" + dy);
                if (lastVisibleItem == totalItemCount - 1) {
                    if (isLoading) {
                        Log.d(TAG, "ignore manually update!");
                    } else {
                        isLoading = true;
                        loadNextPageData();
                    }
                }
            }
        });
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                refreshData();
            }
        });
    }

    @Override
    protected void initDatas() {
        reputationsListAdapter = new ReputationsListAdapter(this);
        reputationsListAdapter.setOnItemClickListener(this);
        recycleView.setAdapter(reputationsListAdapter);
        presenter = new ReputationsListPresenterImpl(this);
        loadNextPageData();
    }

    private void loadNextPageData(){
        isLoading = true;
        presenter.loadNextPageData();
    }
    private void refreshData(){
        isLoading = true;
        presenter.refreshData();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.back)
    public void onClick() {
        finish();
    }

    @Override
    public void showReputations(List<ResponseReputationsList.DataBean.RankingsBean> rankings) {
        isLoading = false;
        isNoMoreData = false;
        reputationsListAdapter.addDatas(rankings);
        refreshLayout.finishRefresh();
    }

    @Override
    public void showNoMoreData() {
        isNoMoreData = true;
    }

    @Override
    public void showLoadFailed(String failedMsg) {
        isLoading = false;
        refreshLayout.finishRefresh();
    }

    @Override
    public void onItemClick(int position, View view, ResponseReputationsList.DataBean.RankingsBean data) {
        Intent intent = new Intent(this, ReputationThingActivity.class);
        intent.putExtra(ReputationThingActivity.RANKING_ID, data.getId());
        intent.putExtra(ReputationThingActivity.RANKING_TITLE, data.getTitle());
        startActivity(intent);
    }
}
