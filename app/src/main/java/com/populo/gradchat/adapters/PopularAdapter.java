package com.populo.gradchat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import vyw.example.sample.R;

/**
 * Created by VYW on 10/23/2016.
 */
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.card_popular, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PopularAdapter.ViewHolder viewHolder, int position) {

        WebView webView = viewHolder.webView;
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.youtube.com/watch?v=OFfJwXpRTgM");

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private Context mContext;

    public PopularAdapter(Context context) {
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public WebView webView;

        public ViewHolder(View itemView) {
            super(itemView);
            webView = (WebView) itemView.findViewById(R.id.webViews);
        }
    }

}