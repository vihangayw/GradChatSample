package com.populo.gradchat.frags;

/**
 * Created by VYW on 10/22/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vyw.example.sample.R;

public class TabFragExplore extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_frag_explore, container, false);
    }
}