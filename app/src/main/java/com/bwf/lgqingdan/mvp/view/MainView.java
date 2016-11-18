package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.entity.ResponseDailyTips;

import java.util.List;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public interface MainView {

    void showBatching(List<ResponseMainData.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> slides);

    void showTabs(List<ResponseMainData.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean> channels);

    void showDailyTips(ResponseDailyTips dailyTips);

}
