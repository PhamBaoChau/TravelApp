package com.example.easygo_travelapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.customView.CTRecyclerView;
import com.example.easygo_travelapp.object.ItemScenic;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Toolbar.OnMenuItemClickListener, NavigationBarView.OnItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavView;
    private CTRecyclerView ctRecyclerViewLove, ctRecyclerViewDeal;
    List<ItemScenic>listScenic=new ArrayList<>();

    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        bottomNavView = findViewById(R.id.bottom_navigation);
        ctRecyclerViewLove=findViewById(R.id.ctRVLove);
        ctRecyclerViewDeal=findViewById(R.id.ctRVDeal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //Navigation Drawer
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        //Container
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference("destinationWeLove");
        getDataScenic(reference);
        ctRecyclerViewLove.setTitle(getString(R.string.destinations_we_love));
        ctRecyclerViewDeal.setTitle(getString(R.string.deals));
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
//        ctRecyclerViewLove.showDataRecycleView(listScenic,linearLayoutManager);
//        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
//        ctRecyclerViewLove.showDataRecycleView(listScenic,linearLayoutManager);
//        System.out.println("Chau"+listScenic.toString());
        initAction();
    }

    private void initAction() {
        toolbar.setNavigationOnClickListener(this);
        toolbar.setOnMenuItemClickListener(this);
        bottomNavView.setOnItemSelectedListener(this);
    }

    private void getDataScenic(DatabaseReference myRef){
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()){
                    ItemScenic itemScenic=itemSnapshot.getValue(ItemScenic.class);
                    listScenic.add(itemScenic);
                }
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL,false);
                ctRecyclerViewLove.showDataRecycleView(listScenic,linearLayoutManager);
                GridLayoutManager gridLayoutManager =new GridLayoutManager(MainActivity.this,2);
                ctRecyclerViewDeal.showDataRecycleView(listScenic,gridLayoutManager);
                System.out.println("Chau"+listScenic.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

    @Override
    public void onClick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_favourite:
                Toast.makeText(this, "Drawer Navigation Item 2", Toast.LENGTH_SHORT);
                break;

            case R.id.nav_my_trip:
                Toast.makeText(this, "Drawer Navigation Item 3", Toast.LENGTH_SHORT);
                break;

            case R.id.nav_profile:
                Toast.makeText(this, "Drawer Navigation Item 4", Toast.LENGTH_SHORT);
                break;

            case R.id.nav_log_out:
                Toast.makeText(this, "Drawer Navigation Item 5", Toast.LENGTH_SHORT);
                break;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_explore:
                System.out.println("Chau: Drawer Navigation Item 1");
                Toast.makeText(this, "Drawer Navigation Item 1", Toast.LENGTH_SHORT);
                break;

            case R.id.btn_my_trip:
                System.out.println("Chau: Drawer Navigation Item 2");
                Toast.makeText(this, "Drawer Navigation Item 2", Toast.LENGTH_SHORT);
                break;

            case R.id.btn_favourite:
                System.out.println("Chau: Drawer Navigation Item 3");
                Toast.makeText(this, "Drawer Navigation Item 3", Toast.LENGTH_SHORT);
                break;

            case R.id.btn_profile:
                System.out.println("Chau: Drawer Navigation Item 4");
                Toast.makeText(this, "Drawer Navigation Item 4", Toast.LENGTH_SHORT);
                break;
        }
        item.setChecked(true);
        return false;
    }
}