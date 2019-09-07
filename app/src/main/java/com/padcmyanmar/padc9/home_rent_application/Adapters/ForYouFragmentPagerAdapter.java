package com.padcmyanmar.padc9.home_rent_application.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.fragments.Top_Collection_Fragment;

public class ForYouFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private EventItemDelegate delegate;

    public ForYouFragmentPagerAdapter(FragmentManager fm,EventItemDelegate delegate) {
        super(fm);
        this.delegate = delegate;
    }

    @Override
    public Fragment getItem(int item) {
        switch (item){
            case 0 : return new Top_Collection_Fragment(delegate);
            case 1 : return new Top_Collection_Fragment(delegate);
            case 2 : return new Top_Collection_Fragment(delegate);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Top Collection";
            case 1 : return "Near me";
            case 2 : return "Low to high price";
        }
        return null;
    }
}
