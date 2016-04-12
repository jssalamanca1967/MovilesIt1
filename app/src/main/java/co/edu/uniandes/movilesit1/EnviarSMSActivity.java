package co.edu.uniandes.movilesit1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import co.edu.uniandes.movilesit1.modelo.Camara;

public class EnviarSMSActivity extends AppCompatActivity {

    private final static int ESCOGER_CONTACTO = 1;
    private final static int DIALOGO_ERROR = 2;
    private final static int DIALOGO_ENVIO_OK = 3;
    private final static int DIALOGO_ERROR_DATOS = 4;
    private Button btContactos;
    private String nombreContacto;
    private String numeroTelefonico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_sms);
    }

    /**
     * Envía un mensaje de texto al contacto seleccionado
     */
    public void enviarSMS(View v) {
        if(numeroTelefonico != null ){
            try{
                String mensaje = "Las cámaras a instalar serán las siguientes:";

                for(int i = 0; i < Principal.camarasReporte.size(); i++){

                    Camara camara = Principal.camarasReporte.get(i);

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


                SmsManager manejador = SmsManager.getDefault();
//                ArrayList<String> parts = manejador.divideMessage(mensaje);
//
//                ArrayList<PendingIntent> sendList = new ArrayList<>();
//                sendList.add(sentPI);
//
//                ArrayList<PendingIntent> deliverList = new ArrayList<>();
//                deliverList.add(deliveredPI);
//
//                sms.sendMultipartTextMessage(phoneNumber, null, parts, sendList, deliverList);

                mensaje = "Test message";

                try {
                    manejador.sendTextMessage(numeroTelefonico, null, mensaje, null, null);

                    Log.i("SMS", "Se envió el mensaje correctamente");
                } catch (Exception e) {
                    Log.i("SMS", "No se envió el mensaje, excepción: "+e.getMessage());
                }
                showDialog(DIALOGO_ENVIO_OK);

            }catch(Exception e){
                Mensajes.alertDialog(this, "Hubo un error en el envío del mensaje: " + e.getMessage());
            }


        }else{
            Mensajes.alertDialog(this, "No se escogión un teléfono de contacto para enviar el mensaje.");
        }
    }

    /**
     * Muestra la actividad de selección de contactos invocando las funciones del dispositivo
     */
    public void mostrarSeleccionContactos(View v) {
        startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),ESCOGER_CONTACTO);
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        nombreContacto = "";
        if(resultCode == RESULT_OK){
            if(reqCode == ESCOGER_CONTACTO){
                Uri uriContacto = data.getData();
                if(uriContacto != null ){
                    try {
                        String[] cols = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
                        Cursor cursor =  managedQuery(uriContacto, cols, null, null, null);
                        cursor.moveToFirst();
                        nombreContacto = cursor.getString(0);

                        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                        String[] columnas = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                        String seleccion = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "='" + nombreContacto + "'";
                        Cursor c = managedQuery(phoneUri,columnas,seleccion,null, null );
                        if(c.moveToFirst()){
                            numeroTelefonico = c.getString(0);
                        }

                    } catch (Exception e) {
                        numeroTelefonico = e.getMessage();

                        showDialog(DIALOGO_ERROR);
                    }
                    btContactos = (Button) findViewById(R.id.btnEscogerContacto);
                    btContactos.setText(nombreContacto + "(Cambiar)");
                }
            }
        }

    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOGO_ERROR:
                return crearDialogo("No fue posible recuperar la información del contacto.");
            case DIALOGO_ENVIO_OK:
                return crearDialogo("Se ha enviado el mensaje a " + nombreContacto);
            case DIALOGO_ERROR_DATOS:
                return crearDialogo("No ha seleccionado un contacto o este no tiene un número telefónico.");
        }

        return null;
    }

    /**
     * Crea un dialogo con el mensaje que llega por parámetro
     * @param mensaje el mensaje que se desea desplegar
     * @return el dialogo con el mensaje a mostrar
     */
    private Dialog crearDialogo(String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensaje);
        builder.setCancelable(false);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                finish();
            }
        });
        AlertDialog alert = builder.create();
        return alert;
    }
}
