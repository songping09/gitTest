package com.bwf.lgqingdan.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.lgqingdan.QingdanApplication;
import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ThingsBean;
import com.bwf.lgqingdan.gui.adapter.RelatedThingListAdapter;
import com.bwf.lgqingdan.mvp.presenter.RelatedThingPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.RelatedThingPresenterImpl;
import com.bwf.lgqingdan.mvp.view.RelatedThingView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 * tips：相关商品界面
 */

public class RelatedThingActivity extends ActivityBase implements RelatedThingView, AdapterView.OnItemClickListener {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.root)
    LinearLayout root;
    private RelatedThingPresenter presenter;
    public static final String ARTICLE_ID = "articleId";
    private int articleId;

    private RelatedThingListAdapter relatedThingListAdapter;
    @Override
    public int getContentViewResID() {
        return R.layout.activity_related_thing;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText(getString(R.string.related_thing));
        root.setPadding(0,getStatusHeight(),0,0);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadData();
            }
        });
        gridView.setOnItemClickListener(this);
    }

    @Override
    protected void initDatas() {
        articleId = getIntent().getIntExtra(ARTICLE_ID, 0);
        relatedThingListAdapter = new RelatedThingListAdapter(this);
        gridView.setAdapter(relatedThingListAdapter);

        presenter = new RelatedThingPresenterImpl(this);
        new Handler(){
            @Override
            public void handleMessage(Message msg) {
                refreshLayout.autoRefresh();
            }
        }.sendEmptyMessageDelayed(0,350);

    }

    private void loadData() {
        presenter.loadData(articleId);
    }

    @Override
    public void showlatedThings(List<ThingsBean> things) {
        refreshLayout.finishRefresh();
        relatedThingListAdapter.setDatas(things);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoadFailed(String failedMsg) {
        refreshLayout.finishRefresh();
        Toast.makeText(this, getString(R.string.loadFailed_please_pullToRefresh), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.back)
    public void onClick() {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ThingDetailActivity.class);
        ThingsBean thingsBean = relatedThingListAdapter.getItem(position);
        intent.putExtra(ThingDetailActivity.THING_ID,thingsBean.getId());
        QingdanApplication.instance.thingsBean = thingsBean;
        startActivity(intent);
    }
}
