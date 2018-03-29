package com.anthonyl.newscentral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_webview);

        WebView webview = new WebView(this);
        setContentView(webview);

        Intent intent = getIntent();
        webview.loadUrl(intent.getStringExtra("URL"));
    }

}
