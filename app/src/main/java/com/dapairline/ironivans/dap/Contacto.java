package com.dapairline.ironivans.dap;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contacto extends AppCompatActivity {

    String ShowOrHideWebViewInitialUse = "show";
    private WebView wv;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            /*final WebView myWebView = (WebView) findViewById(R.id.webCheckin);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                ProgressBar progress = (ProgressBar) findViewById(R.id.progressCheckin);
                progress.setVisibility(View.GONE);
                myWebView.setVisibility(View.VISIBLE);
            }
        }, 3000);

        Bundle bundle = getIntent().getExtras();

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://" + bundle.getString("url"));
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        /*myWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {

                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });*/


        wv = (WebView) findViewById(R.id.webContacto);

        Handler handlerProgress = new Handler();
        handlerProgress.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                ProgressBar progress = (ProgressBar) findViewById(R.id.progressContacto);
                progress.setVisibility(View.GONE);
                wv.setVisibility(View.VISIBLE);
            }
        }, 3000);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                ProgressBar progress = (ProgressBar) findViewById(R.id.progressContacto);
                progress.setVisibility(View.GONE);
                wv.setVisibility(View.VISIBLE);
            }
        }, 3000);


        // PORDUCCION-------> wv.loadUrl("https://wc2-v5.kiusys.net/");
        wv.loadUrl("https://dapairline.com/apps/android/index.php");
        wv.setWebViewClient(new Contacto.MyClient());
        wv.setWebChromeClient(new Contacto.GoogleClient());
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv.clearCache(true);
        wv.clearHistory();
        wv.setDownloadListener(new DownloadListener()
        {

            @Override


            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimeType,
                                        long contentLength) {

                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));


                request.setMimeType(mimeType);


                String cookies = CookieManager.getInstance().getCookie(url);


                request.addRequestHeader("cookie", cookies);


                request.addRequestHeader("User-Agent", userAgent);


                request.setDescription("Downloading file...");


                request.setTitle(URLUtil.guessFileName(url, contentDisposition,
                        mimeType));


                request.allowScanningByMediaScanner();



                //--------------------
                /*File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "Dap");

                if (!mediaStorageDir.exists()) {
                    if (!mediaStorageDir.mkdirs()) {
                        Log.d("App", "failed to create directory");
                    }
                }*/
                //----------------


                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                //request.setDestinationInExternalFilesDir(Checkin.this,
                //      Environment.getExternalStorageDirectory().getName(),".pdf");
                //------------AGREGAR FGECHA Y HORA-----------------
                Date date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
                String fecha = hourdateFormat.format(date);
                //---------------------------------------------------


                request.setDestinationInExternalFilesDir(Contacto.this,
                        Environment.getExternalStoragePublicDirectory("Boarding").getName(),"Boarding "+fecha+".pdf");


                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.checkInDescargando),
                        Toast.LENGTH_LONG).show();
            }});


        wv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("http://cbseacademic.in/SQP_CLASSXII_2016_17.html");
            }
        });


    }

    class MyClient extends WebViewClient
    {

        @Override
        public void onPageStarted(WebView view,String url,Bitmap favicon){
            super.onPageStarted(view,url,favicon);

        }
        /*@Override
        public boolean shouldOverrideUrlLoading(WebView view,String Url)
        {
            view.loadUrl(Url);
            return true;

        }*/
        @Override
        public void onPageFinished(WebView view,String url)
        {
            super.onPageFinished(view,url);

        }
    }
    class GoogleClient extends WebChromeClient
    {
        @Override
        public void onProgressChanged(WebView view,int newProgress)
        {
            super.onProgressChanged(view,newProgress);

        }
    }
    @Override
    public void onBackPressed() {
        if (wv.canGoBack())
            wv.goBack();
        else
            super.onBackPressed();

    }

}
