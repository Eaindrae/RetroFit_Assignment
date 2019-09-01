package com.padcmyanmar.padc9.home_rent_application.activites;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.padcmyanmar.padc9.home_rent_application.Adapters.RecyclerViewAdapter;
import com.padcmyanmar.padc9.home_rent_application.Adapters.TapPagerAdapter;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModel;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActiviy implements EventItemDelegate {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        ViewPager viewPager=findViewById(R.id.viewPager);

        TapPagerAdapter tapPagerAdapter=new TapPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tapPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



//        eventModel.getEvents(new EventModel.GetEventsFromDatalayerDelegate(){
//            @Override
//            public void onSuccess(List<HotelVO> events) {
//                adapter.setNewData(events);
//            }
//
//            @Override
//            public void onFailure(String errorMessage) {
//                showIndefiniteSnackBar(errorMessage);
//            }
//        });
    }

    @Override
    public void onTap() {
        startActivity(DetailsActivity.newIntent(MainActivity.this));
    }
}
