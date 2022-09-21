package com.example.easygo_travelapp.activity;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.adapter.TourDetailAdapter;
import com.example.easygo_travelapp.model.Tour;
import com.example.easygo_travelapp.model.TourDetail;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class TourDetailActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RecyclerView rvTourDetail;
    private ImageView imgTour;
    private TextView tvNameTour, location,timeTour;
    private ImageView star1, star2, star3, star4, star5;
    private Tour tour;

    private void init(){
        rvTourDetail=findViewById(R.id.rvTourDetail);
        imgTour=findViewById(R.id.imgTour);
        tvNameTour=findViewById(R.id.tvNameTour);
        location=findViewById(R.id.tvLocation);
        timeTour=findViewById(R.id.tvTimeTour);
        star1=findViewById(R.id.imgStar1);
        star2=findViewById(R.id.imgStar2);
        star3=findViewById(R.id.imgStar3);
        star4=findViewById(R.id.imgStar4);
        star5=findViewById(R.id.imgStar5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);
        init();
        tour= (Tour) getIntent().getBundleExtra(BaseActivity.GET_OBJECT).getSerializable(BaseActivity.GET_TOUR);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fmMaps);
        mapFragment.getMapAsync(this);
        setItemCurrentTour(tour);
        setListTourDetail(tour.getDetailTour());
    }

    private void setListTourDetail(List<TourDetail> tourDetails) {
        TourDetailAdapter adapter=new TourDetailAdapter(this,tourDetails);
        rvTourDetail.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rvTourDetail.setAdapter(adapter);
    }

    private void setItemCurrentTour(Tour tour){
        tvNameTour.setText(tour.getNameTour());
        location.setText(tour.getLocation());
        timeTour.setText(tour.getTimeTour()+getString(R.string.days));
        setRatingStar(tour.getRating(),star1,star2,star3,star4,star5);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        double latitude;
        double longitude;
        for (int i = 0; i<tour.getDetailTour().size(); i++) {
            latitude = tour.getDetailTour().get(i).getLatitude();
            longitude = tour.getDetailTour().get(i).getLongitude();
            LatLng sydney = new LatLng(latitude,longitude);
            mMap.addMarker(new MarkerOptions().position(sydney));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }
}