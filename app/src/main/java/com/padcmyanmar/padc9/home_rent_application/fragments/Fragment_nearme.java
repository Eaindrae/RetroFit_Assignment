package com.padcmyanmar.padc9.home_rent_application.fragments;

import android.content.Context;
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

import com.padcmyanmar.padc9.home_rent_application.Adapters.RecyclerViewAdapter;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.activites.DetailsActivity;


public class Fragment_nearme extends Fragment implements EventItemDelegate {





    public Fragment_nearme() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment_nearme newInstance(String param1, String param2) {
        Fragment_nearme fragment = new Fragment_nearme();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_nearme, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvEvents = view.findViewById(R.id.recylerview1);
        rvEvents.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        rvEvents.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public void onTap() {
        startActivity(new Intent(this.getContext(), DetailsActivity.class));
    }

}
