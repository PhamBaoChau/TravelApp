package com.example.easygo_travelapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.adapter.TourAdapter;
import com.example.easygo_travelapp.model.DetailScenic;
import com.example.easygo_travelapp.model.Tour;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TourActivity extends AppCompatActivity {
    public static final String FB_TOURS="tours";
    RecyclerView rvTours;
    List<Tour>tours=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        rvTours=findViewById(R.id.rvTours);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference mRef= firebaseDatabase.getReference("tours");
        getFireBaseTours(mRef);
    }

    private void getFireBaseTours(DatabaseReference myRef){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    Tour tour = itemSnapshot.getValue(Tour.class);
                    tours.add(tour);
                }
                TourAdapter adapter=new TourAdapter(TourActivity.this,tours);
                rvTours.setLayoutManager(new LinearLayoutManager(TourActivity.this));
                rvTours.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
}