package co.edu.uniandes.movilesit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.uniandes.movilesit1.lectorCodigoBarras.PrincipalLectorActivity;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


    }

    public void leerCodigoBarras(View view) {

        Intent intent = new Intent(this, PrincipalLectorActivity.class);

        startActivity(intent);

    }
}
