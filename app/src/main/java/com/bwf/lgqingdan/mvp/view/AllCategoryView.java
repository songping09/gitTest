package com.bwf.lgqingdan.mvp.view;

import com.bwf.lgqingdan.entity.ResponseAllCategory;

/**
 * Created by LG on 2016/11/11.
 * Tips:
 */

public interface AllCategoryView {
    void showLoadingView();
    void hideLoadingView();
    void showFailedView();
    void showCategorys(ResponseAllCategory responseAllCategory);
}
