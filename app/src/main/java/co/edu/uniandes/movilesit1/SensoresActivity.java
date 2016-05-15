package co.edu.uniandes.movilesit1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensoresActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor magnetismo;
    private Sensor acelerometro;

    private static final int TEST_GRAV = Sensor.TYPE_ACCELEROMETER;
    private static final int TEST_MAG = Sensor.TYPE_MAGNETIC_FIELD;

    private final float alpha = (float) 0.8;
    private float gravity[] = new float[3];
    private float magnetic[] = new float[3];

    private TextView txtX;
    private TextView txtY;
    private TextView txtZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);

        txtX = (TextView) findViewById(R.id.txtX);
        txtY = (TextView) findViewById(R.id.txtY);
        txtZ = (TextView) findViewById(R.id.txtZ);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        magnetismo = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this, magnetismo, SensorManager.SENSOR_DELAY_NORMAL);

        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);




    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, magnetismo, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor sensor = event.sensor;
        if (sensor.getType() == TEST_GRAV) {
            // Isolate the force of gravity with the low-pass filter.
            gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
            gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
            gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
        } else if (sensor.getType() == TEST_MAG) {

            magnetic[0] = event.values[0];
            magnetic[1] = event.values[1];
            magnetic[2] = event.values[2];

            float[] R = new float[9];
            float[] I = new float[9];
            SensorManager.getRotationMatrix(R, I, gravity, magnetic);
            float [] A_D = event.values.clone();
            float [] A_W = new float[3];
            A_W[0] = R[0] * A_D[0] + R[1] * A_D[1] + R[2] * A_D[2];
            A_W[1] = R[3] * A_D[0] + R[4] * A_D[1] + R[5] * A_D[2];
            A_W[2] = R[6] * A_D[0] + R[7] * A_D[1] + R[8] * A_D[2];


            txtX.setText("" + A_W[0]);
            txtY.setText("" + A_W[1]);
            txtZ.setText("" + A_W[2]);

        }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onResume();
        sensorManager.registerListener(this, magnetismo, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
