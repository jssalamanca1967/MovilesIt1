package co.edu.uniandes.movilesit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class AgregarEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_email);
    }


    public void agregarEmail(View view) {

        EditText email = (EditText) findViewById(R.id.email);

        String mail = email.getText().toString();

        Principal.emails.add(mail);



        volverAEmails();
    }

    public void cancelar(View view) {


        volverAEmails();
    }

    private void volverAEmails() {

        Intent intent = new Intent(this, EmailActivity.class);

        startActivity(intent);
    }
}
