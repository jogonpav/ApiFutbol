package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;


import com.example.apifutbol.R;
import com.example.apifutbol.adapter.AdapterAllTeamsByLeague;
import com.example.apifutbol.httpclient.ApiInterface;
import com.example.apifutbol.httpclient.RetrofitClient;
import com.example.apifutbol.models.ResponseAllTeamsByLeague;
import com.example.apifutbol.models.TeamsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllTeamsByLeague extends AppCompatActivity {


    @BindView(R.id.rvTeamsByLeague)
    RecyclerView rvTeamsByLeague;

    Context context;

    AdapterAllTeamsByLeague adapter;
    List<TeamsItem> items = new ArrayList<>();

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_teams_by_league);

      Bundle extras = getIntent().getExtras();
      String idLeague= extras.getString("IdLeague");
      //Toast.makeText(getApplication(),idLeague, Toast.LENGTH_LONG).show();

        ButterKnife.bind(this);
        context = this;
        adapter = new AdapterAllTeamsByLeague(context, items);
        rvTeamsByLeague.setLayoutManager(new GridLayoutManager(context,1));


        rvTeamsByLeague.setAdapter(adapter); //Después de darle el adaptador al Recycler View, se debe crear el obejo ApiInterface

        //se debe asignar el Retrofitcliente
        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);

        getTeamsByLeague(idLeague);
    }
    public void getTeamsByLeague(String idLeague ){
        Call<ResponseAllTeamsByLeague> api = apiInterface.getTeamsByLeague(idLeague);

        api.enqueue(new Callback<ResponseAllTeamsByLeague>() {
            @Override
            public void onResponse(Call<ResponseAllTeamsByLeague> call, Response<ResponseAllTeamsByLeague> response) {
                if(response.isSuccessful()){
                    adapter.setItems(response.body().getTeams());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<ResponseAllTeamsByLeague> call, Throwable throwable) {
            }
        });

    }
}