package com.populo.gradchat.adapters;

/**
 * Created by VYW on 10/22/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.populo.gradchat.frags.TabFragExplore;
import com.populo.gradchat.frags.TabFragPopular;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragPopular tab1 = new TabFragPopular();
                return tab1;
            case 1:
                TabFragExplore tab2 = new TabFragExplore();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}