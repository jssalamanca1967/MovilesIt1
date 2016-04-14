package co.edu.uniandes.movilesit1.modelo;

import java.util.ArrayList;

import co.edu.uniandes.movilesit1.database.DBAdmin;

/**
 * Created by John on 13/04/2016.
 */
public class Ayudante {

    public static Ayudante instancia;
    public static DBAdmin dbAdmin;
    public static ArrayList<Camara> camarasActuales;
    public static ArrayList<Camara> camarasReporte;
    public static ArrayList<String> emails;

    public Ayudante(){

        camarasActuales = new ArrayList<>();
        camarasReporte = new ArrayList<>();
        emails = new ArrayList<>();
    }

    public static Ayudante darInstancia(){
        if(instancia == null)
            instancia = new Ayudante();
        return instancia;
    }
}
