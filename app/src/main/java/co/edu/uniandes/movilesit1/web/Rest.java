package co.edu.uniandes.movilesit1.web;

/**
 * Created by John on 09/04/2016.
 */

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import co.edu.uniandes.movilesit1.modelo.Camara;


public class Rest  {

    public final static String CAMARAS = "http://camerapp.herokuapp.com/api/camaras/";

    public String httpPost(String urlStr, String[] paramName,
                           String[] paramVal) throws Exception {
        URL url = new URL(urlStr);

        URL object=new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");
        JSONObject cred = new JSONObject();

        for(int i = 0; i < paramName.length; i++){
            cred.put(paramName[i], paramVal[i]);
        }

        OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
        wr.write(cred.toString());
        wr.flush();
        //display what returns the POST request
        StringBuilder sb = new StringBuilder();
        int HttpResult =con.getResponseCode();
        if(HttpResult ==HttpURLConnection.HTTP_OK){
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                sb.append(line + "\n");

            }
            br.close();
            System.out.println(""+sb.toString());

        }
        else{
            throw new Exception(con.getResponseMessage());

        }
        con.disconnect();

        return sb.toString();
    }

    public static String httpGet(String urlStr) throws Exception {

        URL url = new URL(urlStr);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("GET");

        int HttpResult =conn.getResponseCode();

        if (HttpResult != HttpURLConnection.HTTP_OK) {
            throw new Exception(conn.getResponseMessage());
        }

        // Buffer the result into a string
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }

        String json = sb.toString();

        rd.close();

        conn.disconnect();

        System.out.println(sb.toString());
        return json;
    }

    public static void darCamaras(ArrayList<Camara> lista) throws Exception {

        String json = httpGet(Rest.CAMARAS);

        JSONArray array = new JSONArray(json);

        for(int i = 0; i < array.length(); i++){
            JSONObject objeto = array.getJSONObject(i);

            Camara nuevo = new Camara(objeto);

            lista.add(nuevo);

        }

    }


}