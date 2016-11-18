package com.bwf.lgqingdan.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseBuyLinks;
import com.bwf.lgqingdan.gui.adapter.BuyLinksAdapter;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.bwf.lgqingdan.mvp.presenter.BuyLinksPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.BuyLinksPresenterImpl;
import com.bwf.lgqingdan.mvp.view.BuyLinksView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 */

public class BuyLinksActivity extends ActivityBase implements BuyLinksView, BaseRecycleViewAdapter.OnItemClickListener<ResponseBuyLinks.DataBean.BuylinksBean> {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.root)
    LinearLayout root;

    private BuyLinksPresenter presenter;
    public static final String THING_ID = "thingId";
    private int thingId;
    private BuyLinksAdapter buyLinksAdapter;
    @Override
    public int getContentViewResID() {
        return R.layout.activity_buy_links;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText(getString(R.string.buyChannel));
        root.setPadding(0,getStatusHeight(),0,0);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadBuyLinks();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initDatas() {
        thingId = getIntent().getIntExtra(THING_ID,0);
        presenter = new BuyLinksPresenterImpl(this);
        buyLinksAdapter = new BuyLinksAdapter(this);
        buyLinksAdapter.setOnItemClickListener(this);
        recycleView.setAdapter(buyLinksAdapter);
        loadBuyLinks();
    }
    private void loadBuyLinks(){
        presenter.loadBuyLinks(thingId);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.back)
    public void onClick() {
        finish();
    }

    @Override
    public void showBuyLinks(List<ResponseBuyLinks.DataBean.BuylinksBean> buylinks) {
        buyLinksAdapter.setDatas(buylinks);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        refreshLayout.finishRefresh();
    }

    @Override
    public void showLoadFailed(String failedMsg) {

    }

    @Override
    public void onItemClick(int position, View view, ResponseBuyLinks.DataBean.BuylinksBean data) {
        Intent intent = new Intent(this,BuyActivity.class);
        intent.putExtra(BuyActivity.URL,data.getLink());
        startActivity(intent);
    }
}
