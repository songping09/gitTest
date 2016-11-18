package com.bwf.lgqingdan.mvp.presenter.impl;

import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.mvp.model.RelatedThingModel;
import com.bwf.lgqingdan.mvp.model.impl.RelatedThingModelImpl;
import com.bwf.lgqingdan.mvp.presenter.RelatedThingPresenter;
import com.bwf.lgqingdan.mvp.view.RelatedThingView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 * tips: 相关商品
 */

public class RelatedThingPresenterImpl implements RelatedThingPresenter, RelatedThingModel.Callback {
    private RelatedThingModel model;
    private RelatedThingView view;

    public RelatedThingPresenterImpl(RelatedThingView view) {
        this.view = view;
        this.model = new RelatedThingModelImpl();
    }

    @Override
    public void loadData(int articleId) {
        model.loadData(articleId,this);
    }

    @Override
    public void loadSuccess(List<ThingsBean> things) {
        view.showlatedThings(things);
    }

    @Override
    public void loadFailed(String failedMsg) {
        view.showLoadFailed(failedMsg);
    }
}
