package com.bwf.lgqingdan.gui.fragment;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseDailyTips;
import com.bwf.lgqingdan.entity.ResponseMainData;
import com.bwf.lgqingdan.gui.adapter.MainSlideFragmentPagerAdapter;
import com.bwf.lgqingdan.gui.adapter.MainSlidePagerAdapter;
import com.bwf.lgqingdan.gui.view.AutoScrollViewPager;
import com.bwf.lgqingdan.gui.view.CustomRefreshLayout;
import com.bwf.lgqingdan.gui.widget.PagerDotIndicator;
import com.bwf.lgqingdan.mvp.presenter.MainPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.MainPresenterImpl;
import com.bwf.lgqingdan.mvp.view.MainView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bwf.lgqingdan.R.id.rela_title;


/**
 * Created by LG on 2016/10/14.
 * Tips:
 */

public class MainFragment extends FragmentBase implements MainView {
    @BindView(R.id.viewPager_main_list_slide)
    AutoScrollViewPager viewPagerMainListSlide;
    @BindView(R.id.linearLayout_pager_indicator)
    LinearLayout linearLayoutPagerIndicator;
    @BindView(R.id.img_title_left)
    ImageView imgTitleLeft;
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.img_title_right)
    ImageView imgTitleRight;
    @BindView(rela_title)
    RelativeLayout relaTitle;
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;
    @BindView(R.id.collapsingToolbarLayout_main)
    CollapsingToolbarLayout collapsingToolbarLayoutMain;
    @BindView(R.id.tabLayout_main)
    TabLayout tabLayoutMain;
    @BindView(R.id.appBarLayout_main)
    AppBarLayout appBarLayoutMain;
    @BindView(R.id.viewPager_main_fragment)
    ViewPager viewPagerMainFragment;
    @BindView(R.id.imageView_subview_main_empty)
    ImageView imageViewSubviewMainEmpty;
    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;
    private MainPresenter mainPresenter;
    private MainSlidePagerAdapter batchingPagerAdapter;
    private PagerDotIndicator dotIndicator;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initViews() {
        appBarLayoutMain.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            private int[] location = new int[2];

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                tabLayoutMain.getLocationOnScreen(location);
                /**location[1]  2*toolbarMain.getHeight() x  toolbarMain.getHeight()
                 *                   1                    y   0
                 * 2*toolbarMain.getHeight() - toolbarMain.getHeight()  2*toolbarMain.getHeight()-x
                 * ----------------------------------------------    =  -----------------------
                 *  1 - 0                                                1 - y
                 *
                 *           2*toolbarMain.getHeight()-location[1]
                 * y =   1 -    ---------------
                 *            toolbarMain.getHeight()
                 */
                if (verticalOffset == 0) {
                    refreshLayout.setCanPull(true);
                } else {
                    refreshLayout.setCanPull(false);
                }

                Log.d("MainFragment", "location[1]:" + location[1]);
                if (location[1] <= 2 * toolbarMain.getHeight()) {
                    textViewTitle.setVisibility(View.VISIBLE);
                    imgTitleLeft.setImageLevel(1);
                    imgTitleRight.setImageLevel(1);
                    textViewTitle.setAlpha((2f * toolbarMain.getHeight() - location[1]) / toolbarMain.getHeight());
                } else {
                    textViewTitle.setVisibility(View.GONE);
                    imgTitleLeft.setImageLevel(0);
                    imgTitleRight.setImageLevel(0);
                }
                /**
                 * alpha = 1
                 *
                 */
            }
        });
        setMargins(getView().findViewById(R.id.rela_title), -1, getStatusHeight(), -1, -1);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mainPresenter.loadMainDatas();
            }
        });
    }

    @Override
    protected void initDatas() {
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.loadMainDatas();
    }


    @Override
    public void showBatching(List<ResponseMainData.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> slides) {
        dotIndicator = new PagerDotIndicator(getActivity(), linearLayoutPagerIndicator, viewPagerMainListSlide);
        dotIndicator.setNumberDots(slides.size());
        dotIndicator.setCurrentDot(0);
        batchingPagerAdapter = new MainSlidePagerAdapter(getActivity(), slides);
        viewPagerMainListSlide.setAdapter(batchingPagerAdapter);
        imageViewSubviewMainEmpty.setVisibility(View.GONE);
        refreshLayout.finishRefresh();
        Log.d("MainFragment", "slides.size():" + slides.size());
    }

    private boolean isInitTabs;
    private MainSlideFragmentPagerAdapter slideFragmentPagerAdapter;
    @Override
    public void showTabs(List<ResponseMainData.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean> channels) {
        if(!isInitTabs){
            slideFragmentPagerAdapter = new MainSlideFragmentPagerAdapter(channels, getFragmentManager());
            viewPagerMainFragment.removeAllViews();
            viewPagerMainFragment.setAdapter(slideFragmentPagerAdapter);
            tabLayoutMain.removeAllTabs();
            tabLayoutMain.setupWithViewPager(viewPagerMainFragment);
            isInitTabs = true;
        }else{
            slideFragmentPagerAdapter.refreshData();
        }

    }


    private WindowManager windowManager;
    private View dailyTipsView;
    private WindowManager.LayoutParams windowLayoutParams;
    private DailyTipsViewHolder dailyTipsViewHolder;
    private boolean isShowDailyTipsWindow;

    public boolean isShowDailyTipsWindow() {
        return isShowDailyTipsWindow;
    }

    /**
     * 这里使用WindowManager添加窗口来实现效果
     * 如果用PopupWindow，不能覆盖状态栏(未解决)
     *
     * @param dailyTips
     */
    @Override
    public void showDailyTips(ResponseDailyTips dailyTips) {
        if (windowManager == null) {
            windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            dailyTipsView = LayoutInflater.from(getActivity()).inflate(R.layout.subview_daily_tips, null);
            dailyTipsViewHolder = new DailyTipsViewHolder(dailyTipsView);
            //创建窗口的布局参数 使用带参构造将异常new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT)
            windowLayoutParams = new WindowManager.LayoutParams();
            windowLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;//宽度全屏宽
            windowLayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;//高度全屏高
            windowLayoutParams.format = PixelFormat.RGBA_8888;//设置窗口背景色透明
            //给Window设置Flag  状态栏透明、可以接收返回键
            windowLayoutParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE ;
            //监听View与Window的关联和取消关联
            dailyTipsView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    isShowDailyTipsWindow = true;
                }
                @Override
                public void onViewDetachedFromWindow(View v) {
                    isShowDailyTipsWindow = false;
                }
            });
        }
        windowManager.addView(dailyTipsView, windowLayoutParams);//添加View
        dailyTipsViewHolder.imgDailyTips.setImageURI(dailyTips.getData().getImageUrl());
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        Log.d("MainFragment", "onCreateView");
        return rootView;
    }

    @OnClick({R.id.img_title_left, R.id.img_title_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_title_left:
                mainPresenter.loadDailyTips();
                break;
            case R.id.img_title_right:
                //TODO
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void hideDailyTipsWindow() {
        if(isShowDailyTipsWindow()){
            windowManager.removeView(dailyTipsViewHolder.view);
        }
    }

    class DailyTipsViewHolder {
        @BindView(R.id.img_daily_tips)
        SimpleDraweeView imgDailyTips;
        @BindView(R.id.img_btn_wechat)
        ImageView imgBtnWechat;
        @BindView(R.id.img_btn_moments)
        ImageView imgBtnMoments;
        @BindView(R.id.img_btn_download)
        ImageView imgBtnDownload;
        @BindView(R.id.img_btn_off)
        ImageView imgBtnOff;
        View view;
        DailyTipsViewHolder(View view) {
            ButterKnife.bind(this, view);
            this.view = view;
        }
        @OnClick({R.id.img_btn_wechat, R.id.img_btn_moments,R.id.img_btn_download,R.id.img_btn_off})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.img_btn_wechat:
                    //TODO
                    Toast.makeText(getActivity(), "微信", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.img_btn_moments:
                    //TODO
                    Toast.makeText(getActivity(), "朋友圈", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.img_btn_download:
                    //TODO
                    Toast.makeText(getActivity(), "下载", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.img_btn_off:
                   hideDailyTipsWindow();
                    break;
            }
        }
    }
}
