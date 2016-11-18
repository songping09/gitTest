package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseAllCategory;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public interface AllCategoryModel {
    void loadData(Callback callback);
    public interface Callback{
        void loadSuccess(ResponseAllCategory allCategory);
        void loadFailed();
    }
}
