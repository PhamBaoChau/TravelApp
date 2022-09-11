package com.example.easygo_travelapp.activity;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.customView.CTRecyclerView;
import com.example.easygo_travelapp.customView.CTToolbar;
import com.example.easygo_travelapp.model.ItemScenic;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private CTToolbar toolbar;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavView;
    private CTRecyclerView ctRecyclerViewLove, ctRecyclerViewDeal;
    List<ItemScenic> listScenic = new ArrayList<>();

    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        bottomNavView = findViewById(R.id.bottom_navigation);
        ctRecyclerViewLove = findViewById(R.id.ctRVLove);
        ctRecyclerViewDeal = findViewById(R.id.ctRVDeal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initActionToolbar(toolbar,drawerLayout,navigationView);
        initActionSearch(toolbar);
        initActionBottomNavView(bottomNavView);

        //Container
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("destinationWeLove");
        getDataScenic(reference);
        ctRecyclerViewLove.setTitle(getString(R.string.destinations_we_love));
        ctRecyclerViewDeal.setTitle(getString(R.string.deals));
    }

    private void getDataScenic(DatabaseReference myRef) {
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listScenic.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    ItemScenic itemScenic = itemSnapshot.getValue(ItemScenic.class);
                    listScenic.add( itemScenic);
                    System.out.println("Chau: " + listScenic.toString());
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                ctRecyclerViewLove.showDataRecycleView(listScenic, linearLayoutManager);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                ctRecyclerViewDeal.showDataRecycleView(listScenic, gridLayoutManager);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
}