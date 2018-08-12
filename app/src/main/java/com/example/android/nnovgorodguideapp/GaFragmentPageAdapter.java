package com.example.android.nnovgorodguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GaFragmentPageAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int tabTitles[] = new int[]{R.string.cultural_sites, R.string.museums,
            R.string.nature_and_parks, R.string.concerts_and_performances};

    public GaFragmentPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CulturalSitesFragment();
        } else if (position == 1) {
            return new MuseunsFragment();
        } else if (position == 2) {
            return new NatureAndParksFragment();
        } else {
            return new ConcertsAndPerformancesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(tabTitles[position]);
    }
}
