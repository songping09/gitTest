package com.bwf.lgqingdan.gui.widget;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by LG on 2016/10/21.
 * Tips:控制FloatingActionButton的显示和隐藏
 */
public class FloatButtonOnRecycleView implements View.OnClickListener {
    private int showForPosition = 8;
    private int maxSmoothScrollPosition = 12;
    private FloatingActionButton floatView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    public FloatButtonOnRecycleView(FloatingActionButton floatView, RecyclerView recyclerView) {
        this.floatView = floatView;
        this.floatView.setOnClickListener(this);
        this.recyclerView = recyclerView;
        layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    }
     public void init(){
         recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
             @Override
             public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                 super.onScrolled(recyclerView, dx, dy);
                 Log.d("FloatButtonOnRecycleVie", "dy:" + dy);
                 if(layoutManager.findFirstVisibleItemPosition() < 1 && floatView.getVisibility() == View.VISIBLE){
                     floatView.hide();
                     return;
                 }
                 if(dy > 0 && floatView.getVisibility() == View.VISIBLE){
                     floatView.hide();
                 }else if(dy < 0 && floatView.getVisibility() != View.VISIBLE){
                     floatView.show();
                 }
             }
         });
     }

    @Override
    public void onClick(View v) {
//        if(layoutManager.findLastVisibleItemPosition() <= maxSmoothScrollPosition){
//            layoutManager.smoothScrollToPosition(recyclerView,null,0);
//
//        }else{
            layoutManager.scrollToPosition(0);
//        }
        floatView.hide();
    }
}
