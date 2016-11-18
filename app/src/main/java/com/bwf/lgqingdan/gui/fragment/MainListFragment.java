package com.bwf.lgqingdan.gui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.entity.ResponseReputation;
import com.bwf.lgqingdan.gui.activity.ArticleDetailActivity;
import com.bwf.lgqingdan.gui.activity.CollectionDetailActivity;
import com.bwf.lgqingdan.gui.adapter.base.BaseMainRecycleViewAdapter;
import com.bwf.lgqingdan.gui.adapter.MainArticlesRecycleViewAdapter;
import com.bwf.lgqingdan.gui.adapter.MainCollectionsRecycleViewAdapter;
import com.bwf.lgqingdan.gui.adapter.MainNodesRecycleViewAdapter;
import com.bwf.lgqingdan.gui.widget.FloatButtonOnRecycleView;
import com.bwf.lgqingdan.mvp.presenter.MainListPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.MainListPresenterImpl;
import com.bwf.lgqingdan.mvp.view.MainListView;
import com.bwf.lgqingdan.utils.Contants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class MainListFragment extends FragmentBase implements MainListView, BaseMainRecycleViewAdapter.OnRetryClickListener{

    @BindView(R.id.recyclerView_tab_list)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private BaseMainRecycleViewAdapter recycleAdapter;
    private MainListPresenter mainListPresenter;
    private boolean isLoadingMore;
    private LinearLayoutManager layoutManager;

    private String urlTag;
    private String categoryTag;

    public static MainListFragment newInstance(String categoryTag, String urlTag) {
        MainListFragment fragment = new MainListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("urlTag", urlTag);
        bundle.putString("categoryTag", categoryTag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_mian_list;
    }

    @Override
    protected void initViews() {

    }
    @Override
    protected void initDatas() {

        urlTag = getArguments().getString("urlTag");
        categoryTag = getArguments().getString("categoryTag");
        if (categoryTag.equals(Contants.TAG_NODES)) {
            recycleAdapter = new MainNodesRecycleViewAdapter(getActivity());
        } else if (Contants.TAG_ARTICLES.equals(categoryTag)) {
            recycleAdapter = new MainArticlesRecycleViewAdapter(getActivity());
        } else {
            recycleAdapter = new MainCollectionsRecycleViewAdapter(getActivity());
        }
        recycleAdapter.setOnRetryClickListener(this);
        mainListPresenter = new MainListPresenterImpl(this, urlTag);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.addOnScrollListener(recyclerViewScrollListener);
        //让FloatButtonOnRecycleView控制FloatingActionButton的显示、隐藏和点击事件
        new FloatButtonOnRecycleView(fab, recyclerView).init();
        loadNextData();
        if (categoryTag.equals(Contants.TAG_NODES)) {
            mainListPresenter.loadReputations();
        }

        //设置item监听
        recycleAdapter.setOnItemClickListener(new BaseMainRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position,View view, Object data) {
                if(data instanceof ResponseMainListData.DataBean.NodesBean){
                    Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
                    intent.putExtra(ArticleDetailActivity.ARTICLE_ID,((ResponseMainListData.DataBean.NodesBean) data).getTarget_id());
                    startActivity(intent);
                }else if(data instanceof ResponseMainListData.DataBean.ArticlesBean){
                    Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
                    intent.putExtra(ArticleDetailActivity.ARTICLE_ID,((ResponseMainListData.DataBean.ArticlesBean) data).getId());
                    startActivity(intent);
                }else if(data instanceof ResponseMainListData.DataBean.CollectionsBean){
                    Intent intent = new Intent(getActivity(), CollectionDetailActivity.class);
                    intent.putExtra(CollectionDetailActivity.COLLECTION_ID,((ResponseMainListData.DataBean.CollectionsBean) data).get_id());
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void loadNextData() {
        isLoadingMore = true;
        mainListPresenter.loadNextPageDatas();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }





    @Override
    public void showNodesToView(List<ResponseMainListData.DataBean.NodesBean> nodes) {
        recycleAdapter.addDatas(nodes);
        isLoadingMore = false;
    }

    @Override
    public void showArticlesToView(List<ResponseMainListData.DataBean.ArticlesBean> articles) {
        recycleAdapter.addDatas(articles);
        isLoadingMore = false;
    }

    @Override
    public void showCollectionsToView(List<ResponseMainListData.DataBean.CollectionsBean> collections) {
        recycleAdapter.addDatas(collections);
        isLoadingMore = false;
    }

    @Override
    public void showRecycleViewFooterLoading() {
        recycleAdapter.updateFooterState(BaseMainRecycleViewAdapter.STATE_LOADING);
    }
    @Override
    public void showRecycleViewFooterLoadFailed() {
        recycleAdapter.updateFooterState(BaseMainRecycleViewAdapter.STATE_LOAD_FAILED);
        isLoadingMore = false;
    }

    @Override
    public void showRecycleViewFooterNoMoreData() {
        Log.d(TAG, "View告诉Adapter没有数据啦");
        isNoMoreData = true;
        recycleAdapter.updateFooterState(BaseMainRecycleViewAdapter.STATE_NO_MORE_DATA);

    }




    @Override
    public void showReputations(List<ResponseReputation.DataBean.RankingsBean> reputations) {
        ((MainNodesRecycleViewAdapter) recycleAdapter).setReputations(reputations);
    }

    private boolean isNoMoreData;



    @Override
    public void onRetryClick() {
        loadNextData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    public void refreshData() {
        if(isAdded()){
            mainListPresenter.refreshData();
        }
    }
}
