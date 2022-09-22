package com.example.easygo_travelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.activity.BaseActivity;
import com.example.easygo_travelapp.activity.TourDetailActivity;
import com.example.easygo_travelapp.model.Tour;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ItemVIewHolder>{
    private Context context;
    private List<Tour> tours;

    public TourAdapter(Context context, List<Tour> tours) {
        this.context = context;
        this.tours = tours;
    }

    @NonNull
    @Override
    public TourAdapter.ItemVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_tour_favourite,parent,false);
        return new ItemVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourAdapter.ItemVIewHolder holder, int position) {
        Tour tour=tours.get(position);
        Picasso.get().load(tour.getImageTour()).into(holder.imgTour);
        holder.tvNameTour.setText(tour.getNameTour());
        holder.location.setText(tour.getLocation());
        holder.timeTour.setText(tour.getTimeTour()+context.getString(R.string.days));
        setRatingStar(tour.getRating(), holder.star1, holder.star2, holder.star3, holder.star4, holder.star5);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                Activity activity=(Activity)context;
                Intent intent=new Intent(activity, TourDetailActivity.class);
                bundle.putSerializable(BaseActivity.GET_TOUR,tours.get(holder.getAdapterPosition()));
                intent.putExtra(BaseActivity.GET_TOUR,bundle);
                activity.startActivity(intent);
            }
        });
    }

    public void setRatingStar(double rating, ImageView star1,ImageView star2,ImageView star3,ImageView star4,ImageView star5) {
        while (rating != 0) {
            if (rating < 5) {
                star5.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.color_BEC2CE));
            } else break;
            if (rating < 4) {
                star4.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.color_BEC2CE));
            } else break;
            if (rating < 3) {
                star3.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.color_BEC2CE));
            } else break;
            if (rating < 2) {
                star2.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.color_BEC2CE));
            } else break;
            if (rating< 1) {
                star1.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.color_BEC2CE));
            } else break;
        }
    }

    @Override
    public int getItemCount() {
        return tours.size();
    }

    public class ItemVIewHolder extends RecyclerView.ViewHolder {
        private ImageView imgTour;
        private TextView tvNameTour, location,timeTour;
        private ImageView star1, star2, star3, star4, star5;
        public ItemVIewHolder(@NonNull View itemView) {
            super(itemView);
            imgTour=itemView.findViewById(R.id.imgTour);
            tvNameTour=itemView.findViewById(R.id.tvNameTour);
            location=itemView.findViewById(R.id.tvLocation);
            timeTour=itemView.findViewById(R.id.tvTimeTour);
            star1=itemView.findViewById(R.id.imgStar1);
            star2=itemView.findViewById(R.id.imgStar2);
            star3=itemView.findViewById(R.id.imgStar3);
            star4=itemView.findViewById(R.id.imgStar4);
            star5=itemView.findViewById(R.id.imgStar5);
        }
    }
}
