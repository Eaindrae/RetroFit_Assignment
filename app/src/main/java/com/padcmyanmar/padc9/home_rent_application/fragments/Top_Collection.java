package com.padcmyanmar.padc9.home_rent_application.fragments;

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


public class Top_Collection extends Fragment implements EventItemDelegate {


    public Top_Collection() {
        // Required empty public constructor
    }
    public static Top_Collection newInstance() {

        Bundle args = new Bundle();

        Top_Collection fragment = new Top_Collection();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top__collection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView=view.findViewById(R.id.recylerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        final RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        EventModelImpl.getObjInstance().getEvents(new EventModel.GetEventsFromDatalayerDelegate(){
            @Override
            public void onSuccess(List<HotelVO> events) {
                Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(String errorMesage) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onTap() {
        Intent intent=new Intent(getContext(), DetailsActivity.class);
        startActivity(intent);
    }
}
