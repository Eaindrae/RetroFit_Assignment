package com.padcmyanmar.padc9.home_rent_application.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.padcmyanmar.padc9.home_rent_application.Delegate.EventItemDelegate;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

import org.mmtextview.components.MMTextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolder extends BaseViewHolder<HotelVO> {

    private EventItemDelegate mEventItemDelegate;

    @BindView(R.id.img_house)
    ImageView imagehouse;

    @BindView(R.id.lbl_price)
    Chip price;


    @BindView(R.id.tv_2)
    MMTextView textlocation;

    @BindView(R.id.tv_3)
    MMTextView textSqft;

    @BindView(R.id.tv_4)
    MMTextView textbed;

@BindView(R.id.fab1)
    FloatingActionButton fabNav;

    public RecyclerViewHolder(@NonNull View itemView, EventItemDelegate delegate) {
        super(itemView);

        ButterKnife.bind(this,itemView);

        mEventItemDelegate = delegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEventItemDelegate.onTap(mData.getId());
            }
        });
        fabNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventItemDelegate.onTabLocation(new LatLng(mData.getLattitude(),mData.getLongitude()));
            }
        });
    }


    @Override
    public void bindData(HotelVO data) {
        mData =data;

        DecimalFormat df = new DecimalFormat("Ks ###,###");
        price.setText(df.format(data.getPrice()));
        textlocation.setText(data.getAddress());
        textSqft.setText(String.valueOf(data.getSquare_feet()));

        Glide.with(itemView)
                .load(data.getHouseimageurl())
                .into(imagehouse);
    }
    }

