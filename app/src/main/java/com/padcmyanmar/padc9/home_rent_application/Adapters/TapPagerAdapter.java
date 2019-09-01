package com.padcmyanmar.padc9.home_rent_application.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.padcmyanmar.padc9.home_rent_application.fragments.Top_Collection;

public class TapPagerAdapter extends FragmentStatePagerAdapter {

    public TapPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Top_Collection();
        }else
            return new Top_Collection();

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Top Collection";
        }else
            return "Near Me";

    }
}
