package com.mf4z.fulfulde;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    final int PAGE_COUNT = 4;

    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new FamilyMembersFragment();
        } else if (position == 2){
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.familyM);
        } else if (position == 2) {
            return mContext.getString(R.string.colors);
        } else {
            return mContext.getString(R.string.phrases);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
