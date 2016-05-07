package co.edu.uniandes.movilesit1;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniandes.movilesit1.database.DBAdmin;
import co.edu.uniandes.movilesit1.lectorCodigoBarras.PrincipalLectorActivity;
import co.edu.uniandes.movilesit1.modelo.Ayudante;
import co.edu.uniandes.movilesit1.modelo.Camara;
import co.edu.uniandes.movilesit1.modelo.VerCamarasActivity;
import co.edu.uniandes.movilesit1.web.Rest;

public class Principal extends AppCompatActivity {

    public Ayudante ayudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ayudante = Ayudante.darInstancia();

        ayudante.dbAdmin = new DBAdmin(getApplicationContext());

        crearDB();
        poblarDB();


    }

    public void leerCodigoBarras(View view) {

        Intent intent = new Intent(this, PrincipalLectorActivity.class);

        startActivity(intent);

    }

    public void crearDB() {

        ayudante = Ayudante.darInstancia();

        ayudante.dbAdmin = new DBAdmin(getApplicationContext());
    }

    public void poblarDB() {

        ayudante = Ayudante.darInstancia();

        ArrayList<Camara> lista = new ArrayList<>();


        try {
            JSONArray array = new JSONArray(ayudante.a);

            for(int i = 0; i < array.length(); i++){
                JSONObject objeto = array.getJSONObject(i);

                Camara nuevo = new Camara(objeto);

                lista.add(nuevo);

            }

            ayudante.dbAdmin.agregarCamaras(lista);

        }catch (JSONException e) {
            Mensajes.alertDialog(this, e.getMessage());
        }


        ayudante.dbAdmin.agregarCamaras(lista);

    }

    public void verCamaras(View view) {

        ayudante = Ayudante.darInstancia();

        if(ayudante.camarasActuales == null)
            ayudante.camarasActuales = new ArrayList<>();

        ayudante.camarasActuales.clear();

        try{
            Rest.darCamaras(ayudante.camarasActuales);
        }catch(Exception e){
            e.printStackTrace();
            ayudante.camarasActuales.addAll(ayudante.dbAdmin.obtenerCamaras());
        }

        Intent intent = new Intent(this, VerCamarasActivity.class);


        startActivity(intent);

    }

    public void verCamara(String codigoBarras){

        ayudante = Ayudante.darInstancia();

        if(ayudante.camarasActuales == null)
            ayudante.camarasActuales = new ArrayList<>();

        ayudante.camarasActuales.clear();
        ayudante.camarasActuales.addAll(ayudante.dbAdmin.buscarCamara(codigoBarras));

        System.out.println(ayudante.camarasActuales.size());

        Intent intent = new Intent(this, VerCamarasActivity.class);

        startActivity(intent);

    }

    public void enviarReporte(View view) {

        Intent intent = new Intent(this, ReporteActivity.class);

        startActivity(intent);
    }
}
