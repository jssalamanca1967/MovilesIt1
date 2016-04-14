package co.edu.uniandes.movilesit1.colaEmail;

/**
 * Created by John on 12/04/2016.
 */
public class EmailAEnviar {

    public String mensaje;
    public String[] destinatarios;

    public EmailAEnviar(String pMensaje, String[] pDestinatarios){
        mensaje = pMensaje;
        destinatarios = pDestinatarios;
    }
}
