package com.example.apifutbol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apifutbol.R;
import com.example.apifutbol.models.CountrysItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAllLeague extends RecyclerView.Adapter<AdapterAllLeague.ViewHolder> {

    Context context;
    List<CountrysItem> items;

    public AdapterAllLeague(Context context, List<CountrysItem> items) {
        this.context = context;
        this.items = items;
    }

    public void setItems(List<CountrysItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_league, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getStrLeague());

        Picasso.get()
                .load(items.get(position).getStrBadge())
                .resize(200,200)
                .into(holder.ivLogo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivLogo;
        TextView tvName;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivLogo = itemView.findViewById(R.id.ivLogo);
            tvName = itemView.findViewById(R.id.tvName);

            this.itemView = itemView;

        }
    }


}
