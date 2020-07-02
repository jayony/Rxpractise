package com.example.rxpractise.common.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.example.rxpractise.EventManager;
import com.example.rxpractise.ParctiseRXInte;
import com.example.rxpractise.R;
import com.example.rxpractise.event.EventPay;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;

public class BaseWebActivity extends Activity {

    private static final String TAG = "BaseWebActivity";
    public static final String WEB_VIEW = "WebView";
    public static final String BASE_PAY_URL = "https://dev.send2boox.com/bookPay.html";
    public static final int DELAY_MILLIS = 2000;
    public static final String JS_LISTENER = "startListener";

    protected WebView mWebView;

    protected String title;
    protected String url;

    private static final boolean enableProgressBar = false;
    private boolean canBack = false;

    String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzU4NDUsImlhdCI6MTU5MjIwNjE3NCwiZXhwIjoxNTk0Nzk4MTc0fQ.IuG62sR7mjV2JMXaYl5NAGH0qLZjnR6bSHp0Fx2qcxI";
    String language = "ch";
    String[] bookids;

    public ParctiseRXInte parctiseRXInte = new ParctiseRXInte();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palweb_activity);
        mWebView = findViewById(R.id.webview);

        initWebView();

        bookids = new String[]{"22"};
        String arrStr = Arrays.toString(bookids);
        LogUtils.d(WEB_VIEW, "" + arrStr);
        title = "Pay";
        url = BASE_PAY_URL;
        Uri.Builder uri = Uri.parse(url).buildUpon();
        uri.appendQueryParameter("books", Base64.encodeToString(arrStr.getBytes(), Base64.DEFAULT));

        uri.appendQueryParameter("language", Base64.encodeToString(language.getBytes(), Base64.DEFAULT));
        uri.appendQueryParameter("token", Base64.encodeToString(token.getBytes(), Base64.DEFAULT));

        url = uri.toString();
        LogUtils.d(WEB_VIEW, "url ：" + url);
        mWebView.loadUrl(url);
        EventManager.getInstance().getEvent().register(this);
    }

    private void initWebView() {
        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebSettings.setLoadsImagesAutomatically(true);

        mWebSettings.setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(webChromeClient);
        mWebView.setWebViewClient(webViewClient);
        mWebView.addJavascriptInterface(new JsInterFace(), JS_LISTENER);
    }

    WebViewClient webViewClient = new WebViewClient() {
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
        }
    };

    String order;

    public class JsInterFace {

        @JavascriptInterface
        public void startPlaySuccessListener(String orderId) {
            LogUtils.d("orderId:" + orderId);
            order = orderId;
            handler.sendEmptyMessage(1);
        }

    }
//    22680111bc4811ea9b6efb3dd4544117
//    22680111bc4811ea9b6efb3dd4544117
//    22680111bc4811ea9b6efb3dd4544117
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            LogUtils.d("支付状态轮询......");
            Toast.makeText(BaseWebActivity.this, "支付状态轮询......", Toast.LENGTH_LONG).show();
            if (!ispaysuccess) {
                parctiseRXInte.getOrderStatus(order);
                handler.sendEmptyMessageDelayed(1, DELAY_MILLIS);
            } else {
                Toast.makeText(BaseWebActivity.this, "支付成功,结束轮询", Toast.LENGTH_LONG).show();
                LogUtils.d("支付成功！");
            }

        }
    };

    boolean ispaysuccess = false;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPaySuccess(EventPay eventPay) {
        if (EventPay.SUCCESS == eventPay.status) {
            ispaysuccess = true;
        }
    }

}