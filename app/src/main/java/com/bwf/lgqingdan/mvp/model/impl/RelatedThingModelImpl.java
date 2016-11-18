package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseRelatedThing;
import com.bwf.lgqingdan.mvp.model.RelatedThingModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.UrlHandler;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/14.
 */

public class RelatedThingModelImpl implements RelatedThingModel{
    @Override
    public void loadData(int articlleId,final Callback callback) {
        String url = UrlHandler.handlUrl(Apis.API_RELATED_THING,articlleId);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseRelatedThing responseRelatedThing = JSON.parseObject(response, ResponseRelatedThing.class);
                if(responseRelatedThing.getCode() == 0){
                    callback.loadSuccess(responseRelatedThing.getData().getThings());
                }else{
                    callback.loadFailed(responseRelatedThing.getMessage());
                }
            }

            @Override
            public void onError() {
                callback.loadFailed("访问服务器失败");
            }
        });
    }
}
