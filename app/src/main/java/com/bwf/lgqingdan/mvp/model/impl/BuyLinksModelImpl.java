package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseBuyLinks;
import com.bwf.lgqingdan.mvp.model.BuyLinksModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.UrlHandler;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/14.
 */

public class BuyLinksModelImpl implements BuyLinksModel{
    @Override
    public void loadBuyLinks(int thingId, final Callback callback) {
        String url = UrlHandler.handlUrl(Apis.API_BUY_LINKS,thingId);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseBuyLinks responseBuyLinks = JSON.parseObject(response, ResponseBuyLinks.class);
                if(responseBuyLinks.getCode() == 0){
                    callback.loadBuyLinksSuccess(responseBuyLinks.getData().getBuylinks());
                }else{
                    callback.loadFailed(responseBuyLinks.getMessage());
                }
            }

            @Override
            public void onError() {
                callback.loadFailed("访问服务器失败");
            }
        });

    }
}
