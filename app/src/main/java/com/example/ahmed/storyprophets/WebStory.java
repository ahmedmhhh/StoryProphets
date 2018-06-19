package com.example.ahmed.storyprophets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_story);

        WebView webView = (WebView) findViewById(R.id.webview);

        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        webView.loadUrl("file:///android_asset/html/"+page+".html");
    }
}
