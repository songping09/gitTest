package com.bwf.lgqingdan.gui.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 */

public class ThingDescribeActivity extends ActivityBase {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.webview)
    WebView webview;
    public static final String HTML_STRING = "html_string";
    public static final String HTML_URL = "html_url";
    String htmlString;
    String htmlUrl;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_thing_describe;
    }
    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText(getString(R.string.thing_describe));
        root.setPadding(0, getStatusHeight(), 0, 0);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                webview.loadUrl(htmlUrl);
            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress >= 10){
                    refreshLayout.finishRefresh();

                }
            }
        });
        htmlUrl = getIntent().getStringExtra(HTML_URL);
        webview.loadUrl(htmlUrl);
    }

    @Override
    protected void initDatas() {
//        htmlString = getIntent().getStringExtra(HTML_STRING);
//        String htmlBase = IO.readAssetsFile(this,"thing_describe.html");
//        htmlString = htmlBase.replace("{content}",htmlString);
//        Toast.makeText(this, htmlString, Toast.LENGTH_SHORT).show();
//        webview.getSettings().setTextSize(WebSettings.TextSize.SMALLER);
//        webview.loadData(htmlString, "text/html; charset=UTF-8", null);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.back)
    public void onClick() {
        finish();
    }
}
