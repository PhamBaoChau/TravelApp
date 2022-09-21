package com.example.easygo_travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.model.TourAndTicket;
import com.example.easygo_travelapp.model.TourDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TourDetailAdapter extends RecyclerView.Adapter<TourDetailAdapter.ItemViewHolder> {
    private Context context;
    private List<TourDetail> tourDetails;

    public TourDetailAdapter(Context context, List<TourDetail> tourDetails) {
        this.context = context;
        this.tourDetails = tourDetails;
    }

    @NonNull
    @Override
    public TourDetailAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_tour_detail,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourDetailAdapter.ItemViewHolder holder, int position) {
        TourDetail item=tourDetails.get(position);
        Picasso.get().load(item.getImageTour()).into(holder.imgScenic);
        holder.nameScenic.setText(item.getNameTour());
        holder.rating.setText(String.valueOf(item.getRating()));
    }

    @Override
    public int getItemCount() {
        return tourDetails.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgScenic;
        private TextView nameScenic,rating,distance;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgScenic=itemView.findViewById(R.id.imgScenic);
            nameScenic=itemView.findViewById(R.id.tvNameScenic);
            rating=itemView.findViewById(R.id.tvRating);
            distance=itemView.findViewById(R.id.tvDistance);
        }
    }
}
