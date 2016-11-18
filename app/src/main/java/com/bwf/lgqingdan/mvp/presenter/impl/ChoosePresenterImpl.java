package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseChoose;
import com.bwf.lgqingdan.mvp.model.ChooseModel;
import com.bwf.lgqingdan.mvp.model.impl.ChooseModelImpl;
import com.bwf.lgqingdan.mvp.presenter.ChoosePresenter;
import com.bwf.lgqingdan.mvp.view.ChooseView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */

public class ChoosePresenterImpl implements ChoosePresenter, ChooseModel.Callback {
    private ChooseModel model;
    private ChooseView view;

    public ChoosePresenterImpl(ChooseView view) {
        this.view = view;
        this.model = new ChooseModelImpl();
    }

    @Override
    public void loadDatas() {
        model.loadDatas(this);
    }

    @Override
    public void loadCategorysSuccess(List<ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories) {
        view.showCategorysView(categories);
    }

    @Override
    public void loadTagsSuccess(List<ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean> tags) {
        view.showTagsView(tags);
    }

    @Override
    public void loadFailed() {
        view.showLoadFailed();
    }
}
