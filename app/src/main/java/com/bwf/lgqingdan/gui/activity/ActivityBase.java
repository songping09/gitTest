package com.bwf.lgqingdan.gui.activity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by LG on 2016/10/14.
 * Tips:
 */

public abstract class ActivityBase extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        setStatusBarTransparent();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getContentViewResID());
        initViews();
        initDatas();

    }


    public abstract int getContentViewResID();
    public void setStatusBarTransparent(){
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }else if(Build.VERSION.SDK_INT >= 19){
//            getWindow().getDecorView().setSystemUiVisibility(1280);
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 设置状态栏透明
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 设置根布局的参数
//            ViewGroup rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
//            rootView.setFitsSystemWindows(true);
//            rootView.setClipToPadding(true);
//        }
    }
    protected abstract void initViews();
    protected abstract void initDatas();
    /**
     * 不用强转的findviewbyid
     */
    public <T extends View> T findViewByIdNoCast(int id) {
        return (T) super.findViewById(id);
    }
    /**
     * dip转像素
     */
    public  int dip2px(float dpValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    /**
     * 像素转dip
     */
    public  int px2dip(float pxValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }
    /**
     * 判断是否有网络
     */
    public boolean isNetWork() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager != null
                && connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isAvailable();
    }

    public void setMargins(View view, int left, int top, int right, int bottom) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) params;
            layoutParams.setMargins(
                    left == -1 ? layoutParams.leftMargin:left,
                    top == -1 ? layoutParams.topMargin:top,
                    right == -1 ? layoutParams.rightMargin:right,
                    bottom == -1 ? layoutParams.bottomMargin:bottom
            );
            view.requestLayout();
        }
    }
    /**
     * 获取状态栏高度
     */
    public int getStatusHeight() {
        final Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int n = rect.top;
        if (n != 0) {
            return n;
        }
        try {
            final Class<?> forName = Class.forName("com.android.internal.R$dimen");
            n = getResources().getDimensionPixelSize(Integer.parseInt(forName.getField("status_bar_height").get(forName.newInstance()).toString()));
            return n;
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return n;
        }catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
            return n;
        }catch (InstantiationException ex3) {
            ex3.printStackTrace();
            return n;
        }catch (NumberFormatException ex4) {
            ex4.printStackTrace();
            return n;
        }catch (IllegalArgumentException ex5) {
            ex5.printStackTrace();
            return n;
        }catch (SecurityException ex6) {
            ex6.printStackTrace();
            return n;
        }catch (NoSuchFieldException ex7) {
            ex7.printStackTrace();
            return n;
        }
    }

    protected void setFullScreen(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
