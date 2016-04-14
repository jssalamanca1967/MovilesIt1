package co.edu.uniandes.movilesit1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import co.edu.uniandes.movilesit1.mensajeria.Email;
import co.edu.uniandes.movilesit1.modelo.Ayudante;
import co.edu.uniandes.movilesit1.modelo.Camara;

public class EmailActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    public ListView lista;
    public Ayudante ayudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        ayudante = Ayudante.darInstancia();

        ayudante.emails.add("js.salamanca1967@uniandes.edu.co");

        poblarLista();

    }

    public void cancelar(View view) {

        Intent intent = new Intent(this, ReporteActivity.class);

        startActivity(intent);

    }

    public void enviarCorreo(View view) {

        String mensaje = "Las cámaras a instalar serán las siguientes:";

        for(int i = 0; i < ayudante.camarasReporte.size(); i++){

            Camara camara = ayudante.camarasReporte.get(i);

            mensaje += "Cámara " + (i+1);
            mensaje += "Código de Barras: " + camara.codigoBarras + "Resolución: "
                    + camara.videoQuality + "Iluminación mínima: "
                    + camara.minimumIllumination + "Modos de día - noche: "
                    + camara.dayNightMode + "Compensación de luz de fondo: "
                    + camara.backlightCompensation + "Ángulo de visión: "
                    + camara.viewingAngle + "Distancia de visión nocturna: "
                    + camara.nightVisionDistance + "Filtro de corte de infrarrojo: "
                    + camara.iRCutFilter + "Interiores / Exteriores: "
                    + camara.indoorOutdoor + "Consumo de energía: "
                    + camara.operatingPower + "Temperatura de operación: "
                    + camara.operationTemperature + "Material: "
                    + camara.bodyConstruction + "Dimensiones: "
                    + camara.cameraStandDimensions + "Peso: " + camara.cameraStandWeight;

        }

        String[] email = new String[ayudante.emails.size()];

        for(int i = 0; i < email.length; i++){
            email[i] = ayudante.emails.get(i);
        }

        try {
            Email.enviarCorreo(mensaje, email);
        } catch (Exception e) {
            Mensajes.alertDialog(this, e.getMessage());
        }
    }

    public void agregarCorreo(View view) {

        Intent intent = new Intent(this, AgregarEmailActivity.class);

        startActivity(intent);
    }

    public void poblarLista(){

        String[] email = new String[ayudante.emails.size()];

        for(int i = 0; i < email.length; i++){
            email[i] = ayudante.emails.get(i);
        }

        lista = (ListView) findViewById(R.id.listaMail);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, email);

        lista.setOnItemLongClickListener(this);

        lista.setAdapter(adapter);


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        String mail = ayudante.emails.get(position);
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea eliminar el correo " + mail + "?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ayudante.emails.remove(position);
                        poblarLista();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        builder.create().show();

        return false;
    }

}
