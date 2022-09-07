package com.example.easygo_travelapp.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.model.TourAndTicket;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TourAndTicketAdapter extends RecyclerView.Adapter<TourAndTicketAdapter.ItemViewHolder> {
    private Context context;
    private List<TourAndTicket> list;

    public TourAndTicketAdapter(Context context, List<TourAndTicket> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tour_ticket, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TourAndTicket item = list.get(position+1);
        Picasso.get().load(item.getImageTour()).into(holder.imgTour);
        holder.nameTour.setText(item.getNameTour());
        holder.price.setText("$" + item.getPrice());

        for (int i=item.getRating();i==item.getRating();i++) {
            if (i < 5) {
                holder.star5.setBackgroundTintList(ContextCompat.getColorStateList(context,R.color.color_BEC2CE));
            } else break;
            if (i < 4) {
                holder.star4.setBackgroundTintList(ContextCompat.getColorStateList(context,R.color.color_BEC2CE));
            } else break;
            if (i < 3) {
                holder.star3.setBackgroundTintList(ContextCompat.getColorStateList(context,R.color.color_BEC2CE));
            } else break;
            if (i < 2){
                holder.star2.setBackgroundTintList(ContextCompat.getColorStateList(context,R.color.color_BEC2CE));
            }else break;
            if (i < 1){
                holder.star1.setBackgroundTintList(ContextCompat.getColorStateList(context,R.color.color_BEC2CE));
            }else break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size()-1;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgTour;
        private TextView nameTour, price;
        private ImageView star1, star2, star3, star4, star5;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTour = itemView.findViewById(R.id.imgTour);
            nameTour = itemView.findViewById(R.id.tvNameTour);
            price = itemView.findViewById(R.id.tvPrice);
            star1 = itemView.findViewById(R.id.imgStar1);
            star2 = itemView.findViewById(R.id.imgStar2);
            star3 = itemView.findViewById(R.id.imgStar3);
            star4 = itemView.findViewById(R.id.imgStar4);
            star5 = itemView.findViewById(R.id.imgStar5);
        }
    }
}
