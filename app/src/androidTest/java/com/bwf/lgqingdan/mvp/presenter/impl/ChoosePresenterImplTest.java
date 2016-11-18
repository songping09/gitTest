package com.bwf.lgqingdan.mvp.presenter.impl;

import android.util.Log;

import com.bwf.lgqingdan.entity.ResponseChoose;
import com.bwf.lgqingdan.mvp.presenter.ChoosePresenter;
import com.bwf.lgqingdan.mvp.view.ChooseView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
public class ChoosePresenterImplTest implements ChooseView {
    ChoosePresenter presenter;
    @Before
    public void setUp() throws Exception {
        presenter = new ChoosePresenterImpl(this);
    }

    @Test
    public void loadDatas() throws Exception {
        presenter.loadDatas();
    }

    @Override
    public void showCategorysView(List<ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories) {
        Log.d("ChoosePresenterImplTest", "categories.size():" + categories.size());
        Assert.assertEquals(13,categories.size());
    }

    @Override
    public void showTagsView(List<ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean> tags) {
        Log.d("ChoosePresenterImplTest", "tags.size():" + tags.size());
        Assert.assertEquals(8,tags.size());
    }

    @Override
    public void showLoadFailed() {

    }
}