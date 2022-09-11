package com.example.easygo_travelapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.customView.CTToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends BaseActivity {

    private CTToolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavView;

    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        bottomNavView = findViewById(R.id.bottom_navigation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
        initActionToolbar(toolbar,drawerLayout,navigationView);
        initActionMenuDetail(toolbar);
        initActionBottomNavView(bottomNavView);
    }
}