package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseMainListData;
import com.bwf.lgqingdan.entity.ResponseReputation;
import com.bwf.lgqingdan.mvp.model.MainListModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by LG on 2016/10/24.
 * Tips:
 */

public class MainListModelImpl implements MainListModel {
    //urlTag可以是：http://api.eqingdan.com/v1/collections/108/articles?page={0}
    //  也可以是：http://api.eqingdan.com/v1/categories/nursing/articles?page={0}


    /**
     * 加载数据的方法
     * @param callback
     */
    @Override
    public void loadNextPageDatas(String url,final Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseMainListData responseData = JSON.parseObject(response,ResponseMainListData.class);
                if(responseData.getData().getMeta().getPagination().getTotal_pages() ==
                        responseData.getData().getMeta().getPagination().getCurrent_page()){
                    callback.noMoreData();
                }
                //根据返回的数据 判断访问得到是哪一种类型的数据
                if(responseData.getData().getArticles() != null){
                    callback.loadArticlesSuccess(responseData.getData().getArticles());
                }else if(responseData.getData().getCollections() != null){
                    callback.loadCollectionsSuccess(responseData.getData().getCollections());
                }else if(responseData.getData().getNodes() != null){
                    callback.loadNodesSuccess(responseData.getData().getNodes());
                }
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });
    }

    @Override
    public void loadReputations(final ReputationsCallback callback) {
        Request.Builder request = new Request.Builder()
                .url(Apis.API_Reputations)
                .get();
        HttpClient.excute(request, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseReputation responseReputation = JSON.parseObject(response,ResponseReputation.class);
                callback.loadReputationsSuccess(responseReputation.getData().getRankings());
            }

            @Override
            public void onError() {

            }
        });
    }
}
