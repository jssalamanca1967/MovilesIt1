package co.edu.uniandes.movilesit1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import co.edu.uniandes.movilesit1.modelo.Camara;

/**
 * Created by John on 02/03/2016.
 */
public class DBAdmin {

    public CamaraOpenHelper mDbHelper;

    public DBAdmin(Context context){
        mDbHelper = new CamaraOpenHelper(context);
    }

    public void agregarCamaras(ArrayList<Camara> camaras){

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        mDbHelper.onUpgrade(db,1,1);

        ContentValues values = new ContentValues();

        for(int i = 0; i < camaras.size(); i++) {

            Camara camara = camaras.get(i);

            values.put(Camara.CODIGOBARRAS, camara.codigoBarras);
            values.put(Camara.VIDEOQUALITY, camara.videoQuality);
            values.put(Camara.MINIMUMILLUMINATION, camara.minimumIllumination);
            values.put(Camara.DAYNIGHTMODE, camara.dayNightMode);
            values.put(Camara.BACKLIGHTCOMPENSATION, camara.backlightCompensation);
            values.put(Camara.VIEWINGANGLE, camara.viewingAngle);
            values.put(Camara.NIGHTVISIONDISTANCE, camara.nightVisionDistance);
            values.put(Camara.IRCUTFILTER, camara.iRCutFilter);
            values.put(Camara.INDOOROUTDOOR, camara.indoorOutdoor);
            values.put(Camara.OPERATINGPOWER, camara.operatingPower);
            values.put(Camara.OPERATIONTEMPERATURE, camara.operationTemperature);
            values.put(Camara.BODYCONSTRUCTION, camara.bodyConstruction);
            values.put(Camara.CAMERASTANDDIMENSIONS, camara.cameraStandDimensions);
            values.put(Camara.CAMERASTANDWEIGHT, camara.cameraStandWeight);

            long newRowId;
            newRowId = db.insert(
                    CamaraOpenHelper.CAMARA_TABLE_NAME,
                    "null",
                    values);

        }

    }

    public ArrayList<Camara> obtenerCamaras(){

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Camara.CODIGOBARRAS,
                Camara.VIDEOQUALITY,
                Camara.MINIMUMILLUMINATION,
                Camara.DAYNIGHTMODE,
                Camara.BACKLIGHTCOMPENSATION,
                Camara.VIEWINGANGLE,
                Camara.NIGHTVISIONDISTANCE,
                Camara.IRCUTFILTER,
                Camara.INDOOROUTDOOR,
                Camara.OPERATINGPOWER,
                Camara.OPERATIONTEMPERATURE,
                Camara.BODYCONSTRUCTION,
                Camara.CAMERASTANDDIMENSIONS,
                Camara.CAMERASTANDWEIGHT,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Camara.CODIGOBARRAS + " DESC";

        Cursor c = db.query(
                CamaraOpenHelper.CAMARA_TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        ArrayList<Camara> lista = new ArrayList<>();

        String pcodigoBarras = "";
        String pvideoQuality = "";
        String pminimumIllumination = "";
        String pdayNightMode = "";
        String pbacklightCompensation = "";
        String pviewingAngle = "";
        String pnightVisionDistance = "";
        String piRCutFilter = "";
        String pindoorOutdoor = "";
        String poperatingPower = "";
        String poperationTemperature = "";
        String pbodyConstruction = "";
        String pcameraStandDimensions = "";
        String pcameraStandWeight = "";

        c.moveToFirst();

        int encontrados = c.getCount();

        if(encontrados > 0) {

            while (true) {


                pcodigoBarras = c.getString(0);
                pvideoQuality = c.getString(1);
                pminimumIllumination = c.getString(2);
                pdayNightMode = c.getString(3);
                pbacklightCompensation = c.getString(4);
                pviewingAngle = c.getString(5);
                pnightVisionDistance = c.getString(6);
                piRCutFilter = c.getString(7);
                pindoorOutdoor = c.getString(8);
                poperatingPower = c.getString(9);
                poperationTemperature = c.getString(10);
                pbodyConstruction = c.getString(11);
                pcameraStandDimensions = c.getString(12);
                pcameraStandWeight = c.getString(13);

                Camara nueva = new Camara(pcodigoBarras, pvideoQuality, pminimumIllumination, pdayNightMode, pbacklightCompensation, pviewingAngle, pnightVisionDistance, piRCutFilter, pindoorOutdoor, poperatingPower, poperationTemperature, pbodyConstruction, pcameraStandDimensions, pcameraStandWeight);

                lista.add(nueva);

                if (c.isLast())
                    break;

                c.moveToNext();

            }
        }

        c.close();

        return lista;

    }

    public ArrayList<Camara> buscarCamara(String codigoBarras){

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Camara.CODIGOBARRAS,
                Camara.VIDEOQUALITY,
                Camara.MINIMUMILLUMINATION,
                Camara.DAYNIGHTMODE,
                Camara.BACKLIGHTCOMPENSATION,
                Camara.VIEWINGANGLE,
                Camara.NIGHTVISIONDISTANCE,
                Camara.IRCUTFILTER,
                Camara.INDOOROUTDOOR,
                Camara.OPERATINGPOWER,
                Camara.OPERATIONTEMPERATURE,
                Camara.BODYCONSTRUCTION,
                Camara.CAMERASTANDDIMENSIONS,
                Camara.CAMERASTANDWEIGHT,
        };

        String[] valores = {codigoBarras};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Camara.CODIGOBARRAS + " DESC";

        Cursor c = db.query(
                CamaraOpenHelper.CAMARA_TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                Camara.CODIGOBARRAS + "=?",                                // The columns for the WHERE clause
                valores,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        ArrayList<Camara> lista = new ArrayList<>();

        String pcodigoBarras = "";
        String pvideoQuality = "";
        String pminimumIllumination = "";
        String pdayNightMode = "";
        String pbacklightCompensation = "";
        String pviewingAngle = "";
        String pnightVisionDistance = "";
        String piRCutFilter = "";
        String pindoorOutdoor = "";
        String poperatingPower = "";
        String poperationTemperature = "";
        String pbodyConstruction = "";
        String pcameraStandDimensions = "";
        String pcameraStandWeight = "";

        int encontrados = c.getCount();

        System.out.println("sadfhjfgjkgfdsaDAKLFGÑHJKFDSAGHFJKLFGD: " + c.getCount());

        c.moveToFirst();


        if(encontrados > 0) {

            while (true) {

                pcodigoBarras = c.getString(0);
                pvideoQuality = c.getString(1);
                pminimumIllumination = c.getString(2);
                pdayNightMode = c.getString(3);
                pbacklightCompensation = c.getString(4);
                pviewingAngle = c.getString(5);
                pnightVisionDistance = c.getString(6);
                piRCutFilter = c.getString(7);
                pindoorOutdoor = c.getString(8);
                poperatingPower = c.getString(9);
                poperationTemperature = c.getString(10);
                pbodyConstruction = c.getString(11);
                pcameraStandDimensions = c.getString(12);
                pcameraStandWeight = c.getString(13);

                Camara nueva = new Camara(pcodigoBarras, pvideoQuality, pminimumIllumination,
                        pdayNightMode, pbacklightCompensation, pviewingAngle, pnightVisionDistance,
                        piRCutFilter, pindoorOutdoor, poperatingPower, poperationTemperature,
                        pbodyConstruction, pcameraStandDimensions, pcameraStandWeight);

                lista.add(nueva);

                if (c.isLast())
                    break;

                c.moveToNext();

            }
        }

        c.close();

        return lista;

    }

}
