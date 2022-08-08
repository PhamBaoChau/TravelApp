//package com.example.easygo_travelapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.View;
//import android.widget.EditText;
//
//public class LoginPhoneNumber extends AppCompatActivity {
//    public static final String PHONE_NUMBER = "phone_number";
//    EditText edtPhoneNum;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login_phone_number);
//        edtPhoneNum = findViewById(R.id.edtPhoneNumber);
//        edtPhoneNum.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if (keyEvent.getAction() == KeyEvent.KEYCODE_NAVIGATE_NEXT) {
//                    if (edtPhoneNum.getText().toString().length() == 10) {
//                        Intent intent = new Intent(LoginPhoneNumber.this, PhoneVerification.class);
//                        intent.putExtra(PHONE_NUMBER, edtPhoneNum.getText().toString());
//                        startActivity(intent);
//                    }
//                }
//                return false;
//            }
//        });
//    }
//}