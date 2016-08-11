package com.hackathon.exchange.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private static final String TAG = "TabFragmentAdapter";
    private ArrayList<Fragment> mArrayList;

    public TabFragmentAdapter(FragmentManager fm, ArrayList<Fragment> mArrayList) {
        super(fm);
        this.mArrayList = mArrayList;
    }

    public int getCount() {
        return mArrayList.size();
    }

    public Fragment getItem(int paramInt) {
        if ((mArrayList != null) && (mArrayList.size() > paramInt))
            return (Fragment) mArrayList.get(paramInt);
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
