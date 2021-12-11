package com.example.apifutbol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apifutbol.R;
import com.example.apifutbol.models.EventsItem;
import com.example.apifutbol.models.TeamsItem;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AdapterEventPastMatch extends RecyclerView.Adapter<AdapterEventPastMatch.ViewHolder> {

    Context context;
    List<EventsItem> items;
    List<TeamsItem> teamsItems;

    public AdapterEventPastMatch(Context context, List<EventsItem> items, List<TeamsItem> teamsItems) {
        this.context = context;
        this.items = items;
        this.teamsItems = teamsItems;
    }

    public void setItems(List<EventsItem> items) {
        this.items = items;
    }

    public void setItemsLeague(List<TeamsItem> teamsItems) {
        this.teamsItems = teamsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event_past_match,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDateEventPast.setText(items.get(position).getDateEvent()+" "+items.get(position).getStrTimeLocal());
        holder.tvHomeTeam.setText(items.get(position).getStrHomeTeam());
        holder.tvHomeScore.setText(items.get(position).getIntHomeScore());
        holder.tvAwayTeam.setText(items.get(position).getStrAwayTeam());
        holder.tvAwayScore.setText(items.get(position).getIntAwayScore());

        //image team home
        for (int i = 0; i < teamsItems.size(); i++ ){
            if(items.get(position).getIdHomeTeam().equals(teamsItems.get(i).getIdTeam())) {
                if (teamsItems.get(i).getStrTeamBadge() == null) {
                    Picasso.get()
                            .load(R.drawable.no_picture)
                            .resize(200, 200)
                            .into(holder.ivHomeTeam);
                } else {
                    Picasso.get()
                            .load(teamsItems.get(i).getStrTeamBadge())
                            .resize(200, 200)
                            .into(holder.ivHomeTeam);
                }
            }
            if(items.get(position).getIdAwayTeam().equals(teamsItems.get(i).getIdTeam())){
                if (teamsItems.get(i).getStrTeamBadge() == null){
                    Picasso.get()
                            .load(R.drawable.no_picture)
                            .resize(200,200)
                            .into(holder.ivAwayTeam);
                }else{
                    Picasso.get()
                            .load(teamsItems.get(i).getStrTeamBadge() )
                            .resize(200,200)
                            .into(holder.ivAwayTeam);
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDateEventPast;
        TextView tvHomeTeam;
        TextView tvHomeScore;
        TextView tvAwayTeam;
        TextView tvAwayScore;
        ImageView ivHomeTeam;
        ImageView ivAwayTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDateEventPast = itemView.findViewById(R.id.tvDateEventPast);
            tvHomeTeam = itemView.findViewById(R.id.tvHomeTeam);
            tvHomeScore = itemView.findViewById(R.id.tvHomeScore);
            tvAwayTeam = itemView.findViewById(R.id.tvAwayTeam);
            tvAwayScore = itemView.findViewById(R.id.tvAwayScore);
            ivHomeTeam = itemView.findViewById(R.id.ivHomeTeam);
            ivAwayTeam = itemView.findViewById(R.id.ivAwayTeam);

        }
    }
}
