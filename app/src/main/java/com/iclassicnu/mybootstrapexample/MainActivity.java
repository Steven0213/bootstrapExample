package com.iclassicnu.mybootstrapexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.myWebView);

        WebSettings webSettings = myWebView.getSettings();

        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebChromeClient(new WebChromeClient() {
                                         @Override
                                         public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                                             Log.v("DJK", consoleMessage.message() + " -- From line "
                                                     + consoleMessage.lineNumber() + " of "
                                                     + consoleMessage.sourceId());
                                             return super.onConsoleMessage(consoleMessage);
                                         }
                                     });

        myWebView.loadUrl("file:///android_asset/html_template.html");
        Log.v("DJK", "Works?");

    }
}
