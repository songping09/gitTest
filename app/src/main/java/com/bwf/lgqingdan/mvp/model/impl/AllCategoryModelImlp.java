package com.bwf.lgqingdan.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.lgqingdan.entity.ResponseAllCategory;
import com.bwf.lgqingdan.mvp.model.AllCategoryModel;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.http.lib.HttpUtils;
import com.bwf.lgqingdan.utils.http.lib.Request;
import com.bwf.lgqingdan.utils.http.qingdan.HttpClient;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public class AllCategoryModelImlp implements AllCategoryModel {

    @Override
    public void loadData(final Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(Apis.API_ALL_CATEGORY)
                .get();
        HttpClient.excute(builder, new HttpUtils.Callback() {
            @Override
            public void onResponse(String response) {
                ResponseAllCategory responseAllCategory = JSON.parseObject(response, ResponseAllCategory.class);
                callback.loadSuccess(responseAllCategory);
            }
            @Override
            public void onError() {
                callback.loadFailed();
            }
        });
    }
}
