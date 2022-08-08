//package com.example.easygo_travelapp;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//
//import androidx.annotation.Nullable;
//
//public class CTInputOTP extends LinearLayout {
//    private EditText edtCode;
//    private LinearLayout lout;
//    public CTInputOTP(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        initComponent(context);
//        showAttribute(context,attrs);
//    }
//    private void showAttribute(Context context,AttributeSet attributeSet){
//        TypedArray typedArray=context.obtainStyledAttributes(attributeSet,R.styleable.CTInputOTP);
//        int count=typedArray.getIndexCount();
//        try {
//            for (int i = 0; i < count; i++) {
//                int attr = typedArray.getIndex(i);
////                if (attr == R.styleable.CTInputOTP_background) {
////                    setLout();
////                }
//                if (attr==R.styleable.CTInputOTP_Text){
//                    setEdtCode(typedArray.getString(attr));
//                }
//            }
//        } finally {
//            typedArray.recycle();
//        }
//    }
//    private void initComponent(Context context){
//        LayoutInflater inflater=LayoutInflater.from(context);
//        inflater.inflate(R.layout.ctv_input_otp,null);
//        edtCode=findViewById(R.id.edtCode);
//        lout=findViewById(R.id.linearLayout);
//    }
//
//    public void setEdtCode(String code) {
//        this.edtCode.setText(code);
//    }
//
//    public String getEdtCode() {
//        return edtCode.getText().toString();
//    }
//
//    public void setLout() {
//        this.lout.setBackgroundResource(R.drawable.layers_line);
//    }
//}
