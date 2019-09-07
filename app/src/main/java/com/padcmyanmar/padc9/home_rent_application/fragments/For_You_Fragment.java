package com.padcmyanmar.padc9.home_rent_application.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.padcmyanmar.padc9.home_rent_application.Adapters.ForYouFragmentPagerAdapter;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.Delegate.ForYouFragmentDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;

public class For_You_Fragment extends BaseFragment {
    private EventItemDelegate mHouseItemDelegate;
    private ForYouFragmentDelegate mForYouFragmentDelegate;

    public For_You_Fragment(){}

    @SuppressLint("ValidFragment")
    public For_You_Fragment(EventItemDelegate mHouseItemDelegate, ForYouFragmentDelegate mForYouFragmentDelegate){
        this.mHouseItemDelegate = mHouseItemDelegate;
        this.mForYouFragmentDelegate = mForYouFragmentDelegate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.for_you_main_layout, container, false);

        //ButterKnife.bind(this, container);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ForYouFragmentPagerAdapter pagerAdapter = new ForYouFragmentPagerAdapter(getFragmentManager(), mHouseItemDelegate);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        final EditText textSearch = view.findViewById(R.id.et_location);

        ImageView imgSearch = view.findViewById(R.id.ic_search);
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchWord = textSearch.getText().toString();
                mForYouFragmentDelegate.onSearchFilter(searchWord);
            }
        });

        ImageView imgLinearly = view.findViewById(R.id.ic_linearly);
        imgLinearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mForYouFragmentDelegate.onTabListView();
            }
        });

        ImageView imgGrid = view.findViewById(R.id.ic_grid);
        imgGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mForYouFragmentDelegate.onTabGridView();
            }
        });

        return view;
    }
}
