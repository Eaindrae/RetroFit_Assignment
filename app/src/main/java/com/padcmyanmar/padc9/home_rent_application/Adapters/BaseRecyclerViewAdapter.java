package com.padcmyanmar.padc9.home_rent_application.Adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.padcmyanmar.padc9.home_rent_application.ViewHolders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter <T extends BaseViewHolder<W>,W> extends RecyclerView.Adapter<T>{
    private List<W> mData;

    public BaseRecyclerViewAdapter() {
        mData=new ArrayList<>();
    }



    @Override
    public void onBindViewHolder(@NonNull T viewholder, int position) {
        viewholder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W>data){
        mData=data;
        notifyDataSetChanged();
    }
}
