package com.padcmyanmar.padc9.home_rent_application.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.padcmyanmar.padc9.home_rent_application.R;

import butterknife.BindView;
import butterknife.ButterKnife;
public class DetailsActivity extends BaseActiviy{

    public static Intent newIntent(Context context){
        return new Intent(context,DetailsActivity.class);
    }

//    @BindView(R.id.img_btn_1)
//    ImageView imgBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
//
//        imgBackBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DetailsActivity.super.onBackPressed();
//            }
//        });
    }
}
