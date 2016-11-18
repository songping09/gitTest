package com.bwf.lgqingdan.gui.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.lgqingdan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/14.
 */

public class BuyActivity extends ActivityBase {
    @BindView(R.id.webview)
    WebView webview;
    public static final String URL = "url";
    private String url;
    @Override
    public int getContentViewResID() {
        return R.layout.activity_buy;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected void initDatas() {
        url = getIntent().getStringExtra(URL);
        webview.loadUrl(url);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
