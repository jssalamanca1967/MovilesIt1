package co.edu.uniandes.movilesit1;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import co.edu.uniandes.movilesit1.modelo.Ayudante;
import co.edu.uniandes.movilesit1.modelo.Camara;

/**
 * Created by Fabian on 15/05/2016.
 */
public class SensorProximidadActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private static final int TEST_LUZ = Sensor.TYPE_LIGHT;
    private Sensor proximidad;
    private float currentDistance = 0;
    private float maxDistance = 0;
    private TextView txtResultado;
    private boolean yaValio;
    public Camara camara;
    private TextView txtY;

    public Ayudante ayudante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_proximidad);
        txtY = (TextView) findViewById(R.id.txtY);
        yaValio = false;

        txtResultado = (TextView) findViewById(R.id.txtResultado);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        proximidad = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, proximidad, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        yaValio = false;
        sensorManager.registerListener(this, proximidad , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ayudante = Ayudante.darInstancia();
        Sensor sensor = event.sensor;
        if (sensor.getType() == TEST_LUZ) {
            currentDistance = event.values[0];
            float maxDistanceLocal = 0;

            try {
                for (int i = 0; i < ayudante.camarasReporte.size(); i++) {
                    if (currentDistance > maxDistanceLocal)
                        maxDistanceLocal = currentDistance;
                    camara = ayudante.camarasReporte.get(i);
                    int luz = 0;
                    String distanciaMaxima = camara.nightVisionDistance;
                    String division [] = distanciaMaxima.split(" ");
                    txtY.setText("" + (currentDistance/100)  + " m");
                    maxDistance = Float.parseFloat(division[0]);
                    if (maxDistanceLocal > maxDistance ){
                        txtResultado.setText("NO ADECUADA");
                        txtResultado.setTextColor(Color.rgb(255, 0, 0));
                        yaValio = true;
                    } else {
                        if (!yaValio) {
                            txtResultado.setText("ADECUADA");
                           txtResultado.setTextColor(Color.rgb(0, 255, 0));
                        }
                    }
                }
            }
            catch(Exception e){
                Mensajes.alertDialog(this, "Hubo un error en la lista de las camaras: " + e.getMessage());
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.registerListener(this, proximidad, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void reiniciar(View view) {
        yaValio = false;
        sensorManager.unregisterListener(this, proximidad);
    }
}
