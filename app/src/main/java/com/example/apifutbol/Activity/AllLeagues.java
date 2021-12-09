package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apifutbol.R;
import com.example.apifutbol.adapter.AdapterAllLeague;
import com.example.apifutbol.httpclient.ApiInterface;
import com.example.apifutbol.httpclient.RetrofitClient;
import com.example.apifutbol.models.CountrysItem;
import com.example.apifutbol.models.ResponseAllLeague;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllLeagues extends AppCompatActivity {

    @BindView(R.id.rvLeague)
    RecyclerView rvLeague;

    Context context;
    AdapterAllLeague adapter;
    List<CountrysItem> items = new ArrayList<>();
    ApiInterface apiInterface;
    String menuOpcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_leagues);
        ButterKnife.bind(this);
        context = this;
        Bundle extras = getIntent().getExtras();
        menuOpcion = extras.getString("menuOpcion");

        //Toast.makeText(context, menuOpcion,Toast.LENGTH_LONG).show();
        adapter = new AdapterAllLeague(context, items);
        rvLeague.setLayoutManager(new GridLayoutManager(context, 2));
        rvLeague.setAdapter(adapter);
        adapter.getMenuOpcion(menuOpcion);
        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);
        getAllLeague();
    }

    public void getAllLeague(){
        Call<ResponseAllLeague> api = apiInterface.getAllLeague();

        api.enqueue(new Callback<ResponseAllLeague>() {
            @Override
            public void onResponse(Call<ResponseAllLeague> call, Response<ResponseAllLeague> response) {
                if (response.isSuccessful()){
                    adapter.setItems(response.body().getCountrys());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseAllLeague> call, Throwable throwable) {

            }
        });

    }
}