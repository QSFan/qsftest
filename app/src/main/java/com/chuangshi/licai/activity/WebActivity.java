package com.chuangshi.licai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chuangshi.licai.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

//    private ImageView iv_go_back;
    private WebView webview;
    private String url;
//    private String title;
//    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
//        title = intent.getStringExtra("title");

        initView();
        initData();
    }

    private void initView() {
//        iv_go_back = (ImageView) findViewById(R.id.iv_go_back);
        webview = (WebView) findViewById(R.id.webview);
//        tv_title = (TextView) findViewById(R.id.tv_title);
//        iv_go_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.iv_go_back:
//                finish();
//                break;
        }
    }


    private void initData() {
//        if (title.length() > 8) {
//
//            tv_title.setText(title.substring(0, 7) + "...");
//        } else {
//            tv_title.setText(title);
//
//        }


        WebSettings webSettings = webview.getSettings();
        //设置WebView属性，能够执行JavaScript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);//设置自适应屏幕


        //打开本包内asset目录下的index.html文件//[a-zA-z]+://[^\s]*
        String reg = "[a-zA-z]+://[^\\s]*";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(url);
        boolean b = matcher.matches();
        if (b) {
            webview.loadUrl(url);
        } else {
            webview.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
        }
        //设置web视图
        webview.setWebViewClient(new WebViewClient());
    }

}
