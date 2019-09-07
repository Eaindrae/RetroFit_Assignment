package com.padcmyanmar.padc9.home_rent_application.Delegate;

import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.padcmyanmar.padc9.home_rent_application.fragments.Top_Collection_Fragment;

public interface EventItemDelegate {
    void onTap(int eventId);
    void onGetHotelItems(Top_Collection_Fragment context, View view);
    void onTabLocation(LatLng latLng);
}
