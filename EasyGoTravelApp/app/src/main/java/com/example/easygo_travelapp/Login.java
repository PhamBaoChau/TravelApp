package com.example.easygo_travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView tvUsername, tvPassword, tvForgot,btnLogin;
    EditText edtUsername, edtPassword;

    private void init(){
        tvUsername=findViewById(R.id.tvUserName);
        tvPassword=findViewById(R.id.tvPassword);
        edtUsername=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        tvForgot=findViewById(R.id.forgot);
        btnLogin=findViewById(R.id.btnLogin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
}