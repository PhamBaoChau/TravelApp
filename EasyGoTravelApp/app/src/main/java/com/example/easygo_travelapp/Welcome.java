package com.example.easygo_travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    TextView btnFb, btnPhone, btnLogin;

    private void init() {
        btnFb = findViewById(R.id.btnLoginFB);
        btnPhone = findViewById(R.id.btnLoginPhone);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
        btnPhone.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == btnPhone.getId()) {
//            Intent intent = new Intent(Welcome.this, LoginPhoneNumber.class);
//            startActivity(intent);
//        }
        if (view.getId() == btnLogin.getId()) {
            Intent intent = new Intent(Welcome.this, Login.class);
            startActivity(intent);
        }
    }
}