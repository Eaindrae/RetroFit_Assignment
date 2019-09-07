package com.padcmyanmar.padc9.home_rent_application.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padcmyanmar.padc9.home_rent_application.Adapters.RecyclerViewAdapter;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.activites.DetailsActivity;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModel;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModelImpl;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public  class Top_Collection_Fragment extends BaseFragment {


    private EventItemDelegate delegate;

    public Top_Collection_Fragment() { }

    @SuppressLint("ValidFragment")
    public Top_Collection_Fragment(EventItemDelegate delegate){
        this.delegate = delegate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view= inflater.inflate(R.layout.fragment_top__collection, container, false);
        delegate.onGetHotelItems(this, view);
        return view;
    }

}
