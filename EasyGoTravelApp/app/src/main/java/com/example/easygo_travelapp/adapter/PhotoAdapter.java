package com.example.easygo_travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easygo_travelapp.R;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ItemViewHolder> {
    private Context context;
    private String[] photos;

    public PhotoAdapter(Context context, String[] photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_photo,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String url=photos[position];
        Picasso.get().load(url).into(holder.imagePhoto);
    }

    @Override
    public int getItemCount() {
        return photos.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagePhoto;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhoto=itemView.findViewById(R.id.imgPhoto);
        }
    }
}
