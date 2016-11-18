package com.bwf.lgqingdan.mvp.presenter.impl;

import android.text.TextUtils;
import android.util.Log;

import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.gui.activity.RelatedThingActivity;
import com.bwf.lgqingdan.mvp.model.ReputationThingModel;
import com.bwf.lgqingdan.mvp.model.impl.ReputationThingModelImpl;
import com.bwf.lgqingdan.mvp.presenter.ReputationThingPresenter;
import com.bwf.lgqingdan.mvp.view.ReputationThingView;
import com.bwf.lgqingdan.utils.Apis;
import com.bwf.lgqingdan.utils.Contants;
import com.bwf.lgqingdan.utils.UrlHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public class ReputationThingPresenterImpl implements ReputationThingPresenter, ReputationThingModel.Callback {
    private ReputationThingModel model;
    private ReputationThingView view;

    private int sortTag;
    private int nextPage = 1;
    private int rankingId;
    public ReputationThingPresenterImpl(ReputationThingView view,int sortTag,int rankingId) {
        this.view = view;
        this.sortTag = sortTag;
        this.rankingId = rankingId;
        this.model = new ReputationThingModelImpl();
    }

    public ReputationThingPresenterImpl(RelatedThingActivity relatedThingActivity) {
    }

    @Override
    public void loadNextData(String key) {
        if(!TextUtils.isEmpty(key)){
            try {
                key = URLEncoder.encode(key,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String url = "";
        switch (sortTag){
            case Contants.SORT_BY_REVIEW_COUNT:
            case Contants.SEARCH:
                url = UrlHandler.handlUrl(Apis.API_REPUTATION_THING_SORT_BY_REVIEW_COUNT,rankingId,key,nextPage);
                break;
            case Contants.SORT_BY_rating_score:
                url = UrlHandler.handlUrl(Apis.API_REPUTATION_THING_SORT_BY_rating_score,rankingId,key,nextPage);
                break;
            case Contants.SORT_BY_BRAND_NAME:
                url = UrlHandler.handlUrl(Apis.API_REPUTATION_THING_SORT_BY_BRAND_NAME,rankingId,key,nextPage);
                break;
        }
        model.loadData(url,this);
        Log.d("ReputationThingPresente", url);
        view.showFooterLoading();
    }

    @Override
    public void refreshData(String key) {
        nextPage = 1;
        loadNextData(key);
    }

    @Override
    public void loadSuccess(List<ThingsBean> things) {
        view.showThingsToView(nextPage,things);
        nextPage++;
        Log.d("ReputationThingPresente", "success");
    }

    @Override
    public void loadFailed() {
        view.showFooterLoadFailed();
    }

    @Override
    public void noMoreData() {
        view.showFooterNoMoreData();
    }

    @Override
    public void noSearchData() {
        view.showFooterNoSearchData();
    }
}
