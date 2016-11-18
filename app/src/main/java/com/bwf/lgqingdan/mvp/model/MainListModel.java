package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.entity.ResponseReputation;

import java.util.List;

/**
 * Created by LG on 2016/10/20.
 * Tips:
 */

public interface MainListModel {
    void loadNextPageDatas(String url,Callback callback);

    public interface Callback{
        void loadCollectionsSuccess(List<ResponseMainListData.DataBean.CollectionsBean> collections);
        void loadNodesSuccess(List<ResponseMainListData.DataBean.NodesBean> nodes);
        void loadArticlesSuccess(List<ResponseMainListData.DataBean.ArticlesBean> articles);
        void loadFailed();
        void noMoreData();
    }

    void loadReputations(ReputationsCallback callback);
    public interface ReputationsCallback{
        void loadReputationsSuccess(List<ResponseReputation.DataBean.RankingsBean> reputations);
    }
}
