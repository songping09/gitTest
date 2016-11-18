package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseCollectionDetail;
import com.bwf.lgqingdan.mvp.model.CollectionDetailModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.http.lib.FormBody;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/6.
 */

public class CollectionDetailModelImpl implements CollectionDetailModel{


    @Override
    public void loadData(int collectionId, final Callback callback) {

        FormBody body = new FormBody.Builder()
                .add("requests",
                        "{\"collections\":{\"method\":\"GET\",\"relative_url\":\"/v1/collections/"+collectionId+"/articles\"},\"collection\":{\"method\":\"GET\",\"relative_url\":\"/v1/collections/"+collectionId+"\"}}")
                .build();
        Request.Builder builder = new Request.Builder()
                .url(Apis.API_COLLECTION_DETAIL)
                .post(body);
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseCollectionDetail responseCollectionDetail = JSON.parseObject(response, ResponseCollectionDetail.class);
                callback.loadSuccess(responseCollectionDetail);
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });
    }
}
