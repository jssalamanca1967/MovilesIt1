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
            "    \"nombre\": \"Arlo IP2M200\",\n" +
            "    \"codigoBarras\": \"5737e65406d7f484a3632340\",\n" +
            "    \"videoQuality\": \"720p\",\n" +
            "    \"minimumIllumination\": \"8 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"63 grados\",\n" +
            "    \"nightVisionDistance\": \"27m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP60\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-6°C ~ 36°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"166 mm(Ancho) , 198 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"378 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Arlo HR276\",\n" +
            "    \"codigoBarras\": \"5737e65471f546c98a9db245\",\n" +
            "    \"videoQuality\": \"144p\",\n" +
            "    \"minimumIllumination\": \"10 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"65 grados\",\n" +
            "    \"nightVisionDistance\": \"33m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP67\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-21°C ~ 64°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"100 mm(Ancho) , 134 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"349 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Arlo VZ89\",\n" +
            "    \"codigoBarras\": \"5737e654d02040249945052b\",\n" +
            "    \"videoQuality\": \"360p\",\n" +
            "    \"minimumIllumination\": \"6 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"80 grados\",\n" +
            "    \"nightVisionDistance\": \"50m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP68\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-1°C ~ 26°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"200 mm(Ancho) , 194 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"297 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Arlo VZ256\",\n" +
            "    \"codigoBarras\": \"5737e6546f2fe1d7d28f2067\",\n" +
            "    \"videoQuality\": \"144p\",\n" +
            "    \"minimumIllumination\": \"7 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"69 grados\",\n" +
            "    \"nightVisionDistance\": \"24m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP60\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-5°C ~ 43°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"183 mm(Ancho) , 153 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"369 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Ouvis IP2M285\",\n" +
            "    \"codigoBarras\": \"5737e6541e9b4903bc2eace4\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"10 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"98 grados\",\n" +
            "    \"nightVisionDistance\": \"49m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP66\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-24°C ~ 53°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"135 mm(Ancho) , 110 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"203 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Zmodo HR90\",\n" +
            "    \"codigoBarras\": \"5737e6546d614c6214845c0a\",\n" +
            "    \"videoQuality\": \"1080p\",\n" +
            "    \"minimumIllumination\": \"3 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"79 grados\",\n" +
            "    \"nightVisionDistance\": \"42m\",\n" +
            "    \"iRCutFilter\": \"Si\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP65\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-27°C ~ 47°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"178 mm(Ancho) , 168 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"367 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Amcrest IP2M270\",\n" +
            "    \"codigoBarras\": \"5737e6546fa58dec6f3b54e8\",\n" +
            "    \"videoQuality\": \"720p\",\n" +
            "    \"minimumIllumination\": \"9 lux\",\n" +
            "    \"dayNightMode\": \"Día: B&W, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"74 grados\",\n" +
            "    \"nightVisionDistance\": \"6m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP62\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-26°C ~ 52°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"142 mm(Ancho) , 179 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"275 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"WALI SC225\",\n" +
            "    \"codigoBarras\": \"5737e6547f4a8051b8f99a61\",\n" +
            "    \"videoQuality\": \"1080p\",\n" +
            "    \"minimumIllumination\": \"4 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: Color\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"107 grados\",\n" +
            "    \"nightVisionDistance\": \"39m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP62\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-3°C ~ 36°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"174 mm(Ancho) , 148 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"378 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Arlo IP2M286\",\n" +
            "    \"codigoBarras\": \"5737e6542128da506c201f1c\",\n" +
            "    \"videoQuality\": \"480p\",\n" +
            "    \"minimumIllumination\": \"5 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"No\",\n" +
            "    \"viewingAngle\": \"74 grados\",\n" +
            "    \"nightVisionDistance\": \"23m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores y exteriores ,IP65\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-27°C ~ 52°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"188 mm(Ancho) , 160 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"229 g\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nombre\": \"Ezviz VZ94\",\n" +
            "    \"codigoBarras\": \"5737e654a0f10d328784b7d5\",\n" +
            "    \"videoQuality\": \"1080p\",\n" +
            "    \"minimumIllumination\": \"5 lux\",\n" +
            "    \"dayNightMode\": \"Día: Color, Noche: B&W\",\n" +
            "    \"backlightCompensation\": \"Si\",\n" +
            "    \"viewingAngle\": \"116 grados\",\n" +
            "    \"nightVisionDistance\": \"13m\",\n" +
            "    \"iRCutFilter\": \"No\",\n" +
            "    \"indoorOutdoor\": \"Interiores ,IP61\",\n" +
            "    \"operatingPower\": \"DC 12V\",\n" +
            "    \"operationTemperature\": \"-18°C ~ 62°C\",\n" +
            "    \"bodyConstruction\": \"Aluminio\",\n" +
            "    \"cameraStandDimensions\": \"155 mm(Ancho) , 117 mm(Alto)\",\n" +
            "    \"cameraStandWeight\": \"361 g\"\n" +
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
