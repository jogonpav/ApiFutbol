package com.example.apifutbol.httpclient;

import com.example.apifutbol.models.ResponseAllLeague;
import com.example.apifutbol.models.ResponseAllTeamsByLeague;
import com.example.apifutbol.models.ResponseDetailLeague;
import com.example.apifutbol.models.ResponseEventsLeague;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("search_all_leagues.php?s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    //lookupleague.php?id=4346  - Detalla solo la información de la liga
    @GET("lookupleague.php")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id")String id);

    //lookup_all_teams.php?id=4346  - Detalla la información de los equipos de la liga
    @GET("lookup_all_teams.php")
    Call<ResponseAllTeamsByLeague> getTeamsByLeague(@Query("id") String id_teams);

    //https://www.thesportsdb.com/api/v1/json/50130162/eventspastleague.php?id=4328
    @GET("eventspastleague.php")
    Call<ResponseEventsLeague> getEventsPastLeague(@Query("id") String idLeague);

    //https://www.thesportsdb.com/api/v1/json/50130162/eventsnextleague.php?id=4497
    @GET("eventsnextleague.php")
    Call<ResponseEventsLeague> getEventsNextLeague(@Query("id") String idLeague);




    /*@GET("search_all_leagues.php?rapidapi-key=5cc79b5ed6mshf728d09b66e8248p1c4e50jsn8f6e07873a20&s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    @GET("lookupleague.php?rapidapi-key=5cc79b5ed6mshf728d09b66e8248p1c4e50jsn8f6e07873a20")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id")String id);*/


}
