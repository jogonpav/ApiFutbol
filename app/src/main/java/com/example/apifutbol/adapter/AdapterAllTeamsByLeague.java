package com.example.apifutbol.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apifutbol.Activity.DetailTeam;
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
        holder.idTeam = items.get(position).getIdTeam();

        if (items.get(position).getStrTeamBadge() == null){
            Picasso.get()
                    .load(R.drawable.no_picture)
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


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivLogoTeamByLeague;
        TextView tvNameTeamByLeague;
        View itemView;
        String idTeam;

        //Después de crear los layous correspondiente a la activity, se relacionan los objetos de las vistas
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogoTeamByLeague = itemView.findViewById(R.id.ivLogoTeamByLeague);
            tvNameTeamByLeague = itemView.findViewById(R.id.tvNameTeamByLeague);
            this.itemView = itemView;
        }

        public void setOnClickListeners() {
            ivLogoTeamByLeague.setOnClickListener(this);
            tvNameTeamByLeague.setOnClickListener(this);
        }

        public void onClick(View v) {
            Intent intent = new Intent(context, DetailTeam.class);
            intent.putExtra("idTeam",idTeam);

            for (int i=0; i < items.size(); i++){
                if(items.get(i).getIdTeam() == idTeam){
                    intent.putExtra("teamName", String.valueOf(items.get(i).getStrTeam()));
                    intent.putExtra("FormedYear", String.valueOf(items.get(i).getIntFormedYear()));
                    intent.putExtra("leagueName", String.valueOf(items.get(i).getStrLeague()));
                    intent.putExtra("stadiumName", String.valueOf(items.get(i).getStrStadium()));
                    intent.putExtra("stadiumPhoto", String.valueOf(items.get(i).getStrStadiumThumb()));
                    intent.putExtra("website", String.valueOf(items.get(i).getStrWebsite()));
                    intent.putExtra("facebook", String.valueOf(items.get(i).getStrFacebook()));
                    intent.putExtra("twitter", String.valueOf(items.get(i).getStrTwitter()));
                    intent.putExtra("instagram", String.valueOf(items.get(i).getStrInstagram()));
                    intent.putExtra("youtube", String.valueOf(items.get(i).getStrYoutube()));
                    intent.putExtra("DescriptionEN", String.valueOf(items.get(i).getStrDescriptionEN()));
                    intent.putExtra("teamCountry", String.valueOf(items.get(i).getStrCountry()));
                    intent.putExtra("gender", String.valueOf(items.get(i).getStrGender()));
                    intent.putExtra("teamlogo", String.valueOf(items.get(i).getStrTeamBadge()));
                    intent.putExtra("teamJersey",String.valueOf(items.get(i).getStrTeamJersey()));
                    intent.putExtra("teamBanner",String.valueOf(items.get(i).getStrTeamBanner()));
                    intent.putExtra("teamImgFanart1", String.valueOf(items.get(i).getStrTeamFanart1()));
                    intent.putExtra("teamImgFanart2", String.valueOf(items.get(i).getStrTeamFanart2()));
                    intent.putExtra("teamImgFanart3", String.valueOf(items.get(i).getStrTeamFanart3()));
                    intent.putExtra("teamImgFanart4", String.valueOf(items.get(i).getStrTeamFanart4()));
                }
            }

            Toast.makeText(context, idTeam ,Toast.LENGTH_LONG).show();

            context.startActivity(intent);
        }
    }

}
