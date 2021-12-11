package com.example.apifutbol.Metodo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.apifutbol.Activity.About;
import com.example.apifutbol.Activity.AllLeagues;
import com.example.apifutbol.Activity.MainActivity;
import com.example.apifutbol.R;

public class MenuNavigation {

    public void menuActivar(Context context, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.option1:
                Intent listado_equipos = new Intent(context.getApplicationContext(), AllLeagues.class);
                listado_equipos.putExtra("navigationOption", "option_1");
                listado_equipos.putExtra("menuOpcion", "Menu_1");
                context.getApplicationContext().startActivity(listado_equipos);
                ((Activity) context).finish();
                break;
            case R.id.option2:
                Intent eventPastMatch = new Intent(context.getApplicationContext(),AllLeagues.class);
                eventPastMatch.putExtra("navigationOption", "option_2");
                eventPastMatch.putExtra("menuOpcion", "Menu_2");
                context.getApplicationContext().startActivity(eventPastMatch);
                ((Activity) context).finish();
                break;
            case R.id.option3:
                Intent inicio = new Intent(context.getApplicationContext(), MainActivity.class);
                inicio.putExtra("navigationOption", "option_3");
                context.getApplicationContext().startActivity(inicio);
                ((Activity) context).finish();
                break;
            case R.id.option4:
                Intent eventNextMatch = new Intent(context.getApplicationContext(),AllLeagues.class);
                eventNextMatch.putExtra("navigationOption", "option_4");
                eventNextMatch.putExtra("menuOpcion", "Menu_3");
                context.getApplicationContext().startActivity(eventNextMatch);
                ((Activity) context).finish();
                break;
            case R.id.option5:
                Intent AcercaDe = new Intent(context.getApplicationContext(), About.class);
                AcercaDe.putExtra("navigationOption", "option_5");
                context.getApplicationContext().startActivity(AcercaDe);
                ((Activity) context).finish();
                break;
            default:
        }

    }

}
