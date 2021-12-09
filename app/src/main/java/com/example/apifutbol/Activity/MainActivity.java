package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apifutbol.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnListadoLigas = (Button) findViewById(R.id.btnListadoLigas);
        Button btnNextMatch = (Button) findViewById(R.id.btnNextMatch);
        Button btnPastMatch = (Button) findViewById(R.id.btnPastMatch);
        btnListadoLigas.setOnClickListener(this);
        btnNextMatch.setOnClickListener(this);
        btnPastMatch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AllLeagues.class);
        if (v.getId() == R.id.btnListadoLigas) {
            intent.putExtra("menuOpcion", "Menu_1");
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "LISTADO LIGAS", Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.btnPastMatch) {
            intent.putExtra("menuOpcion", "Menu_2");
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Resultados", Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.btnNextMatch) {
            intent.putExtra("menuOpcion", "Menu_3");
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Proximos partidos", Toast.LENGTH_LONG).show();
        }
    }

}