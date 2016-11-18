package com.bwf.lgqingdan.gui.widget;


import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Administrator on 2016/11/1.
 */

public abstract class QingdanWebviewClient
        extends WebViewClient {
    public abstract void onArticleLinkClicked(int paramInt);

    public abstract void onGeneralLinkClicked(String paramString);

    public void onLoadResource(WebView paramWebView, String paramString) {}

    public abstract void onThingLinkClicked(int paramInt);

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        Matcher matcher = Pattern.compile("^http(s)?://(beta|api|www|m)\\.eqingdan.com(/mobile)?/articles/(\\d+)(/.*)?$").matcher(paramString);
        Matcher localMatcher = Pattern.compile("^http(s)?://(beta|api|www|m)\\.eqingdan.com(/mobile)?/things/(\\d+)(/.*)?$").matcher(paramString);
        if (matcher.matches()) {
            onArticleLinkClicked(Integer.valueOf(matcher.group(4)).intValue());
            return true;
        }
        if (localMatcher.matches()) {
            onThingLinkClicked(Integer.valueOf(localMatcher.group(4)).intValue());
        } else {
            onGeneralLinkClicked(paramString);
        }
        return true;
    }
}
