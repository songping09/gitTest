package com.bwf.lgqingdan.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseReputationThing;
import com.bwf.lgqingdan.mvp.model.ReputationThingModel;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/7.
 */

public class ReputationThingModelImpl implements ReputationThingModel {
    @Override
    public void loadData(String url, final Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        Log.d("ReputationThingModelImp", "加载数据咯");
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseReputationThing responseReputationThing = JSON.parseObject(response, ResponseReputationThing.class);
                callback.loadSuccess(responseReputationThing.getData().getThings());
                if(responseReputationThing.getData().getMeta().getPagination().getTotal_pages() == 0){
                    callback.noSearchData();
                    return;
                }
                if(responseReputationThing.getData().getMeta().getPagination().getTotal_pages() ==
                        responseReputationThing.getData().getMeta().getPagination().getCurrent_page()
                        ){
                    callback.noMoreData();
                }
                Log.d("ReputationThingModelImp", "Success");
            }

            @Override
            public void onError() {
                callback.loadFailed();
                Log.d("ReputationThingModelImp", "error");
            }
        });
    }
}
