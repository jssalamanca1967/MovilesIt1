package co.edu.uniandes.movilesit1.modelo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by John on 02/03/2016.
 */
public class Camara {

    public final static String CODIGOBARRAS = "codigoBarras";
    public final static String VIDEOQUALITY = "videoQuality";
    public final static String MINIMUMILLUMINATION = "minimumIllumination";
    public final static String DAYNIGHTMODE = "dayNightMode";
    public final static String BACKLIGHTCOMPENSATION = "backlightCompensation";
    public final static String VIEWINGANGLE = "viewingAngle";
    public final static String NIGHTVISIONDISTANCE = "nightVisionDistance";
    public final static String IRCUTFILTER = "iRCutFilter";
    public final static String INDOOROUTDOOR = "indoorOutdoor";
    public final static String OPERATINGPOWER = "operatingPower";
    public final static String OPERATIONTEMPERATURE = "operationTemperature";
    public final static String BODYCONSTRUCTION = "bodyConstruction";
    public final static String CAMERASTANDDIMENSIONS = "cameraStandDimensions";
    public final static String CAMERASTANDWEIGHT = "cameraStandWeight";


    public boolean seleccionadaReporte;

    public String codigoBarras;

    /**
     * Resolución
     */
    public String videoQuality;

    /**
     * Tipo de iluminación mínima
     */
    public String minimumIllumination;

    /**
     * Características de funcionamiento de día y de noche
     */
    public String dayNightMode;

    /**
     * Compensación de luz posterior
     */
    public String backlightCompensation;

    /**
     * Ángulo de visión
     */
    public String viewingAngle;

    /**
     * Distancia de visión nocturna - Distancia de IR
     */
    public String nightVisionDistance;

    /**
     * Filtro infrarrojo
     */
    public String iRCutFilter;

    /**
     * Funcionamiento en interiores y exteriores
     */
    public String indoorOutdoor;

    /**
     * Voltaje de entrada
     */
    public String operatingPower;

    /**
     * Temperatura de operación
     */
    public String operationTemperature;

    /**
     * Material
     */
    public String bodyConstruction;

    /**
     * Dimensiones
     */
    public String cameraStandDimensions;

    /**
     * Peso
     */
    public String cameraStandWeight;

    /**
     * Id de la cámara en la base de datos
     */
    public int id;

    public Camara(JSONObject camara) throws JSONException {
        id = camara.getInt("id");
        codigoBarras = camara.getString("codigoBarras");
        videoQuality = camara.getString("videoQuality");
        minimumIllumination = camara.getString("minimumIllumination");
        dayNightMode = camara.getString("dayNightMode");
        backlightCompensation = camara.getString("backlightCompensation");
        viewingAngle = camara.getString("viewingAngle");
        nightVisionDistance = camara.getString("nightVisionDistance");
        iRCutFilter = camara.getString("iRCutFilter");
        indoorOutdoor = camara.getString("indoorOutdoor");
        operatingPower = camara.getString("operatingPower");
        operationTemperature = camara.getString("operationTemperature");
        bodyConstruction = camara.getString("bodyConstruction");
        cameraStandDimensions = camara.getString("cameraStandDimensions");
        cameraStandWeight = camara.getString("cameraStandWeight");
    }


    public Camara(String pCodigoBarras, String pvideoQuality,String pminimumIllumination,String pdayNightMode,
                  String pbacklightCompensation,String pviewingAngle,String pnightVisionDistance,
                  String piRCutFilter,String pindoorOutdoor,String poperatingPower, String poperationTemperature,
                  String pbodyConstruction,String pcameraStandDimensions, String pcameraStandWeight){

        codigoBarras = pCodigoBarras;
        videoQuality = pvideoQuality;
        minimumIllumination = pminimumIllumination;
        dayNightMode = pdayNightMode;
        backlightCompensation = pbacklightCompensation;
        viewingAngle = pviewingAngle;
        nightVisionDistance = pnightVisionDistance;
        iRCutFilter = piRCutFilter;
        indoorOutdoor = pindoorOutdoor;
        operatingPower = poperatingPower;
        operationTemperature = poperationTemperature;
        bodyConstruction = pbodyConstruction;
        cameraStandDimensions = pcameraStandDimensions;
        cameraStandWeight = pcameraStandWeight;


    }

    public void cambiarSeleccionReporte(){
        if(seleccionadaReporte)
            seleccionadaReporte = false;
        else
            seleccionadaReporte = true;
    }


    public String toString(){
        return codigoBarras;
    }




}
