package com.example.easygo_travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    TextView tvUsername, tvPassword,tvConfirmPass, btnSignup;
    EditText edtUsername, edtPassword,edtConfirmPass;

private void init(){
    tvUsername=findViewById(R.id.tvUserName);
    tvPassword=findViewById(R.id.edtPassword);
    tvConfirmPass=findViewById(R.id.tvConfirmPassword);
    edtUsername=findViewById(R.id.edtUserName);
    edtPassword=findViewById(R.id.edtPassword);
    edtConfirmPass=findViewById(R.id.edtConfirmPassword);
    btnSignup=findViewById(R.id.signUp);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }
}