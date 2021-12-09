package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.apifutbol.R;
import com.example.apifutbol.adapter.AdapterAllLeague;
import com.example.apifutbol.adapter.AdapterAllTeamsByLeague;
import com.example.apifutbol.adapter.AdapterEventPastMatch;
import com.example.apifutbol.httpclient.ApiInterface;
import com.example.apifutbol.httpclient.RetrofitClient;
import com.example.apifutbol.models.CountrysItem;
import com.example.apifutbol.models.EventsItem;
import com.example.apifutbol.models.ResponseAllLeague;
import com.example.apifutbol.models.ResponseAllTeamsByLeague;
import com.example.apifutbol.models.ResponseEventsPastLeague;
import com.example.apifutbol.models.TeamsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventPastMatch extends AppCompatActivity {

    @BindView(R.id.rvEventPastMatch)
    RecyclerView rvEventPastMatch;

    Context context;
    AdapterEventPastMatch adapter;
    List<EventsItem> items = new ArrayList<>();
    List<TeamsItem> itemsLeague = new ArrayList<>();
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_past_match);
        ButterKnife.bind(this);
        context = this;
        Bundle extras = getIntent().getExtras();
        String idLeague = extras.getString("IdLeague");

        adapter = new AdapterEventPastMatch(context, items,itemsLeague);

        rvEventPastMatch.setLayoutManager(new GridLayoutManager(context, 1));
        rvEventPastMatch.setAdapter(adapter);
        //adapter.getMenuOpcion(menuOpcion);
        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);
        getEventsPastLeague(idLeague);
        getTeamsByLeague(idLeague);
    }
    private void getEventsPastLeague(String idLeague) {
        Call<ResponseEventsPastLeague> api = apiInterface.getEventsPastLeague(idLeague);
        api.enqueue(new Callback<ResponseEventsPastLeague>() {
            @Override
            public void onResponse(Call<ResponseEventsPastLeague> call, Response<ResponseEventsPastLeague> response) {
                if(response.isSuccessful()){
                    adapter.setItems(response.body().getEvents());
                    adapter.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<ResponseEventsPastLeague> call, Throwable throwable) {

            }
        });
    }

    public void getTeamsByLeague(String idLeague ){
        Call<ResponseAllTeamsByLeague> api = apiInterface.getTeamsByLeague(idLeague);
        api.enqueue(new Callback<ResponseAllTeamsByLeague>() {
            @Override
            public void onResponse(Call<ResponseAllTeamsByLeague> call, Response<ResponseAllTeamsByLeague> response) {
                if(response.isSuccessful()){
                    adapter.setItemsLeague(response.body().getTeams());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<ResponseAllTeamsByLeague> call, Throwable throwable) {
            }
        });

    }
}