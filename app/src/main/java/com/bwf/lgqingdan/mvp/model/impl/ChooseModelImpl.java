package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseChoose;
import com.bwf.lgqingdan.mvp.model.ChooseModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.http.lib.FormBody;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.lib.RequestBody;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/6.
 */

public class ChooseModelImpl implements ChooseModel{
    @Override
    public void loadDatas(final Callback callback) {
        RequestBody body = new FormBody.Builder()
                .add("requests","{\"tags\":{\"method\":\"GET\",\"relative_url\":\"/v1/tags/recommended\"},\"categories\":{\"method\":\"GET\",\"relative_url\":\"/v1/categories\"}}")
                .build();
        Request.Builder builder = new Request.Builder()
                .url(Apis.API_CHOOSE)
                .post(body);
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseChoose responseChoose = JSON.parseObject(response, ResponseChoose.class);
                callback.loadCategorysSuccess(responseChoose.getData().getCategories().getBody().getData().getCategories());
                callback.loadTagsSuccess(responseChoose.getData().getTags().getBody().getData().getTags());
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });

    }
}
