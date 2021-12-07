package com.example.apifutbol.httpclient;

import com.example.apifutbol.models.ResponseAllLeague;
import com.example.apifutbol.models.ResponseDetailLeague;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("search_all_leagues.php?s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    //lookupleague.php?id=4346
    @GET("lookupleague.php")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id")String id);

    /*@GET("search_all_leagues.php?rapidapi-key=5cc79b5ed6mshf728d09b66e8248p1c4e50jsn8f6e07873a20&s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    @GET("lookupleague.php?rapidapi-key=5cc79b5ed6mshf728d09b66e8248p1c4e50jsn8f6e07873a20")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id")String id);*/


}
