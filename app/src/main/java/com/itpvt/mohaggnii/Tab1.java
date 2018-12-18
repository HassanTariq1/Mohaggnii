package com.itpvt.mohaggnii;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
// * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
ProgressBar progressBar;
    private final static String TAG_FRAGMENT = "TAG_FRAGMENT";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=           inflater.inflate(R.layout.fragment_tab1, container, false);
       // getFragmentManager().beginTransaction().replace(R.id.fragment_frame, new Tab1()).addToBackStack(null).commit();

//        FragmentTransaction tx = fragmentManager.beginTransation();
//        tx.replace( R.id.fragment, new MyFragment() ).addToBackStack( "tag" ).commit();
//        fragment.getView().setFocusableInTouchMode(true);
//        fragment.getView().requestFocus();
//        fragment.getView().setOnKeyListener( new OnKeyListener()
//        {
//
//        } );

        WebView web1= (WebView)v.findViewById(R.id.webv1);
        progressBar = (ProgressBar)v.findViewById(R.id.pro1);
        web1.getSettings().setJavaScriptEnabled(true);
        web1.setWebViewClient(new WebViewClient(){

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



        web1.loadUrl("http://mohagni.com/index.php");
        return v;



    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
//    private void showFragment() {
//        final Myfragment fragment = new MyFragment();
//        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment, fragment, TAG_FRAGMENT);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
//
//    @Override
//    public void onBackPressed() {
//        final Myfragment fragment = (Myfragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);
//
//        if (fragment.allowBackPressed()) { // and then you define a method allowBackPressed with the logic to allow back pressed or not
//            super.onBackPressed();
//        }
//    }


}

