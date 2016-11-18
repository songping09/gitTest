package com.bwf.lgqingdan.gui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.bwf.lgqingdan.R;
import com.bwf.lgqingdan.utils.SPUtils;


/**
 * Created by LG on 2016/10/10.
 * Tips:欢迎界面
 */
public class WelcomeActivity extends ActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isCancle){
                    return;
                }
                if(isFirstRun()){
//                    gotoSplash();
                    gotoMain();
                }else{
                    gotoMain();
                }
            }
        }.start();
    }


    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public int getContentViewResID() {
        return R.layout.activity_welcome;
    }

    /**
     *跳转到引导界面
     */
    private void gotoSplash(){
        startActivity(new Intent(this,SplashActivity.class));
        finish();
    }

    /**
     * 跳转到主界面
     */
    private void gotoMain(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    /**
     * 判断应用是否是第一次运行
     * @return
     */
    private boolean isFirstRun(){
        boolean isFirst = (boolean) SPUtils.get(this,"version_first_run_guide",true);
        if(isFirst){
            SPUtils.put(this,"version_first_run_guide",false);
        }
        return isFirst;
    }
    private boolean isCancle;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isCancle = true;
    }
}
