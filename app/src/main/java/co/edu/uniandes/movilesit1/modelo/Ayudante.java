package co.edu.uniandes.movilesit1.modelo;

import java.util.ArrayList;

import co.edu.uniandes.movilesit1.database.DBAdmin;

/**
 * Created by John on 13/04/2016.
 */
public class Ayudante {

    public static Ayudante instancia;
    public DBAdmin dbAdmin;
    public ArrayList<Camara> camarasActuales;
    public ArrayList<Camara> camarasReporte;
    public ArrayList<String> emails;
    public String a = "[\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cdf13b3770ebebcf39\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"2 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"106 grados\",\n" +
            "    \"nightVisionDistance\": \"33m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP63\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-19°C ~ 59°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"174 mm(Ancho) , 149 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"391 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cd0caa3f0de0d9779a\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"6 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"61 grados\",\n" +
            "    \"nightVisionDistance\": \"41m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP65\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-9°C ~ 55°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"178 mm(Ancho) , 113 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"271 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cd806a8a21acf9f84f\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"9 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"105 grados\",\n" +
            "    \"nightVisionDistance\": \"2m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP60\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-19°C ~ 46°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"121 mm(Ancho) , 170 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"330 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cdc2047aa16c80da51\",\n" +
            "    \"videoQuality\": \"144p\",\n" +
            "    \"minimumIllumination\": \"8 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"65 grados\",\n" +
            "    \"nightVisionDistance\": \"1m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP68\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-7°C ~ 59°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"132 mm(Ancho) , 143 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"368 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cdfe4825479f082a64\",\n" +
            "    \"videoQuality\": \"720p\",\n" +
            "    \"minimumIllumination\": \"8 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"119 grados\",\n" +
            "    \"nightVisionDistance\": \"19m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP66\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-24°C ~ 59°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"145 mm(Ancho) , 101 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"355 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cdbfb96a8f5ca1d731\",\n" +
            "    \"videoQuality\": \"144p\",\n" +
            "    \"minimumIllumination\": \"4 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"64 grados\",\n" +
            "    \"nightVisionDistance\": \"26m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP63\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-4°C ~ 46°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"191 mm(Ancho) , 136 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"224 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cd3ccc517223245925\",\n" +
            "    \"videoQuality\": \"360p\",\n" +
            "    \"minimumIllumination\": \"8 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"94 grados\",\n" +
            "    \"nightVisionDistance\": \"15m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP63\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-30°C ~ 63°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"126 mm(Ancho) , 157 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"238 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cde6ab722b1f73fd5d\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"6 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"74 grados\",\n" +
            "    \"nightVisionDistance\": \"26m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP60\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-30°C ~ 59°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"197 mm(Ancho) , 162 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"291 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cdd767a12a6dbed07f\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"9 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"56 grados\",\n" +
            "    \"nightVisionDistance\": \"19m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP65\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-9°C ~ 22°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"126 mm(Ancho) , 166 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"376 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"codigoBarras\": \"571455cd414307deebbf4351\",\n" +
            "    \"videoQuality\": \"144p\",\n" +
            "    \"minimumIllumination\": \"4 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"54 grados\",\n" +
            "    \"nightVisionDistance\": \"4m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP63\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-30°C ~ 34°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"132 mm(Ancho) , 196 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"341 g\"\n" +
            "  }\n" +
            "]";
    public Ayudante(){

        camarasActuales = new ArrayList<>();
        camarasReporte = new ArrayList<>();
        emails = new ArrayList<>();
    }

    public static Ayudante darInstancia(){
        if(instancia == null)
            instancia = new Ayudante();
        return instancia;
    }
}
