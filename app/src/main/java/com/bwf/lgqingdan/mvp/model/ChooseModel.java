package com.bwf.lgqingdan.mvp.model;

import com.bwf.lgqingdan.entity.ResponseChoose;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */

public interface ChooseModel {
    void loadDatas(Callback callback);
    public interface Callback{
        void loadCategorysSuccess(List<ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories);
        void loadTagsSuccess(List<ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean> tags);
        void loadFailed();
    }

}
