package com.padcmyanmar.padc9.home_rent_application.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolder extends BaseViewHolder<HotelVO> {

    private EventItemDelegate mEventItemDelegate;

    @BindView(R.id.img_3)
    ImageView imagehouse;

    @BindView(R.id.tv_1)
    MMTextView price;

    @BindView(R.id.img_4)
    ImageView imglocation;

    @BindView(R.id.tv_2)
    MMTextView textlocation;

    @BindView(R.id.img_5)
    ImageView imgSqft;

    @BindView(R.id.tv_3)
    MMTextView textSqft;

    @BindView(R.id.img_6)
    ImageView imgbed;

    @BindView(R.id.tv_4)
    MMTextView textbed;





    public RecyclerViewHolder(@NonNull View itemView, EventItemDelegate delegate) {
        super(itemView);
        this.mEventItemDelegate = delegate;


        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEventItemDelegate.onTap();
            }
        });
    }


    @Override
    public void bindData(HotelVO data) {
        price.setText(String.valueOf(data.getPrice()));
        textlocation.setText(data.getAddress());
        textSqft.setText(data.getSquare_feet());
        Glide.with(itemView.getContext())
                .load(data.getHouseimageurl())
                .into(imagehouse);
    }
    }

