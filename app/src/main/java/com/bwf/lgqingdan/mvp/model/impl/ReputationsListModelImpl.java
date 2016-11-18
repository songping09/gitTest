package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseReputationsList;
import com.bwf.lgqingdan.mvp.model.ReputationsListModel;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/13.
 */

public class ReputationsListModelImpl implements ReputationsListModel{
    @Override
    public void loadData(String url, final Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseReputationsList responseReputationsList = JSON.parseObject(response,ResponseReputationsList.class);
                if(responseReputationsList.getCode() == 0){
                    if(responseReputationsList.getData().getMeta().getPagination().getTotal_pages()
                            == responseReputationsList.getData().getMeta().getPagination().getCurrent_page()){
                        callback.noMoreDatas();
                    }
                    callback.loadSuccess(responseReputationsList.getData().getRankings());
                }else{
                    callback.loadFailed(responseReputationsList.getMessage());
                }
            }

            @Override
            public void onError() {
                callback.loadFailed("访问服务器失败");
            }
        });
    }
}
