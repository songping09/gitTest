package com.bwf.lgqingdan.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.lgqingdan.QingdanApplication;
import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.gui.activity.ThingDetailActivity;
import com.bwf.lgqingdan.gui.adapter.RankingThingAdapter;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.bwf.lgqingdan.mvp.presenter.ReputationThingPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.ReputationThingPresenterImpl;
import com.bwf.lgqingdan.mvp.view.ReputationThingView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/11/7.
 */

public class RankingThingFragment extends FragmentBase implements ReputationThingView, BaseMainRecycleViewAdapter.OnRetryClickListener, BaseRecycleViewAdapter.OnItemClickListener<ThingsBean> {
    @BindView(R.id.recycleView_ranking_thing)
    RecyclerView recycleViewRankingThing;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    private int rankingId;
    private int sortTag;
    private ReputationThingPresenter presenter;
    private boolean isLoadingMore;
    private boolean isNoMoreData;
    private RankingThingAdapter adapter;
    private LinearLayoutManager layoutManager;
    public static RankingThingFragment newInstance(int rankingId, int sortTag,String searchKey) {
        RankingThingFragment fragment = new RankingThingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("rankingId", rankingId);
        bundle.putInt("sortTag", sortTag);
        bundle.putString("searchKey",searchKey);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_ranking_thing;
    }

    private String searchKey = "";


    @Override
    protected void initViews() {
        adapter = new RankingThingAdapter(getActivity());
        adapter.setOnRetryClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleViewRankingThing.setLayoutManager(layoutManager);
        recycleViewRankingThing.setAdapter(adapter);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                isLoadingMore = true;
                presenter.refreshData(searchKey);
            }
        });
        recycleViewRankingThing.addOnScrollListener(recyclerViewScrollListener);
        adapter.setOnItemClickListener(this);

    }

    private RecyclerView.OnScrollListener recyclerViewScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNoMoreData) {
                return;
            }
            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            int totalItemCount = layoutManager.getItemCount();
            //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载，各位自由选择
            // dy>0 表示向下滑动
            Log.d("MainListFragment", "lastVisibleItem:" + lastVisibleItem + ",totalItemCount:" + totalItemCount + ",dy:" + dy);
            if (lastVisibleItem == totalItemCount - 1) {
                if (isLoadingMore) {
                    Log.d(TAG, "ignore manually update!");
                } else {
                    isLoadingMore = true;
                    loadNextData();//这里多线程也要手动控制isLoadingMore
                }
            }
        }
    };
    private void loadNextData() {
        isLoadingMore = true;
        presenter.loadNextData(searchKey);
    }
    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        rankingId = bundle.getInt("rankingId");
        sortTag = bundle.getInt("sortTag");
        searchKey = bundle.getString("searchKey","");
        Log.d("RankingThingFragment", "rankingId:" + rankingId);
        Log.d("RankingThingFragment", "sortTag:" + sortTag);
        presenter = new ReputationThingPresenterImpl(this, sortTag, rankingId);
        loadNextData();
    }

    @Override
    public void showThingsToView(int page,List<ThingsBean> things) {
        if(page == 1){
            adapter.setDatas(things);
            isNoMoreData = false;
        }else{
            adapter.addDatas(things);
        }
        refreshLayout.finishRefresh();
        isLoadingMore = false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFooterLoading() {
        adapter.updateFooterState(RankingThingAdapter.STATE_LOADING);
    }

    @Override
    public void showFooterLoadFailed() {
        refreshLayout.finishRefresh();
        isLoadingMore = false;
        adapter.updateFooterState(RankingThingAdapter.STATE_LOAD_FAILED);
    }

    @Override
    public void showFooterNoMoreData() {
        isNoMoreData = true;
        adapter.updateFooterState(RankingThingAdapter.STATE_NO_MORE_DATA);
    }

    @Override
    public void showFooterNoSearchData() {
        isNoMoreData = true;
        adapter.updateFooterState(RankingThingAdapter.STATE_NO_SEARCH_DATA);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onRetryClick() {
        loadNextData();
    }

    /**
     * 搜索
     * @param
     */
    public void showSearch(String searchKey) {
        this.searchKey = searchKey;
        adapter.clearDatas();
        presenter.refreshData(searchKey);

    }

    @Override
    public void onItemClick(int position,View view, ThingsBean data) {
        Intent intent = new Intent(getActivity(), ThingDetailActivity.class);
        intent.putExtra(ThingDetailActivity.THING_ID,data.getId());
        QingdanApplication.instance.thingsBean = data;
        startActivity(intent);
    }
}
