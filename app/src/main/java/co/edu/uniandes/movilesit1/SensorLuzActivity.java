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
public  class SensorLuzActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private static final int TEST_LUZ = Sensor.TYPE_LIGHT;
    private Sensor luz;
    private float currentLux = 0;
    private float maxLux = 0;
    private TextView txtResultado;
    private boolean yaValio;
    public Camara camara;
    private TextView txtY;

    public Ayudante ayudante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_luz);
        txtY = (TextView) findViewById(R.id.txtY);
        yaValio = false;

        txtResultado = (TextView) findViewById(R.id.txtResultado);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        luz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, luz, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        yaValio = false;
        sensorManager.registerListener(this, luz , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ayudante = Ayudante.darInstancia();
        Sensor sensor = event.sensor;
        if (sensor.getType() == TEST_LUZ) {
            currentLux = event.values[0];
            if (currentLux > maxLux)
                maxLux = currentLux;
            try {
                for (int i = 0; i < ayudante.camarasReporte.size(); i++) {

                    camara = ayudante.camarasReporte.get(i);
                    int luz = 0;
                    String illumination = camara.minimumIllumination;
                    String division [] = illumination.split(" ");
                    txtY.setText("" + maxLux  + " lux");
                    if (maxLux < Double.parseDouble(division[0])){
                        txtResultado.setText("NO COLOCAR");
                        txtResultado.setTextColor(Color.rgb(255, 0, 0));
                        yaValio = true;
                    } else {
                        if (!yaValio) {
                            txtResultado.setText("COLOCAR");
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
        sensorManager.registerListener(this, luz, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void reiniciar(View view) {
        yaValio = false;
        sensorManager.unregisterListener(this, luz);
    }

}
