package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseCollectionDetail;

/**
 * Created by Administrator on 2016/11/6.
 */

public interface CollectionDetailModel {

    void loadData(int collectionId,Callback callback);
    public interface Callback{
        void loadSuccess(ResponseCollectionDetail responseCollectionDetail);
        void loadFailed();
    }
}
