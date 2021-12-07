package com.example.apifutbol.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apifutbol.Activity.DetailLeague;
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
    //onBindViewHolder muestra el contenido
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getStrLeague());
        //holder.PositionLeague.setText(position);
        holder.tvIdLeague.setText(items.get(position).getIdLeague());

        if (items.get(position).getStrBadge() == null){
            Picasso.get()
                    .load(R.drawable.concacaf___gold_cup)
                    .resize(200,200)
                    .into(holder.ivLogo);
        }else{
        Picasso.get()
                .load(items.get(position).getStrBadge())
                .resize(200,200)
                .into(holder.ivLogo);
        }


        holder.setOnClickListeners();


        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivLogo;
        TextView tvName;
        TextView tvIdLeague;
        View itemView;
        //buton para pasar a activity
        Button btnVerliga;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            tvName = itemView.findViewById(R.id.tvName);
            tvIdLeague = itemView.findViewById(R.id.tvIdLeague);
            this.itemView = itemView;
            btnVerliga = itemView.findViewById(R.id.btnVerLiga);
            context = itemView.getContext();

        }

        public void setOnClickListeners() {
            btnVerliga.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast toast;
            Intent intent = new Intent(context, DetailLeague.class);
            for (int i=0; i < items.size(); i++){
                if(items.get(i).getIdLeague() == tvIdLeague.getText()){
                    //toast = Toast.makeText(context, String.valueOf(items.get(i).getStrBadge()), Toast.LENGTH_LONG);
                    //toast.show();
                    //enviar parámetro a la activity invocada
                    intent.putExtra("IdLeague", tvIdLeague.getText());
                    intent.putExtra("logo", String.valueOf(items.get(i).getStrBadge()));
                    intent.putExtra("banner",String.valueOf(items.get(i).getStrBanner()));
                    intent.putExtra("nameLeague", String.valueOf(items.get(i).getStrLeague()));
                    intent.putExtra("country", String.valueOf(items.get(i).getStrCountry()));
                    intent.putExtra("FormedYear", String.valueOf(items.get(i).getIntFormedYear()));
                    intent.putExtra("gender", String.valueOf(items.get(i).getStrGender()));
                    intent.putExtra("DescriptionEN", String.valueOf(items.get(i).getStrDescriptionEN()));
                    intent.putExtra("ImgFanart1", String.valueOf(items.get(i).getStrFanart1()));
                    intent.putExtra("ImgFanart2", String.valueOf(items.get(i).getStrFanart2()));
                    intent.putExtra("ImgFanart3", String.valueOf(items.get(i).getStrFanart3()));
                    intent.putExtra("ImgFanart4", String.valueOf(items.get(i).getStrFanart4()));
                }
            }
            //toast.show();
            //intent.putExtra("logo1", items.get(Integer.parseInt(PositionLeague.getText())).getStrLogo());
           // intent.putExtra("items", (Parcelable) items);
            context.startActivity(intent);
        }
    }


}
