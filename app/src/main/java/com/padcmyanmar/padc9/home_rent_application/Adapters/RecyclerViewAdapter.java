package com.padcmyanmar.padc9.home_rent_application.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.ViewHolders.RecyclerViewHolder;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

public class RecyclerViewAdapter extends BaseRecyclerViewAdapter<RecyclerViewHolder, HotelVO> {

    private EventItemDelegate mEventItemDelegate;

    public RecyclerViewAdapter(EventItemDelegate meventItemDelegate) {
        this.mEventItemDelegate = meventItemDelegate;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view1,parent,false);
        return new RecyclerViewHolder(itemview,mEventItemDelegate);
    }


}
