package com.example.apifutbol.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apifutbol.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void Volver_Menu (View view){
        Intent lista_equipos = new Intent(this, MainActivity.class);
        startActivity(lista_equipos);
    }
}