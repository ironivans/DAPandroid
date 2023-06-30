package com.dapairline.ironivans.dap;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Venta extends AppCompatActivity {
    String ShowOrHideWebViewInitialUse = "show";
    private WebView webview;
    private ProgressBar spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final WebView myWebView = (WebView) findViewById(R.id.webVenta);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                ProgressBar progress = (ProgressBar) findViewById(R.id.progressVenta);
                progress.setVisibility(View.GONE);
                myWebView.setVisibility(View.VISIBLE);
            }
        }, 8000);
/*
        dato=getIntent().getExtras();
        String url =dato.getString("url");

        url="www.facebook.com";
*/
        Bundle bundle = getIntent().getExtras();

        WebSettings webSettings = myWebView.getSettings();
        //CACHE
        myWebView.getSettings().setAppCacheEnabled(false);
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //FIN CACHE
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://" + bundle.getString("url"));
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new WebChromeClient() {


            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog,
                                          boolean isUserGesture, Message resultMsg) {


                WebView newWebView = new WebView(Venta.this);
                newWebView.getSettings().setJavaScriptEnabled(true);
                newWebView.getSettings().setSupportZoom(true);
                newWebView.getSettings().setBuiltInZoomControls(true);
                newWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
                newWebView.getSettings().setSupportMultipleWindows(true);
                view.addView(newWebView);
                WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                transport.setWebView(newWebView);
                resultMsg.sendToTarget();

                newWebView.setWebViewClient(new WebViewClient() {

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });

                return true;
            }


        });

    }

// This allows for a splash screen
// (and hide elements once the page loads)
   /* public algo() {







            ShowOrHideWebViewInitialUse = "hide";
            spinner.setVisibility(View.GONE);

            //view.setVisibility(webview.VISIBLE);



    }*/

}