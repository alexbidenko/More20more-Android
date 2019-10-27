package ru.h1n.httpmy_crazy_project_more20more.more20more;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentService = new Intent(this, Seach_new_Datas.class);
        startService(intentService);

        webView = findViewById(R.id.more20more_web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new AppWebViewClient());

        webView.loadUrl("http://my-crazy-project-more20more.h1n.ru/index.php");
    }
}
