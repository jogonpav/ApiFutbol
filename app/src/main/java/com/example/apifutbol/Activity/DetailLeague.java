package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apifutbol.R;
import com.squareup.picasso.Picasso;


public class DetailLeague extends AppCompatActivity implements View.OnClickListener {
    TextView tvIdLeague2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_league);
        Bundle extras = getIntent().getExtras();
        String idLeague2 = extras.getString("IdLeague");
        String logoDetail = extras.getString("logo");
        String bannerDetail = extras.getString("banner");
        String nameLeagueDetail = extras.getString("nameLeague");
        String countryDetail = extras.getString("country");
        String FormedYearDetail = extras.getString("FormedYear");
        String genderDetail = extras.getString("gender");
        String DescriptionENDetail = extras.getString("DescriptionEN");
        String Fanart1Detail = extras.getString("ImgFanart1");
        String Fanart2Detail = extras.getString("ImgFanart2");
        String Fanart3Detail = extras.getString("ImgFanart3");
        String Fanart4Detail = extras.getString("ImgFanart4");


        ImageView ivLogoDetail = (ImageView) findViewById(R.id.ivLogoDetail);
        ImageView ivBannerDetail = (ImageView) findViewById(R.id.ivBannerDetail);
        TextView tvNameLeagueDetail = (TextView) findViewById(R.id.tvNameDetail);
        TextView tvCountryDetail = (TextView) findViewById(R.id.tvCountryDetail);
        TextView tvFormedYearDetail = (TextView) findViewById(R.id.tvYearDetail);
        TextView tvGenderDetail = (TextView) findViewById(R.id.tvGenderDetail);
        TextView tvDescriptionENDetail = (TextView) findViewById(R.id.tvDescriptionDetail);
        tvIdLeague2 = (TextView) findViewById(R.id.tvIdLeague2);
        ImageView ivFanart1Detail = (ImageView) findViewById(R.id.ivFanart1Detail);
        ImageView ivFanart2Detail = (ImageView) findViewById(R.id.ivFanart2Detail);
        ImageView ivFanart3Detail = (ImageView) findViewById(R.id.ivFanart3Detail);
        ImageView ivFanart4Detail = (ImageView) findViewById(R.id.ivFanart4Detail);

        tvNameLeagueDetail.setText(nameLeagueDetail);
        tvCountryDetail.setText(countryDetail);
        tvFormedYearDetail.setText(FormedYearDetail);
        tvGenderDetail.setText(genderDetail);
        tvIdLeague2.setText(idLeague2);
        tvDescriptionENDetail.setText(DescriptionENDetail);

        //image banner
        Picasso.get()
                .load(bannerDetail)
                //.resize(200,200)
                .into(ivBannerDetail);
        //image logo
        Picasso.get()
                .load(logoDetail)
                .resize(300,300)
                .into(ivLogoDetail);
        //image FannArt1
        Picasso.get()
                .load(Fanart1Detail)
                .resize(500,500)
                .into(ivFanart1Detail);
        //image FannArt2
        Picasso.get()
                .load(Fanart2Detail)
                .resize(500,500)
                .into(ivFanart2Detail);
        //image FannArt3
        Picasso.get()
                .load(Fanart3Detail)
                .resize(500,500)
                .into(ivFanart3Detail);
        //image FannArt4
        Picasso.get()
                .load(Fanart4Detail)
                .resize(500,500)
                .into(ivFanart4Detail);
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplication(),tvIdLeague2.getText() +"boton funcionando", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, AllTeamsByLeague.class);
        intent.putExtra("IdLeague", tvIdLeague2.getText());
        startActivity(intent);


    }
}