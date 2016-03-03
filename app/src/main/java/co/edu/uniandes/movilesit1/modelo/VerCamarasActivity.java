package co.edu.uniandes.movilesit1.modelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import co.edu.uniandes.movilesit1.Mensajes;
import co.edu.uniandes.movilesit1.Principal;
import co.edu.uniandes.movilesit1.R;

public class VerCamarasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_camaras);

        Camara[] camaras = new Camara[Principal.camarasActuales.size()];

        for(int i = 0; i < camaras.length; i++){
            camaras[i] = Principal.camarasActuales.get(i);
        }

        ListView lista = (ListView) findViewById(R.id.listaCamaras);

        ArrayAdapter<Camara> adapter = new ArrayAdapter<Camara>(this,
                android.R.layout.simple_list_item_1, camaras);

        lista.setOnItemClickListener(this);

        lista.setAdapter(adapter);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ListView lista = (ListView) findViewById(R.id.listaCamaras);

        Camara item = (Camara) lista.getAdapter().getItem(position);

        Intent intent = new Intent(this, InfoCamaraActivity.class);

        intent.putExtra("numero", "" + position);

        startActivity(intent);

    }
}
