package com.example.easygo_travelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.customView.CTToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener {
    private DrawerLayout drawerLayout;
    private MenuItem prev;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("################### ACTIVITY ########################");
        System.out.println("Activity name: " + this.getLocalClassName());
        System.out.println("######################################################");
    }

    public void initActionToolbar(CTToolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView) {
        toolbar.setVisibleMenu(drawerLayout, navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        this.drawerLayout = drawerLayout;
    }

    public void initActionBack(CTToolbar toolbar) {
        toolbar.setVisibleBack();
    }

    public void initActionMenuDetail(CTToolbar toolbar) {
        toolbar.setVisibleMenuDetail();
    }

    public void initActionShare(CTToolbar toolbar) {
        toolbar.setVisibleShare();
    }

    public void initActionSearch(CTToolbar toolbar) {
        toolbar.setVisibleSearch();
    }


    public void initActionBottomNavView(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener(this);
    }

    public void updateBottomNavState(BottomNavigationView bottomNavigationView){
        int itemId=getIntent().getIntExtra("NavItem",-1);
        Menu menu=bottomNavigationView.getMenu();
        for (int i=0;i<menu.size();i++){
            MenuItem menuItem=menu.getItem(i);
            menuItem.setChecked(menuItem.getItemId()==itemId);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.btn_explore:

            case R.id.nav_home:
                intent = new Intent(this, MainActivity.class);
                break;

            case R.id.btn_profile:

            case R.id.nav_profile:
                intent = new Intent(this, ProfileActivity.class);
                break;

            case R.id.btn_favourite:
                break;

            case R.id.nav_favourite:
                break;

            case R.id.btn_my_trip:
                break;

            case R.id.nav_my_trip:
                break;

            case R.id.nav_log_out:
                break;
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("NavItemId", item.getItemId());
        startActivity(intent);

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
