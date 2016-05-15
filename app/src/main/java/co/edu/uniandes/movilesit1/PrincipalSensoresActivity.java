package co.edu.uniandes.movilesit1;

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

public class PrincipalSensoresActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    public Ayudante ayudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_sensores);

        System.out.println("" + ayudante);

        ayudante = Ayudante.darInstancia();

        Camara[] camaras = new Camara[ayudante.camarasReporte.size()];

        for(int i = 0; i < camaras.length; i++){
            camaras[i] = ayudante.camarasReporte.get(i);
        }

        ListView lista = (ListView) findViewById(R.id.listaCamarasSensores);

        ArrayAdapter<Camara> adapter = new ArrayAdapter<Camara>(this,
                android.R.layout.simple_list_item_1, camaras);

        lista.setOnItemClickListener(this);

        lista.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ListView lista = (ListView) findViewById(R.id.listaCamarasSensores);

        Camara item = (Camara) lista.getAdapter().getItem(position);

        Intent intent = new Intent(this, AnalizarSensoresActivity.class);

        intent.putExtra("numero", "" + position);

        startActivity(intent);

    }
}
