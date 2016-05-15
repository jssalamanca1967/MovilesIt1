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

import co.edu.uniandes.movilesit1.colaEmail.ColaEmail;
import co.edu.uniandes.movilesit1.colaEmail.EmailAEnviar;
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

        if(ayudante.emails.size() == 0) {

            ayudante.emails.add("js.salamanca1967@uniandes.edu.co");
            ayudante.emails.add("johnsalas99@hotmail.com");
        }

        poblarLista();

    }

    public void cancelar(View view) {

        Intent intent = new Intent(this, ReporteActivity.class);

        startActivity(intent);

    }

    public void enviarCorreo(View view) {

        ayudante = Ayudante.darInstancia();

        String mensaje = "Las cámaras a instalar serán las siguientes:";

        for(int i = 0; i < ayudante.camarasReporte.size(); i++){

            Camara camara = ayudante.camarasReporte.get(i);

            mensaje += "Cámara " + (i+1);
            mensaje += "Código de Barras: " + camara.codigoBarras + "\nResolución: "
                    + camara.videoQuality + "\nIluminación mínima: "
                    + camara.minimumIllumination + "\nModos de día - noche: "
                    + camara.dayNightMode + "\nCompensación de luz de fondo: "
                    + camara.backlightCompensation + "\nÁngulo de visión: "
                    + camara.viewingAngle + "\nDistancia de visión nocturna: "
                    + camara.nightVisionDistance + "\nFiltro de corte de infrarrojo: "
                    + camara.iRCutFilter + "\nInteriores / Exteriores: "
                    + camara.indoorOutdoor + "\nConsumo de energía: "
                    + camara.operatingPower + "\nTemperatura de operación: "
                    + camara.operationTemperature + "\nMaterial: "
                    + camara.bodyConstruction + "\nDimensiones: "
                    + camara.cameraStandDimensions + "\nPeso: " + camara.cameraStandWeight;

        }

        String[] email = new String[ayudante.emails.size()];

        for(int i = 0; i < email.length; i++){
            email[i] = ayudante.emails.get(i);
        }

        try {
            Email.enviarCorreo(mensaje, email);
            Mensajes.toast(this,"Reporte enviado con éxito", true);
            Intent intent = new Intent(this, Principal.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            EmailAEnviar a = new EmailAEnviar(mensaje, email);
            ColaEmail cola = ColaEmail.darInstancia();
            cola.emailAEnviar.add(a);
            Mensajes.alertDialog(this, "No se pudo enviar el e-mail, se enviará apenas se tenga conexión.");
        }
    }

    public void agregarCorreo(View view) {

        Intent intent = new Intent(this, AgregarEmailActivity.class);

        startActivity(intent);
    }

    public void poblarLista(){

        ayudante = Ayudante.darInstancia();

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

        ayudante = Ayudante.darInstancia();

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
