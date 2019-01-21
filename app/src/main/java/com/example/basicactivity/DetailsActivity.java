package com.example.basicactivity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class DetailsActivity extends AppCompatActivity {


    WebView webview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        progressBar = findViewById(R.id.progressBar);

        webview = findViewById(R.id.webview);
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //dont get use external browser
        webview.setWebViewClient(new WebViewClient());

        //Improve Webview Performance
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.setWebViewClient(new WebViewpageLoaderClient());
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        if (getIntent().hasExtra("home_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("home_key"));
        }
        else if (getIntent().hasExtra("national_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("national_key"));
        }
        else if (getIntent().hasExtra("politics_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("politics_key"));
        }
        else if (getIntent().hasExtra("economics_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("economics_key"));
        }
        else if (getIntent().hasExtra("sports_key")) {
            webview.loadUrl(getIntent().getExtras().getString("sports_key"));
        }
        else if (getIntent().hasExtra("capital_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("capital_key"));
        }
        else if (getIntent().hasExtra("law_url"))
        {
            webview.loadUrl(getIntent().getExtras().getString("law_url"));
        }
        else if (getIntent().hasExtra("science_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("science_key"));
        }
        else if (getIntent().hasExtra("entertainment_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("entertainment_key"));
        }
        else if (getIntent().hasExtra("international_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("international_key"));
        }
        else if (getIntent().hasExtra("akslip_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("akslip_key"));
        }
        else if (getIntent().hasExtra("country_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("country_key"));
        }
        else if (getIntent().hasExtra("education_key"))
        {
            webview.loadUrl(getIntent().getExtras().getString("education_key"));
        }
        else if (getIntent().hasExtra("media_key")){
            webview.loadUrl(getIntent().getExtras().getString("media_key"));
        }
        else if (getIntent().hasExtra("health_key")){
            webview.loadUrl(getIntent().getExtras().getString("health_key"));
        }
        else if (getIntent().hasExtra("football_key")){
            webview.loadUrl(getIntent().getExtras().getString("football_key"));
        }
        else if (getIntent().hasExtra("corporate_key")){
            webview.loadUrl(getIntent().getExtras().getString("corporate_key"));
        }



    }

    private class WebViewpageLoaderClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
