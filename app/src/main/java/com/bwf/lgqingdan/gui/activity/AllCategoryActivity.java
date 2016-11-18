package com.bwf.lgqingdan.gui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseAllCategory;
import com.bwf.lgqingdan.gui.adapter.AllCategoryImageAdapter;
import com.bwf.lgqingdan.gui.adapter.base.BaseRecycleViewAdapter;
import com.bwf.lgqingdan.mvp.presenter.AllCategoryPresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.AllCategoryPresenterImpl;
import com.bwf.lgqingdan.mvp.view.AllCategoryView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public class AllCategoryActivity extends ActivityBase implements AllCategoryView,
        BaseRecycleViewAdapter.OnItemClickListener {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.recycleview_all_category)
    RecyclerView recycleViewAllCategory;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.root)
    LinearLayout root;

    AllCategoryPresenter presenter;
    @BindView(R.id.progressBar_loading)
    ProgressBar progressBarLoading;
    @BindView(R.id.textView_loading)
    TextView textViewLoading;
    @BindView(R.id.loadingLayout)
    RelativeLayout loadingLayout;
    private AllCategoryImageAdapter imageAdapter;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_all_category;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        root.setPadding(0, getStatusHeight(), 0, 0);
        title.setText("全部分类");
        //给RecycleView设置一个LayoutManager(如果不设置，界面会空白，到时候错误比较难找)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleViewAllCategory.setLayoutManager(layoutManager);
        //一开始就给RecycleView设置Adapter
        imageAdapter = new AllCategoryImageAdapter(this);
        recycleViewAllCategory.setAdapter(imageAdapter);

        //设置item单击监听
        imageAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initDatas() {
        presenter = new AllCategoryPresenterImpl(this);
        presenter.loadData();
    }


    @OnClick({R.id.back,R.id.textView_loading})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.textView_loading:
                presenter.loadData();
                break;
        }
    }

    @Override
    public void showLoadingView() {
        loadingLayout.setVisibility(View.VISIBLE);
        progressBarLoading.setVisibility(View.VISIBLE);
        textViewLoading.setClickable(false);
        textViewLoading.setText(getString(R.string.loading));
    }

    @Override
    public void hideLoadingView() {
        loadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showFailedView() {
        loadingLayout.setVisibility(View.VISIBLE);
        progressBarLoading.setVisibility(View.GONE);
        textViewLoading.setClickable(true);
        textViewLoading.setText(getString(R.string.loadDataFailedAndClickRetry));
    }

    private ResponseAllCategory responseAllCategory;

    @Override
    public void showCategorys(ResponseAllCategory responseAllCategory) {
        this.responseAllCategory = responseAllCategory;
        //获取到网络数据之后 给Adapter设置数据
        imageAdapter.setDatas(responseAllCategory.getData().getCategories());
        switchCategory(0);
    }

    private int currentPosition = -1;

    private void switchCategory(int position) {
        if (currentPosition == position) {
            return;
        }
        currentPosition = position;
        container.removeAllViews(); //先移除所有的view
        LayoutInflater inflater = LayoutInflater.from(this);
        List<ResponseAllCategory.DataBean.CategoriesBean.ChildrenBean> childrens = responseAllCategory.getData().getCategories().get(position).getChildren();
        //循环添加子分类
        for (int i = 0; i < childrens.size(); i++) {
            View view = inflater.inflate(R.layout.list_item_all_category_tabs, container, false);
            ViewHolder holder = new ViewHolder(view);
            holder.layoutCategory.setTag(childrens.get(i));
            holder.layoutCategory.setOnClickListener(categoryOnClickListener);
            holder.textViewCategoryTitle.setText(childrens.get(i).getName());
            //向流式布局中循环添加标签
            for (int j = 0; j < childrens.get(i).getChildren().size(); j++) {
                TextView tabView = (TextView) inflater.inflate(R.layout.subview_category_tab, holder.flowLayout, false);
                tabView.setTag(childrens.get(i).getChildren().get(j));
                tabView.setOnClickListener(tabOnClickListener);
                tabView.setText(childrens.get(i).getChildren().get(j).getName());
                holder.flowLayout.addView(tabView);
            }
            container.addView(view);
        }
    }

    private View.OnClickListener categoryOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ResponseAllCategory.DataBean.CategoriesBean.ChildrenBean childrenBean =
                    (ResponseAllCategory.DataBean.CategoriesBean.ChildrenBean) v.getTag();
            Toast.makeText(AllCategoryActivity.this, childrenBean.getName() + childrenBean.getTagId(), Toast.LENGTH_SHORT).show();
            //TODO
        }
    };
    private View.OnClickListener tabOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ResponseAllCategory.DataBean.CategoriesBean.ChildrenBean.ChildrenBean2 childrenBean2 =
                    (ResponseAllCategory.DataBean.CategoriesBean.ChildrenBean.ChildrenBean2) v.getTag();
            Toast.makeText(AllCategoryActivity.this, childrenBean2.getName() + childrenBean2.getTagId(), Toast.LENGTH_SHORT).show();
            //TODO
        }
    };

    @Override
    public void onItemClick(int position, View view, Object data) {
        imageAdapter.setSelectedPosition(position);
        switchCategory(position);
    }


    static class ViewHolder {
        @BindView(R.id.textView_category_title)
        TextView textViewCategoryTitle;
        @BindView(R.id.layout_category)
        RelativeLayout layoutCategory;
        @BindView(R.id.flowLayout)
        FlowLayout flowLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
