package com.bwf.lgqingdan.gui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.gui.adapter.ScreenSlidePagerAdapter;
import com.bwf.lgqingdan.gui.fragment.CategoryFragment;
import com.bwf.lgqingdan.gui.fragment.MainFragment;
import com.bwf.lgqingdan.gui.fragment.MainMeFragment;
import com.bwf.lgqingdan.utils.AppVerison;
import com.bwf.lgqingdan.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityBase implements View.OnClickListener {
    private int[] mTabIds;
    private CheckedTextView[] mTabs;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        mTabIds = new int[]{R.id.toggleButton_home_list,R.id.toggleButton_home_thing,R.id.toggleButton_home_me};
        mTabs = new CheckedTextView[mTabIds.length];
        for (int i = 0; i < mTabs.length; i++) {
            mTabs[i] = findViewByIdNoCast(mTabIds[i]);
            mTabs[i].setOnClickListener(this);
        }

        mViewPager = findViewByIdNoCast(R.id.viewpager_main);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragments(),getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                showPage(position);
            }
        });
        showPage(0);

        if(isVersionFirst()){
            showGuide();
        }

    }

    @Override
    protected void initDatas() {

    }

    private List<Fragment> getFragments(){
        this.fragments =  new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new MainMeFragment());
        return fragments;
    }
    @Override
    public int getContentViewResID() {
        return R.layout.activity_main;
    }


    public void showGuide(){
    }

    public void showPage(int index){
        if(mTabs[index].isChecked()){
            return;
        }
        for (int i = 0; i < mTabs.length; i++) {
            if(i == index){
                mTabs[i].setChecked(true);
            }else{
                mTabs[i].setChecked(false);
            }
        }
        mViewPager.setCurrentItem(index);
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < mTabs.length; i++) {
            if(mTabs[i] == v){
                showPage(i);
                return;
            }
        }
    }

    /**
     * 判断当前版本是不是第一次进入应用
     *
     * @return
     */
    private boolean isVersionFirst() {
        String version = (String) SPUtils.get(this,"app_version","");
        //获取到当前应用版本名字
        String versionName = AppVerison.getAppVersionName(this);
        Log.d("MainActivity", version+"");
        Log.d("MainActivity", versionName+"");
        if(!versionName.equals(version)){
            SPUtils.put(this,"app_version",versionName);
            return true;
        }
        return false;
    }

    private boolean exit;
    @Override
    public void onBackPressed() {

        if(mTabs[0].isChecked()){
            //判断MainFragment是否显示了DailyTips窗口
            if(fragments.get(0) instanceof MainFragment){
                MainFragment mainFragment = (MainFragment) fragments.get(0);
                if(mainFragment.isShowDailyTipsWindow()){
                    mainFragment.hideDailyTipsWindow();
                    return;
                }
            }

            if(exit){
                super.onBackPressed();
            }else{
                Toast.makeText(this, "再次点击返回键退出", Toast.LENGTH_SHORT).show();
                exit = true;
                handler.sendEmptyMessageDelayed(0,3000);
            }
        }else{
            showPage(0);
        }

    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            exit = false;
        }
    };
}
