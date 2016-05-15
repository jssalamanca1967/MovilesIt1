package co.edu.uniandes.movilesit1.modelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniandes.movilesit1.Mensajes;
import co.edu.uniandes.movilesit1.Principal;
import co.edu.uniandes.movilesit1.R;

public class InfoCamaraActivity extends AppCompatActivity {

    public TextView codigoBarras;
    public TextView videoQuality;
    public TextView minimumIllumination;
    public TextView dayNightMode;
    public TextView backlightCompensation;
    public TextView viewingAngle;
    public TextView nightVisionDistance;
    public TextView iRCutFilter;
    public TextView indoorOutdoor;
    public TextView operatingPower;
    public TextView operationTemperature;
    public TextView bodyConstruction;
    public TextView cameraStandDimensions;
    public TextView cameraStandWeight;
    public TextView nombre;


    public Button boton;

    public boolean seleccionada;

    public Camara camara;

    public Ayudante ayudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_camara);

        ayudante = Ayudante.darInstancia();

        String pos = getIntent().getStringExtra("numero");

        int posicion = Integer.parseInt(pos);

        camara = ayudante.camarasActuales.get(posicion);

        nombre = (TextView) findViewById(R.id.nombre);
        codigoBarras = (TextView) findViewById(R.id.codigoBarras);
        videoQuality = (TextView) findViewById(R.id.videoQuality);
        minimumIllumination = (TextView) findViewById(R.id.minimumIllumination);
        dayNightMode = (TextView) findViewById(R.id.dayNightMode);
        backlightCompensation = (TextView) findViewById(R.id.backlightCompensation);
        viewingAngle = (TextView) findViewById(R.id.viewingAngle);
        nightVisionDistance = (TextView) findViewById(R.id.nightVisionDistance);
        iRCutFilter = (TextView) findViewById(R.id.iRCutFilter);
        indoorOutdoor = (TextView) findViewById(R.id.indoorOutdoor);
        operatingPower = (TextView) findViewById(R.id.operatingPower);
        operationTemperature = (TextView) findViewById(R.id.operationTemperature);
        bodyConstruction = (TextView) findViewById(R.id.bodyConstruction);
        cameraStandDimensions = (TextView) findViewById(R.id.cameraStandDimensions);
        cameraStandWeight = (TextView) findViewById(R.id.cameraStandWeight);
        boton = (Button) findViewById(R.id.button);

        nombre.setText(camara.nombre);
        codigoBarras.setText(camara.codigoBarras);
        videoQuality.setText(camara.videoQuality);
        minimumIllumination.setText(camara.minimumIllumination);
        dayNightMode.setText(camara.dayNightMode);
        backlightCompensation.setText(camara.backlightCompensation);
        viewingAngle.setText(camara.viewingAngle);
        nightVisionDistance.setText(camara.nightVisionDistance);
        iRCutFilter.setText(camara.iRCutFilter);
        indoorOutdoor.setText(camara.indoorOutdoor);
        operatingPower.setText(camara.operatingPower);
        operationTemperature.setText(camara.operationTemperature);
        bodyConstruction.setText(camara.bodyConstruction);
        cameraStandDimensions.setText(camara.cameraStandDimensions);
        cameraStandWeight.setText(camara.cameraStandWeight);

        seleccionada = estaEnReporte(camara.codigoBarras);

        if(seleccionada){
            boton.setText("Retirar del reporte");
        }
        else{
            boton.setText("Agregar al reporte");
        }

    }


    public void botonReporte(View view) {

        if(seleccionada){

            eliminarEnReporte(camara.codigoBarras);
            seleccionada = false;
            boton.setText("Agregar al reporte");


            Mensajes.toast(this, "La cámara se ha retirado del reporte", true);


        }
        else{

            ayudante.camarasReporte.add(camara);

            seleccionada = true;
            boton.setText("Retirar del reporte");

            Mensajes.toast(this, "La cámara se ha agregado al reporte", true);


        }

    }

    public boolean estaEnReporte(String codigoBarras){

        boolean rta = false;

        for(int i = 0; i < ayudante.camarasReporte.size(); i++){
            if(ayudante.camarasReporte.get(i).codigoBarras.equals(codigoBarras))
                rta = true;
        }

        return rta;


    }

    public void eliminarEnReporte(String codigoBarras){



        for(int i = 0; i < ayudante.camarasReporte.size(); i++){
            if(ayudante.camarasReporte.get(i).codigoBarras.equals(codigoBarras))
                ayudante.camarasReporte.remove(i);
        }




    }

}
