package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ResponseAllCategory;
import com.bwf.lgqingdan.mvp.model.AllCategoryModel;
import com.bwf.lgqingdan.mvp.model.impl.AllCategoryModelImlp;
import com.bwf.lgqingdan.mvp.presenter.AllCategoryPresenter;
import com.bwf.lgqingdan.mvp.view.AllCategoryView;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public class AllCategoryPresenterImpl implements AllCategoryPresenter, AllCategoryModel.Callback {
    private AllCategoryModel model;
    private AllCategoryView view;

    public AllCategoryPresenterImpl(AllCategoryView view) {
        this.view = view;
        this.model = new AllCategoryModelImlp();
    }

    @Override
    public void loadData() {
        view.showLoadingView();
        model.loadData(this);
    }

    @Override
    public void loadSuccess(ResponseAllCategory allCategory) {
        view.showCategorys(allCategory);
        view.hideLoadingView();
    }

    @Override
    public void loadFailed() {
        view.showFailedView();
    }
}
