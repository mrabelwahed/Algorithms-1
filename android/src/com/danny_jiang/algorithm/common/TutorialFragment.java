package com.danny_jiang.algorithm.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.danny_jiang.algorithm.R;

public abstract class TutorialFragment extends Fragment {
    private static final String TAG = TutorialFragment.class.getSimpleName();

    protected WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bubble_sort_tutorial_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpWebView(view);
    }

    private void setUpWebView(View view) {
        webView = ((WebView) view.findViewById(R.id.bubble_sort_tutorial_webview));
        WebSettings webSettings = webView.getSettings();
        //允许webview对文件的操作
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        //用于js调用Android
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        //不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false);
        //设置编码方式
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.setWebChromeClient(new WebChromeClient());

        // 自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        loadUrl();
    }

    public abstract void loadUrl();
}
