package com.example.easygo_travelapp.customView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.activity.MainActivity;

public class CTToolbar extends ConstraintLayout implements View.OnClickListener {
    ImageButton icMenu,icMenuDetail,icBack,icShare;
    public CTToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponent();
        initAction();
    }

    public void initComponent() {
        View view = LayoutInflater
                .from(getContext())
                .inflate(R.layout.ctv_toolbar, this, true);
        this.icMenu=view.findViewById(R.id.icMenu);
        this.icMenuDetail=view.findViewById(R.id.icMenuDetail);
        this.icBack=view.findViewById(R.id.icBack);
        this.icShare=view.findViewById(R.id.icShare);
    }

    public void setVisibleMenu() {
        this.icMenu.setVisibility(VISIBLE);
    }

    public void setVisibleMenuDetail() {
        this.icMenuDetail.setVisibility(VISIBLE);
    }

    public void setVisibleBack() {
        this.icBack.setVisibility(VISIBLE);
    }

    public void setVisibleShare() {
        this.icShare.setVisibility(VISIBLE);
    }

    public void initAction(){
        this.icMenu.setOnClickListener(this);
        this.icMenuDetail.setOnClickListener(this);
        this.icBack.setOnClickListener(this);
        this.icShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==icMenu.getId())
        {

        }
        if (view.getId()==icMenuDetail.getId()){

        }
        if (view.getId()==icBack.getId()){
            Activity activity = (Activity)getContext();
            activity.onBackPressed();
        }
        if (view.getId()==icShare.getId()){

        }
    }
}
