package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseChoose;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */

public interface ChooseView {
    void showCategorysView(List<ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories);
    void showTagsView(List<ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean> tags);

    void showLoadFailed();
}
