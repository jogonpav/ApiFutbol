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
import com.example.apifutbol.models.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

//paso_1 Crear el adaptador para las respuesta del retrofif
public class AdapterAllTeamsByLeague extends RecyclerView.Adapter<AdapterAllTeamsByLeague.ViewHolder> {

    Context context;
    List<TeamsItem> items;

    //Después de relacionado el contexto y los items, se debe generar el constructor para ambos objetos
    public AdapterAllTeamsByLeague(Context context, List<TeamsItem> items) {
        this.context = context;
        this.items = items;
    }
    //Después de creado el contructor de context y items se crea el setter de items.
    public void setItems(List<TeamsItem> items) {
        this.items = items;
    }

    //Después de implementar los métodos creamos los layout de la activity del recyclerView
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_teams_by_league,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNameTeamByLeague.setText(items.get(position).getStrTeam());

        if (items.get(position).getStrTeamBadge() == null){
            Picasso.get()
                    .load(R.drawable.concacaf___gold_cup)
                    .resize(200,200)
                    .into(holder.ivLogoTeamByLeague);
        }else{
            Picasso.get()
                    .load(items.get(position).getStrTeamBadge())
                    .resize(200,200)
                    .into(holder.ivLogoTeamByLeague);
        }


        holder.setOnClickListeners();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivLogoTeamByLeague;
        TextView tvNameTeamByLeague;
        View itemView;

        //Después de crear los layous correspondiente a la activity, se relacionan los objetos de las vistas
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogoTeamByLeague = itemView.findViewById(R.id.ivLogoTeamByLeague);
            tvNameTeamByLeague = itemView.findViewById(R.id.tvNameTeamByLeague);
            this.itemView = itemView;
        }

        public void setOnClickListeners() {
        }
    }

}
