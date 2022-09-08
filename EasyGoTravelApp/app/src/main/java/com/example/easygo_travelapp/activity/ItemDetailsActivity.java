package com.example.easygo_travelapp.activity;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.adapter.PhotoAdapter;
import com.example.easygo_travelapp.adapter.ReviewAdapter;
import com.example.easygo_travelapp.adapter.ScenicAdapter;
import com.example.easygo_travelapp.adapter.TourAndTicketAdapter;
import com.example.easygo_travelapp.customView.CTRecyclerView;
import com.example.easygo_travelapp.customView.CTToolbar;
import com.example.easygo_travelapp.model.DetailScenic;
import com.example.easygo_travelapp.model.ItemScenic;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;

public class ItemDetailsActivity extends BaseActivity {
    private CTToolbar toolbar;
    private ImageView bg_header;
    private TextView location, name, review, description;
    private ImageView star1, star2, star3, star4, star5;
    private RecyclerView rvPhotos, rvTourAndTickets, rvReviews;
    private PhotoAdapter photoAdapter;
    private TourAndTicketAdapter tourAndTicketAdapter;
    private ReviewAdapter reviewAdapter;

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        bg_header = findViewById(R.id.bg_header);
        location = findViewById(R.id.tvLocation);
        name = findViewById(R.id.tvTitle);
        review = findViewById(R.id.tvReviews);
        description = findViewById(R.id.tvDescription);
        star1 = findViewById(R.id.imgStar1);
        star2 = findViewById(R.id.imgStar2);
        star3 = findViewById(R.id.imgStar3);
        star4 = findViewById(R.id.imgStar4);
        star5 = findViewById(R.id.imgStar5);
        rvPhotos = findViewById(R.id.rvPhotos);
        rvTourAndTickets = findViewById(R.id.rvTourAndTicket);
        rvReviews = findViewById(R.id.rvReviews);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        init();
        int idScenic = getIntent().getIntExtra(ScenicAdapter.ID_SCENIC, 0);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("scenics");
        getDataScenic(reference, idScenic);
        toolbar.setVisibleBack();
        toolbar.setVisibleMenuDetail();
    }

    private void getDataScenic(DatabaseReference myRef, int idScenic) {
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    DetailScenic scenic = itemSnapshot.getValue(DetailScenic.class);
                    if (scenic.getInforCommon().getIdScenic() == idScenic) {
                        setDataItem(scenic);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

    public void setDataItem(DetailScenic scenic) {
        Picasso.get().load(scenic.getInforCommon().getImageScenic()).into(bg_header);
        location.setText(scenic.getInforCommon().getLocation());
        name.setText(scenic.getInforCommon().getNameScenic());
        description.setText(scenic.getDescription());
        setRatingStar(scenic.getRating());
        int nReview = scenic.getReview() != null ? scenic.getReview().size()-1 : 0;
        review.setText(getString(R.string.review) + " (" + nReview + ")");

        String[] sPhotos = scenic.getPhotos().split(",");
        if (scenic.getPhotos()!=null) {
            rvPhotos.setLayoutManager(new GridLayoutManager(ItemDetailsActivity.this,3));
            photoAdapter = new PhotoAdapter(ItemDetailsActivity.this, sPhotos);
            rvPhotos.setAdapter(photoAdapter);
        }

        if (scenic.getTour() != null) {
            rvTourAndTickets.setLayoutManager(new LinearLayoutManager(ItemDetailsActivity.this));
            tourAndTicketAdapter = new TourAndTicketAdapter(ItemDetailsActivity.this, scenic.getTour());
            rvTourAndTickets.setAdapter(tourAndTicketAdapter);
        }

        if (scenic.getReview() != null) {
            rvReviews.setLayoutManager(new LinearLayoutManager(ItemDetailsActivity.this));
            reviewAdapter = new ReviewAdapter(ItemDetailsActivity.this, scenic.getReview());
            rvReviews.setAdapter(reviewAdapter);
        }

    }

    public void setRatingStar(int rating) {
        for (int i = rating; i == rating; i++) {
            if (i < 5) {
                star5.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.color_BEC2CE));
            } else break;
            if (i < 4) {
                star4.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.color_BEC2CE));
            } else break;
            if (i < 3) {
                star3.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.color_BEC2CE));
            } else break;
            if (i < 2) {
                star2.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.color_BEC2CE));
            } else break;
            if (i < 1) {
                star1.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.color_BEC2CE));
            } else break;
        }
    }
}