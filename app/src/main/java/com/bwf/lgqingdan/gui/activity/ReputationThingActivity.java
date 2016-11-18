package com.bwf.lgqingdan.gui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.gui.fragment.RankingThingFragment;
import com.bwf.lgqingdan.utils.Contants;
import com.bwf.lgqingdan.utils.KeyBoardUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/7.
 */

public class ReputationThingActivity extends ActivityBase implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.search_edit_input)
    EditText searchEditInput;
    @BindView(R.id.img_search_delete)
    ImageView imgSearchDelete;
    @BindView(R.id.tv_text_search_cancel)
    TextView tvTextSearchCancel;
    @BindView(R.id.tv_review_tab)
    RadioButton tvReviewTab;
    @BindView(R.id.tv_rating_tab)
    RadioButton tvRatingTab;
    @BindView(R.id.tv_brand_tab)
    RadioButton tvBrandTab;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.root)
    RelativeLayout root;
    @BindView(R.id.tab_list)
    RadioGroup tabListRadioGroup;
    public static final String RANKING_ID = "rankingId";
    public static final String RANKING_TITLE = "rankingTitle";
    private int rankingId;

    private List<RankingThingFragment> fragments;
    private FragmentManager fragmentManager;
    private RankingThingFragment searchFragment;
    @Override
    public int getContentViewResID() {
        return R.layout.activity_reputation_thing;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText(getIntent().getStringExtra(RANKING_TITLE));
        root.setPadding(0,getStatusHeight(),0,0);
        tabListRadioGroup.setOnCheckedChangeListener(this);
        searchEditInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    doSearch(v.getText().toString());
                }
                return false;
            }
        });
        searchEditInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    imgSearchDelete.setVisibility(View.GONE);
                }else{
                    imgSearchDelete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 搜索
     * @param s
     */
    private void doSearch(String s) {
        if(TextUtils.isEmpty(s)){
            return;
        }
        tabListRadioGroup.setVisibility(View.GONE);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(searchFragment == null){
            searchFragment = RankingThingFragment.newInstance(rankingId,Contants.SEARCH,s);
            transaction.add(R.id.container,searchFragment);
        }else{
            searchFragment.showSearch(s);
            transaction.show(searchFragment);
        }
        transaction.commit();

    }

    @Override
    protected void initDatas() {
        rankingId = getIntent().getIntExtra(RANKING_ID, 0);
        fragments = new ArrayList<>();
        fragments.add(RankingThingFragment.newInstance(rankingId, Contants.SORT_BY_REVIEW_COUNT,""));
        fragments.add(RankingThingFragment.newInstance(rankingId, Contants.SORT_BY_rating_score,""));
        fragments.add(RankingThingFragment.newInstance(rankingId, Contants.SORT_BY_BRAND_NAME,""));
        fragmentManager = getSupportFragmentManager();
        switchTab(0);
    }


    private void hideSearchFragment(){
        if(searchFragment != null){
            fragmentManager.beginTransaction().hide(searchFragment).commit();
        }
    }
    @OnClick({R.id.back, R.id.img_search_delete, R.id.tv_text_search_cancel,R.id.search_edit_input})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.img_search_delete:
                searchEditInput.getText().clear();
                break;
            case R.id.tv_text_search_cancel:
                //点取消之后，关闭软键盘
                KeyBoardUtils.closeKeybord(searchEditInput,this);
                tvTextSearchCancel.setVisibility(View.GONE);
                searchEditInput.getText().clear();
                tabListRadioGroup.setVisibility(View.VISIBLE);
                hideSearchFragment();
                break;
            case R.id.search_edit_input:
                tvTextSearchCancel.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.tv_review_tab:
                switchTab(0);
                break;
            case R.id.tv_rating_tab:
                switchTab(1);
                break;
            case R.id.tv_brand_tab:
                switchTab(2);
                break;
        }

    }
    private Fragment currentFragment;
    private void switchTab(int index){
        Fragment fragment = fragments.get(index);
        //如果已经在显示
        if(currentFragment == fragment){
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(!fragment.isAdded()){//如果还没有添加
            transaction.add(R.id.container,fragment);
        }else{
            transaction.show(fragment);
        }
        if(currentFragment != null){
            transaction.hide(currentFragment);
        }
        currentFragment = fragment;
        transaction.commit();
    }
}
