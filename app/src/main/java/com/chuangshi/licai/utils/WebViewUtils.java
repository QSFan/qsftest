package com.chuangshi.licai.utils;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2016/9/3.
 */
public class WebViewUtils {

    public WebViewUtils(WebView webview, String url) {
        WebSettings webSettings = webview.getSettings();
        //设置WebView属性，能够执行JavaScript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
//        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);//设置自适应屏幕


        //打开本包内asset目录下的index.html文件

        webview.loadUrl(url);
        //设置web视图
        webview.setWebViewClient(new WebViewClient());
    }

    public void SetWebView() {

    }

}
