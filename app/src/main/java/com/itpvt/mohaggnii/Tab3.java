package com.itpvt.mohaggnii;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Tab3 extends Fragment {
    ProgressBar progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=           inflater.inflate(R.layout.fragment_tab1, container, false);
        //getFragmentManager().beginTransaction().replace(R.id.fragment_frameee, new Tab3()).addToBackStack(null).commit();
        WebView web3= (WebView)v.findViewById(R.id.webv1);
        progressBar = (ProgressBar)v.findViewById(R.id.pro1);
        web3.getSettings().setJavaScriptEnabled(true);
        web3.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                    tvNoInternet.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                    tvNoInternet.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);

            }
        });



        web3.loadUrl("http://mohagni.com/index.php/sale.html");

        return v;


    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
