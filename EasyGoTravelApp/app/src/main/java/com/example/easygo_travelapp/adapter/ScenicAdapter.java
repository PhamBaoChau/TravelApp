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
import com.example.easygo_travelapp.object.ItemScenic;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ScenicAdapter extends RecyclerView.Adapter<ScenicAdapter.ItemViewHolder> {
    private Context context;
    private List<ItemScenic> listScenic;

    public ScenicAdapter(Context context, List<ItemScenic> listScenic) {
        this.context = context;
        this.listScenic = listScenic;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_scenic,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemScenic itemScenic=listScenic.get(position);
        Picasso.get().load(itemScenic.getImageScenic()).into(holder.image);
        holder.name.setText(itemScenic.getNameScenic());
        holder.location.setText(itemScenic.getLocation());
    }

    @Override
    public int getItemCount() {
        return listScenic.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView location;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imgScenic);
            name=itemView.findViewById(R.id.tvScenicName);
            location=itemView.findViewById(R.id.tvLocation);
        }
    }
}
