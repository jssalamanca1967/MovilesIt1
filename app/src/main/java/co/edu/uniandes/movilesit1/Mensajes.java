package co.edu.uniandes.movilesit1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.widget.Toast;

/**
 * Created by John on 28/02/2016.
 */
public class Mensajes {

    /**
     *
     * @param activity Actividad que lo solicita
     * @param message Mensaje a enviar
     * @param corto true si es de duracion corta. False si es de duracion larga
     */
    public static void toast(Activity activity, String message, boolean corto){

        Context context = activity.getApplicationContext();

        int duration = corto?Toast.LENGTH_SHORT:Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public static void alertDialog(Activity activity, String message){

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        // Create the AlertDialog object and return it
        builder.create().show();

    }




}
