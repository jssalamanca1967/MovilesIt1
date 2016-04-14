package co.edu.uniandes.movilesit1;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

        ayudante.dbAdmin = new DBAdmin(getApplicationContext());
    }

    public void poblarDB() {

        ArrayList<Camara> lista = new ArrayList<>();

        for(int i = 0; i < 30; i++){
            Camara nueva = new Camara("123456" + i , "45MP" + i, "12" + i, "34" + i, "45" + i, "67" + i, "34Mt" + i, "45", "45", "324", "235ear", "zdfg", "sdf", "434");
            lista.add(nueva);
        }

        Camara nueva = new Camara("AGMB90201011050" , "45MP", "18", "14" , "45", "28", "12m", "78", "23", "4", "4V", "23", "45", "4");


        ayudante.dbAdmin.agregarCamaras(lista);

    }

    public void verCamaras(View view) {

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
