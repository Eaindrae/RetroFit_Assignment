package com.padcmyanmar.padc9.home_rent_application.activites;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModel;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModelImpl;

public class BaseActivity extends AppCompatActivity {

    protected EventModelImpl mHotelModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHotelModel = EventModelImpl.getObjInstance();
    }

//    protected void showIndefiniteSnackBar(String message){
//        final Snackbar snackbar=Snackbar.make(getWindow().getDecorView(),message,Snackbar.LENGTH_INDEFINITE);
//        snackbar.setAction(getResources().getString(R.string.lbl_ok), new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                snackbar.dismiss();
//            }
//        });
//
//    }
}
