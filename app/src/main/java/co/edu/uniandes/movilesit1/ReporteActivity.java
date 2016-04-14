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

import co.edu.uniandes.movilesit1.modelo.Ayudante;
import co.edu.uniandes.movilesit1.modelo.Camara;
import co.edu.uniandes.movilesit1.modelo.InfoCamaraActivity;

public class ReporteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener{

    public Ayudante ayudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        ayudante = Ayudante.darInstancia();

        Camara[] camaras = new Camara[ayudante.camarasReporte.size()];

        for(int i = 0; i < camaras.length; i++){
            camaras[i] = ayudante.camarasReporte.get(i);
        }

        ListView lista = (ListView) findViewById(R.id.listaCamarasReporte);

        ArrayAdapter<Camara> adapter = new ArrayAdapter<Camara>(this,
                android.R.layout.simple_list_item_1, camaras);

        lista.setOnItemClickListener(this);

        lista.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ListView lista = (ListView) findViewById(R.id.listaCamarasReporte);

        Camara item = (Camara) lista.getAdapter().getItem(position);

        Mensajes.toast(this, "Cargando información de la cámara", true);

        Intent intent = new Intent(this, InfoCamaraActivity.class);

        intent.putExtra("numero", "" + position);

        startActivity(intent);

    }

    public void generarReporte(View view){

        if(ayudante.camarasReporte.size() == 0){
            Mensajes.alertDialog(this, "No se puede enviar un reporte cuando no se han escogido cámaras");
        }
        else {

            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea enviar el reporte con las cámaras seleccionadas?")
                    .setPositiveButton("Aceptar", this)
                    .setNegativeButton("Cancelar", this);
            // Create the AlertDialog object and return it
            builder.create().show();
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which == DialogInterface.BUTTON_POSITIVE) {
            enviarReporte();
        }

    }

    public void enviarReporte(){

        Intent intent = new Intent(this, EmailActivity.class);

        startActivity(intent);
    }
}
