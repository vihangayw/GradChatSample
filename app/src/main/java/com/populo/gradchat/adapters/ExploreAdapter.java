package com.populo.gradchat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vyw.example.sample.R;

/**
 * Created by VYW on 10/23/2016.
 */
public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    @Override
    public ExploreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.card_explore, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ExploreAdapter.ViewHolder viewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private Context mContext;

    public ExploreAdapter(Context context) {
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView nameTextView;
//        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
//            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            imageView = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }

}