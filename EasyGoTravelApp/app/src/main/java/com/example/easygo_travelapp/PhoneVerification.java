//package com.example.easygo_travelapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class PhoneVerification extends AppCompatActivity {
//
//    TextView tvPhoneNum;
//    CTInputOTP code1, code2,code3,code4;
//
//    private void init(){
//        tvPhoneNum=findViewById(R.id.tvPhone);
//        code1=findViewById(R.id.code1);
//        code2=findViewById(R.id.code2);
//        code3=findViewById(R.id.code3);
//        code4=findViewById(R.id.code4);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phone_verification);
//        init();
//
//        tvPhoneNum.setText(getIntent().getIntExtra(LoginPhoneNumber.PHONE_NUMBER,0));
//    }
//}