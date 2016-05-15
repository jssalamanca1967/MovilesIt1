package co.edu.uniandes.movilesit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.uniandes.movilesit1.modelo.Ayudante;

public class AnalizarSensoresActivity extends AppCompatActivity {

    public Ayudante ayudante;
    public int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analizar_sensores);

        String pos = getIntent().getStringExtra("numero");

        posicion = Integer.parseInt(pos);

    }

    public void magnetismo(View view) {

        Intent intent = new Intent(this, SensoresActivity.class);

        intent.putExtra("Tipo","Temperatura");
        startActivity(intent);

    }

    public void proximidad(View view) {
    }

    public void luminosidad(View view) {
    }
}
