package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apifutbol.R;
import com.example.apifutbol.adapter.AdapterEventPastMatch;
import com.example.apifutbol.httpclient.ApiInterface;
import com.example.apifutbol.httpclient.RetrofitClient;
import com.example.apifutbol.models.EventsItem;
import com.example.apifutbol.models.ResponseAllTeamsByLeague;
import com.example.apifutbol.models.ResponseEventsLeague;
import com.example.apifutbol.models.TeamsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventNextMatch extends AppCompatActivity {

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
        setContentView(R.layout.activity_event_next_match);
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


    }
    private void getEventsPastLeague(String idLeague) {
        Call<ResponseEventsLeague> api = apiInterface.getEventsNextLeague(idLeague);
        api.enqueue(new Callback<ResponseEventsLeague>() {
            @Override
            public void onResponse(Call<ResponseEventsLeague> call, Response<ResponseEventsLeague> response) {
                if(response.isSuccessful()){
                    if (!response.body().toStringNull().equals("null")){
                        adapter.setItems(response.body().getEvents());
                        adapter.notifyDataSetChanged();
                        getTeamsByLeague(idLeague);
                    }else{
                        Toast.makeText(getApplicationContext(), "Esta LIGA No tiene Eventos", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseEventsLeague> call, Throwable throwable) {

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