package com.example.rxpractise.common.view;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;


/**
 * @ClassName: BaseWebActivity
 * @Desciption: webview基础activity
 * @author: jesse_android
 * @date: 2018-05-10
 */
public class BaseWebActivity extends Activity implements View.OnClickListener {
 
    private static final String TAG = "BaseWebActivity";
 
    protected WebView mWebView;
 
    protected String title;
    protected String url;
 
    private static final boolean enableProgressBar = false;
    private boolean canBack = false;
 
 
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        initWebView();
 
        title = getIntent().getStringExtra("title");
        if(!TextUtils.isEmpty(title)){
        }
        url = getIntent().getStringExtra("url");
        Log.i(TAG,"url=" + url);
 
        mWebView.loadUrl(url);
    }

 
    private void initWebView() {
        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setSupportZoom(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebSettings.setLoadsImagesAutomatically(true);
 
        //调用JS方法.安卓版本大于17,加上注解 @JavascriptInterface
        mWebSettings.setJavaScriptEnabled(true);
 
        mWebView.setWebChromeClient(webChromeClient);
        mWebView.setWebViewClient(webViewClient);
    }
 
    WebViewClient webViewClient = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
 
    };
 
    WebChromeClient webChromeClient = new WebChromeClient() {
 
        @Override
        public void onProgressChanged(WebView webView, int newProgress) {
            super.onProgressChanged(webView, newProgress);
 
            if(enableProgressBar){
                if(newProgress == 100){
                } else{
                }
            }
 
        }
    };
 

 
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            goBack();
            return true;
        }
 
        return super.onKeyDown(keyCode, event);
    }
 
    @Override
    public void onClick(View v) {

    }
 
    private void goBack() {
        if(canBack){
            if(mWebView.canGoBack()){
                mWebView.goBack();
            }else {
            }
        }else {
        }
 
    }
 
    public boolean isCanBack() {
        return canBack;
    }
 
    public void setCanBack(boolean canBack1){
        canBack = canBack1;
    }
}