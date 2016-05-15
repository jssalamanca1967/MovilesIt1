package co.edu.uniandes.movilesit1.colaEmail;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.os.Build;

import java.util.ArrayList;

/**
 * Created by John on 12/04/2016.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ColaEmail implements ConnectivityManager.OnNetworkActiveListener {

    public ArrayList<EmailAEnviar> emailAEnviar;

    private static ColaEmail instancia;

    private ColaEmail(){
        emailAEnviar = new ArrayList<>();
    }

    public static ColaEmail darInstancia(){
        if(instancia == null){
            instancia = new ColaEmail();
        }
        return instancia;
    }

    @Override
    public void onNetworkActive() {
        if(emailAEnviar.size() > 0){
            ThreadEnviarCola thread = new ThreadEnviarCola();
            thread.start();
        }
    }
}
