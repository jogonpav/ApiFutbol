package com.example.apifutbol.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apifutbol.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Listado_Equipos (View view){
        Intent lista_equipos = new Intent(this, AllLeagues.class);
        lista_equipos.putExtra("menuOpcion", "Menu_1");
        lista_equipos.putExtra("navigationOption", "option_1");
        startActivity(lista_equipos);
    }

    public void Resultados (View view){
        Intent lista_equipos = new Intent(this, AllLeagues.class);
        lista_equipos.putExtra("menuOpcion", "Menu_2");
        lista_equipos.putExtra("navigationOption", "option_2");
        startActivity(lista_equipos);
    }

    public void Proximos_Partidos (View view){
        Intent lista_equipos = new Intent(this, AllLeagues.class);
        lista_equipos.putExtra("menuOpcion", "Menu_3");
        lista_equipos.putExtra("navigationOption", "option_4");
        startActivity(lista_equipos);
    }

    public void Acerca_de (View view){
        Intent lista_equipos = new Intent(this, About.class);
        lista_equipos.putExtra("navigationOption", "option_5");
        startActivity(lista_equipos);
    }
}