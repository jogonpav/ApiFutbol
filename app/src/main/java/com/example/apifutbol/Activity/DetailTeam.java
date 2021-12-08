package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apifutbol.R;
import com.squareup.picasso.Picasso;

import java.net.URI;

public class DetailTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        Bundle extras = getIntent().getExtras();
        String idTeam = extras.getString("idTeam");
        String teamName = extras.getString("teamName");
        String FormedYear = extras.getString("FormedYear");
        String leagueName = extras.getString("leagueName");
        String stadiumName = extras.getString("stadiumName");
        String stadiumPhoto = extras.getString("stadiumPhoto");
        String website = extras.getString("website");
        String facebook = extras.getString("facebook");
        String twitter = extras.getString("twitter");
        String instagram = extras.getString("instagram");
        String youtube = extras.getString("youtube");
        String descriptionEN = extras.getString("DescriptionEN");
        String teamCountry = extras.getString("teamCountry");
        String gender = extras.getString("gender");
        String teamlogo = extras.getString("teamlogo");
        String teamJersey = extras.getString("teamJersey");
        String teamBanner = extras.getString("teamBanner");
        String teamImgFanart1 = extras.getString("teamImgFanart1");
        String teamImgFanart2 = extras.getString("teamImgFanart2");
        String teamImgFanart3 = extras.getString("teamImgFanart3");
        String teamImgFanart4 = extras.getString("teamImgFanart4");

        TextView tvNameTeam = (TextView) findViewById(R.id.tvNameTeam);
        TextView tvStadiumName = (TextView) findViewById(R.id.tvStadiumName);
        TextView tvTeamFormedYear = (TextView) findViewById(R.id.tvTeamFormedYear);
        TextView tvNameLeagueTeam = (TextView) findViewById(R.id.tvNameLeagueTeam);
        TextView tvCountryTeam = (TextView) findViewById(R.id.tvCountryTeam);
        TextView tvGenderTeam = (TextView)findViewById(R.id.tvGenderTeam);
        TextView tvDescriptionTeam = (TextView) findViewById(R.id.tvDescriptionTeam);
        ImageView ivLogotTeam = (ImageView) findViewById(R.id.ivLogotTeam);
        ImageView ivJerseyTeam = (ImageView) findViewById(R.id.ivJerseyTeam);
        ImageView ivStadiumTeam = (ImageView) findViewById(R.id.ivStadiumTeam);
        ImageView ivFannart1Team = (ImageView) findViewById(R.id.ivFannart1Team);
        ImageView ivFannart2Team = (ImageView) findViewById(R.id.ivFannart2Team);
        ImageView ivFannart3Team = (ImageView) findViewById(R.id.ivFannart3Team);
        ImageView ivFannart4Team = (ImageView) findViewById(R.id.ivFannart4Team);

        ImageView ivTeamBanner = (ImageView) findViewById(R.id.ivBannerTeam);
        ImageView ivInternet = (ImageView) findViewById(R.id.ivInternet);
        ImageView ivFacebook = (ImageView) findViewById(R.id.ivFacebook);
        ImageView ivInstagram = (ImageView) findViewById(R.id.ivInstagram);
        ImageView ivTwitter = (ImageView) findViewById(R.id.ivTwitter);
        ImageView ivYoutube = (ImageView) findViewById(R.id.ivYoutube);


        Toast.makeText(this, website, Toast.LENGTH_LONG).show();
        if (website.isEmpty()){
            ivInternet.setVisibility(View.GONE);
        }
        if (facebook.isEmpty()){
            ivFacebook.setVisibility(View.GONE);
        }
        if (instagram.isEmpty()){
            ivInstagram.setVisibility(View.GONE);
        }
        if (twitter.isEmpty()){
            ivTwitter.setVisibility(View.GONE);
        }
        if (youtube.isEmpty()){
            ivYoutube.setVisibility(View.GONE);
        }

        //URL WEBSITE
        ivInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriWebsite = Uri.parse("https://"+website);
                Intent internetURL = new Intent(Intent.ACTION_VIEW,uriWebsite);
                startActivity(internetURL);
            }
        });
        //URL FACEBOOK
        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriWebsite = Uri.parse("https://"+facebook);
                Intent internetURL = new Intent(Intent.ACTION_VIEW,uriWebsite);
                startActivity(internetURL);
            }
        });
        //URL INSTAGRAM
        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriWebsite = Uri.parse("https://"+instagram);
                Intent internetURL = new Intent(Intent.ACTION_VIEW,uriWebsite);
                startActivity(internetURL);
            }
        });
        //URL TWETTER
        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriWebsite = Uri.parse("https://"+twitter);
                Intent internetURL = new Intent(Intent.ACTION_VIEW,uriWebsite);
                startActivity(internetURL);
            }
        });
        //URL YOUTUBE
        ivYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriWebsite = Uri.parse("https://"+youtube);
                Intent internetURL = new Intent(Intent.ACTION_VIEW,uriWebsite);
                startActivity(internetURL);
            }
        });



        //Linkify.addLinks(textView, Linkify.PHONE_NUMBERS | Linkify.WEB_URLS);

        tvNameTeam.setText(teamName);
        tvStadiumName.setText(stadiumName);
        tvTeamFormedYear.setText(FormedYear);
        tvNameLeagueTeam.setText(leagueName);
        tvCountryTeam.setText(teamCountry);
        tvGenderTeam.setText(gender);
        tvDescriptionTeam.setText(descriptionEN);

        //image logo
        Picasso.get()
                .load(teamlogo)
                .resize(300,300)
                .into(ivLogotTeam);

        //image Jersey
        Picasso.get()
                .load(teamJersey)
                .resize(300,300)
                .into(ivJerseyTeam);

        //Stadium Imagen
        Picasso.get()
                .load(stadiumPhoto)
                //.resize(200,200)
                .into(ivStadiumTeam);

        //image BannerTeam
        Picasso.get()
                .load(teamBanner)
                //.resize(500,500)
                .into(ivTeamBanner);

        //image FannArt1
        Picasso.get()
                .load(teamImgFanart1)
                .resize(500,500)
                .into(ivFannart1Team);
        //image FannArt2
        Picasso.get()
                .load(teamImgFanart2)
                .resize(500,500)
                .into(ivFannart2Team);
        //image FannArt3
        Picasso.get()
                .load(teamImgFanart3)
                .resize(500,500)
                .into(ivFannart3Team);

        //image FannArt4
        Picasso.get()
                .load(teamImgFanart4)
                .resize(500,500)
                .into(ivFannart4Team);




    }
}