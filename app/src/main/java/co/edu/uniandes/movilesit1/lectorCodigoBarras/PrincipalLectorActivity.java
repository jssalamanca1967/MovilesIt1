package co.edu.uniandes.movilesit1.lectorCodigoBarras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.uniandes.movilesit1.Mensajes;
import co.edu.uniandes.movilesit1.R;


public class PrincipalLectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_lector);
    }

    public void leerCodigoBarras(View view) {

        Mensajes.toast(this, "Cargando", true);
        Mensajes.alertDialog(this, "Estamos cargando");

    }
}
