package com.padcmyanmar.padc9.home_rent_application.activites;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.padcmyanmar.padc9.home_rent_application.R;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

import org.mmtextview.components.MMTextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
public class DetailsActivity extends BaseActivity {

    public static final String EXTRA_HOTEL_ID = "eventExtra";
    private int id;
    private HotelVO hotelVO;

    public static Intent newIntent(Context context, int eventIdExtra){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_HOTEL_ID,eventIdExtra);
        return intent;
    }
    @BindView(R.id.img_btn_back)
    ImageButton imgBackBtn;

    @BindView(R.id.tv_price)
    MMTextView tvPrice;

    @BindView(R.id.fab3)
    FloatingActionButton floatingbutton;

    @BindView(R.id.tv_location)
    MMTextView tvLocation;

    @BindView(R.id.tv_sqft)
    MMTextView tvSqft;

    @BindView(R.id.tv_name)
    MMTextView tvName;

    @BindView(R.id.tv_description)
    MMTextView tvDescription;

    @BindView(R.id.imageView1)
    ImageView imgBg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        int eventId = getIntent().getIntExtra(EXTRA_HOTEL_ID,0);

        HotelVO hotelevent=mHotelModel.findHotelById(eventId);

        bindData(hotelevent);
    }
    private void bindData(final HotelVO event){
        DecimalFormat df = new DecimalFormat(this.getString(R.string.price_format));
        tvPrice.setText(df.format(event.getPrice()));

      tvLocation.setText(event.getAddress());
      tvName.setText(event.getName());
      tvDescription.setText(event.getDescription());
      tvSqft.setText(getString(R.string.square_feet_format,event.getSquare_feet()));
        Glide.with(this)
                .load(event.getHouseimageurl())
                .into(imgBg);

        imgBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        double lattitude=event.getLattitude();
        double longitude=event.getLongitude();

        floatingbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=lattitude,longitude");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });
    }



}
