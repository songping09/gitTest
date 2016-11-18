package com.bwf.lgqingdan.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.entity.ResponseDailyTips;
import com.bwf.lgqingdan.mvp.model.MainModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.http.lib.FormBody;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.lib.RequestBody;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;
import com.bwf.lgqingdan.utils.http.qingdan.RequestBuilder;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class MainModelImpl implements MainModel {

    @Override
    public void loadDatas(Callback callback) {
        loadMainData(callback);
    }

    @Override
    public void loadMainData(final Callback callback) {
        RequestBody body = new FormBody.Builder()
                .add("requests","{\"channels\":{\"method\":\"GET\",\"relative_url\":\"/v1/channels\"},\"slides\":{\"method\":\"GET\",\"relative_url\":\"/v1/slides2\"}}")
                .build();
        Request.Builder request = RequestBuilder.getBuilder()
                .url("http://api.eqingdan.com/v1/batching")
                .post(body);
        HttpClient.excute(request, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseMainData mainData = JSON.parseObject(response,ResponseMainData.class);
                Log.d("MainPresenterImpl", "response:" + response);
                if(callback != null){
                    if(mainData.getCode() == 0){
                        callback.loadMainDataSuccess(mainData);
                    }else {
                        callback.loadMainDataFailed(mainData.getMessage());
                    }
                }
            }
            @Override
            public void onError() {
                callback.loadMainDataFailed("访问服务器失败");
            }
        });
    }
    private ResponseDailyTips responseDailyTipsTem;
    @Override
    public void loadDailyTips(final Callback callback) {
        //先判断内存中是否存在数据
        if(responseDailyTipsTem != null && responseDailyTipsTem.getCode() ==0){
            callback.loadDailyTipsSuccess(responseDailyTipsTem);
            return;
        }

        String url = Apis.API_TODAY_TIPS;
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseDailyTips responseDailyTips = JSON.parseObject(response, ResponseDailyTips.class);
                if(callback == null) return;
                if(responseDailyTips.getCode() == 0){
                    callback.loadDailyTipsSuccess(responseDailyTips);
                    responseDailyTipsTem = responseDailyTips;
                }else{
                    callback.loadDailyTipsFailed(responseDailyTips.getMessage());
                }
            }

            @Override
            public void onError() {
                callback.loadDailyTipsFailed("访问服务器失败");
            }
        });
    }
}
