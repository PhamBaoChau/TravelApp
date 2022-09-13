package com.example.easygo_travelapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.customView.CTToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends BaseActivity {

    private CTToolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavView;
    private ImageView avatar;
    private TextView fullName,tvVipMember,tvLogin;

    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        bottomNavView = findViewById(R.id.bottom_navigation);
        avatar=findViewById(R.id.imgAvatar);
        fullName=findViewById(R.id.tvFullName);
        tvVipMember=findViewById(R.id.tvVipMember);
        tvLogin=findViewById(R.id.tvLogin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
        initActionToolbar(toolbar,drawerLayout,navigationView);
        initActionMenuDetail(toolbar);
        initActionBottomNavView(bottomNavView);
        updateBottomNavState(bottomNavView);
        getCurrentUser();
    }

    private void getCurrentUser() {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            fullName.setVisibility(View.VISIBLE);
            tvVipMember.setVisibility(View.VISIBLE);
            tvLogin.setVisibility(View.GONE);

            if (user.getPhotoUrl()!=null&&user.getDisplayName()!=null){
                Picasso.get().load(user.getPhotoUrl()).into(avatar);
                fullName.setText(user.getDisplayName());
            }
            else {
                Picasso.get().load("https://www.i-music.com.hk/assets/images/no-avatar.png").into(avatar);
                fullName.setText(R.string.no_name);
            }
        }
        else {
            fullName.setVisibility(View.GONE);
            tvVipMember.setVisibility(View.GONE);
            tvLogin.setVisibility(View.VISIBLE);
        }
    }
}