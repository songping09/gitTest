package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.entity.ResponseReputation;

import java.util.List;

/**
 * Created by LG on 2016/10/20.
 * Tips:
 */

public interface MainListView {
    void showNodesToView(List<ResponseMainListData.DataBean.NodesBean> nodes);
    void showArticlesToView(List<ResponseMainListData.DataBean.ArticlesBean> articles);
    void showCollectionsToView(List<ResponseMainListData.DataBean.CollectionsBean> collections);

    void showRecycleViewFooterLoading();
    void showRecycleViewFooterLoadFailed();
    void showRecycleViewFooterNoMoreData();


    void showReputations(List<ResponseReputation.DataBean.RankingsBean> reputations);

}
