package com.padcmyanmar.padc9.home_rent_application.activites;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.padcmyanmar.padc9.home_rent_application.Adapters.RecyclerViewAdapter;
import com.padcmyanmar.padc9.home_rent_application.Adapters.TapPagerAdapter;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.Delegate.ForYouFragmentDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModel;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;
import com.padcmyanmar.padc9.home_rent_application.fragments.For_You_Fragment;
import com.padcmyanmar.padc9.home_rent_application.fragments.Top_Collection_Fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements EventItemDelegate, ForYouFragmentDelegate, LocationListener {

    BottomNavigationView bottomNavView;
    LocationManager mLocationManager;
    LatLng mCurrentLocation;

    private static boolean isGridView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        bottomNavView = findViewById(R.id.bottomNavigationView);
        setOnNavigationItemSelectedListener();

    }
    private void loadForYouFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, new For_You_Fragment(this,this))
                .addToBackStack(null)
                .commit();
    }
    private void setOnNavigationItemSelectedListener() {
        //set initial view.
        int id = bottomNavView.getSelectedItemId();
        switch (id) {
            case R.id.action_for_you:
                loadForYouFragment();
                break;
            case R.id.action_find_me:
                //loadSearchFragment();
                break;
            case R.id.action_favourite:
                //Event
                break;
            case R.id.action_browse:
                //Action
                break;
            case R.id.action_profile:
                break;
            /*case R.id.action_more :
                break;*/
        }
        //listen and set selected view.
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.action_for_you:
                        loadForYouFragment();
                        break;
                    case R.id.action_find_me:
                        //loadSearchFragment();
                        break;
                    case R.id.action_favourite:
                        //Event
                        break;
                    case R.id.action_browse:
                        //Action
                        break;
                    case R.id.action_profile:
                        break;
                    /*case R.id.action_more :
                        break;*/
                }
                return true;
            }
        });
    }

    @Override
    public void onTap(int eventId) {
        startActivity(DetailsActivity.newIntent(getApplicationContext(),eventId));
    }

    @Override
    public void onGetHotelItems(final Top_Collection_Fragment context, View view) {
        final RecyclerView recyclerView = view.findViewById(R.id.recylerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);


//        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//
////        } else
//            {
//            mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
//        }

        mHotelModel.getEvents(new EventModel.GetEventsFromDatalayerDelegate(){
            @Override
            public void onSuccess(List<HotelVO> houseInfoVOS) {
                adapter.setNewData(houseInfoVOS);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(String message) {
             context.showSnackBar(message);
            }
        });
    }

    @Override
    public void onTabLocation(LatLng latLng) {
        Intent intent = intentGoogleMap(mCurrentLocation,latLng);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Toast.makeText(this, "Google Map not support!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onSearchFilter(String searchWord) {
        List<HotelVO> resultList = mHotelModel.findHouseByName(searchWord);
        if(isGridView){
            showAsGrid(resultList);
        } else {
            showAsList(resultList);
        }
    }

    @Override
    public void onTabGridView() {
        isGridView=true;
        List<HotelVO> houseInfoVOList = mHotelModel.getDataRepository();
        showAsGrid(houseInfoVOList);
    }

    @Override
    public void onTabListView() {
        isGridView=false;
        List<HotelVO> houseInfoVOList = mHotelModel.getDataRepository();
        showAsList(houseInfoVOList);
    }
    private void showAsGrid(List<HotelVO> houseInfoVOList){
        RecyclerView recyclerView = findViewById(R.id.recylerview1);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        adapter.setNewData(houseInfoVOList);
        recyclerView.setAdapter(adapter);
    }

    private void showAsList(List<HotelVO> houseInfoVOList){
        RecyclerView recyclerView = findViewById(R.id.recylerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        adapter.setNewData(houseInfoVOList);
        recyclerView.setAdapter(adapter);
    }
    private static Intent intentGoogleMap(LatLng curPos, LatLng destPos){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr="+curPos.latitude+","+curPos.longitude+"&daddr="+destPos.latitude+","+destPos.longitude));
        return intent;
    }
}
