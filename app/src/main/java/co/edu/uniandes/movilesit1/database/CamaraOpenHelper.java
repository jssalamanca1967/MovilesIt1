package co.edu.uniandes.movilesit1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import co.edu.uniandes.movilesit1.modelo.Camara;

/**
 * Created by John on 02/03/2016.
 */
public class CamaraOpenHelper extends SQLiteOpenHelper {

    private static final String PK = " PRIMARY KEY ";
    private static final String TEXT = " TEXT ";
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "camara.db";
    public static final String CAMARA_TABLE_NAME = "camara";
    private static final String COMA = ",";


    private static final String crearTabla = "CREATE TABLE " + CAMARA_TABLE_NAME + "(" +
            Camara.NOMBRE + TEXT + COMA + Camara.CODIGOBARRAS + TEXT + PK + COMA
            + Camara.VIDEOQUALITY + TEXT + COMA + Camara.MINIMUMILLUMINATION + TEXT + COMA +
            Camara.DAYNIGHTMODE + TEXT + COMA + Camara.BACKLIGHTCOMPENSATION + TEXT + COMA +
            Camara.VIEWINGANGLE + TEXT + COMA + Camara.NIGHTVISIONDISTANCE + TEXT + COMA +
            Camara.IRCUTFILTER + TEXT + COMA + Camara.INDOOROUTDOOR + TEXT + COMA +
            Camara.OPERATINGPOWER + TEXT + COMA + Camara.OPERATIONTEMPERATURE + TEXT + COMA +
            Camara.BODYCONSTRUCTION + TEXT + COMA + Camara.CAMERASTANDDIMENSIONS + TEXT + COMA +
            Camara.CAMERASTANDWEIGHT + TEXT + ");";



    public CamaraOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS " + CAMARA_TABLE_NAME);
        db.execSQL(crearTabla);

        System.out.println("----------------------------- Se creó correctamente");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);

    }
}
