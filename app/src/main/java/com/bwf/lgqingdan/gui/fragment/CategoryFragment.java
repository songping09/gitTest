package com.bwf.lgqingdan.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.entity.ResponseChoose;
import com.bwf.lgqingdan.gui.activity.AllCategoryActivity;
import com.bwf.lgqingdan.gui.adapter.ChooseCategoryAdapter;
import com.bwf.lgqingdan.gui.adapter.ChooseTagAdapter;
import com.bwf.lgqingdan.gui.view.NestingGridView;
import com.bwf.lgqingdan.mvp.presenter.ChoosePresenter;
import com.bwf.lgqingdan.mvp.presenter.impl.ChoosePresenterImpl;
import com.bwf.lgqingdan.mvp.view.ChooseView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bwf.lgqingdan.R.id.rgv_great_category;

/**
 * Created by LG on 2016/10/14.
 * Tips:挑选界面
 */

public class CategoryFragment extends FragmentBase implements ChooseView, AdapterView.OnItemClickListener {
    @BindView(R.id.TextView_search_text)
    AutoCompleteTextView TextViewSearchText;
    @BindView(R.id.layout_search)
    RelativeLayout layoutSearch;
    @BindView(rgv_great_category)
    NestingGridView rgvGreatCategory;
    @BindView(R.id.rgv_hot_tag)
    NestingGridView rgvHotTag;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;

    private ChoosePresenter presenter;
    private ChooseCategoryAdapter categoryAdapter;
    private ChooseTagAdapter tagAdapter;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initViews() {
        setMargins(layoutSearch,-1,getStatusHeight(),-1,-1);
        categoryAdapter = new ChooseCategoryAdapter(getActivity());
        rgvGreatCategory.setAdapter(categoryAdapter);
        tagAdapter = new ChooseTagAdapter(getContext());
        rgvHotTag.setAdapter(tagAdapter);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas();
            }
        });
        rgvGreatCategory.setOnItemClickListener(this);
        rgvHotTag.setOnItemClickListener(this);
    }

    @Override
    protected void initDatas() {
        presenter = new ChoosePresenterImpl(this);
        presenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.TextView_search_text)
    public void onClick() {
    }

    @Override
    public void showCategorysView(List<ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories) {
        refreshLayout.finishRefresh();
        categoryAdapter.setDatas(categories);
    }

    @Override
    public void showTagsView(List<ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean> tags) {
        tagAdapter.setDatas(tags);
    }

    @Override
    public void showLoadFailed() {
        refreshLayout.finishRefresh();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent == rgvGreatCategory){
            if(position == categoryAdapter.getCount()-1 && categoryAdapter.isShowMore()){
                //TODO
                Toast.makeText(getActivity(), "查看更多分类", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), AllCategoryActivity.class));
            }else{
                //TODO
                ResponseChoose.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean categoriesBean = categoryAdapter.getItem(position);
                Toast.makeText(getActivity(), categoriesBean.getName(), Toast.LENGTH_SHORT).show();
            }
        }else if(parent == rgvHotTag){
            if(position == tagAdapter.getCount()-1){
                //TODO
                Toast.makeText(getActivity(), "查看更多标签", Toast.LENGTH_SHORT).show();
            }else{
                //TODO
                ResponseChoose.DataBean1.TagsBean1.BodyBean.DataBean.TagsBean tagsBean = tagAdapter.getItem(position);
                Toast.makeText(getActivity(), tagsBean.getName(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
