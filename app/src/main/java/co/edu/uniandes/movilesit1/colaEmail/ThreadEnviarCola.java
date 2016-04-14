package co.edu.uniandes.movilesit1.colaEmail;

import co.edu.uniandes.movilesit1.mensajeria.Email;

/**
 * Created by John on 12/04/2016.
 */
public class ThreadEnviarCola extends Thread{

    public void run(){

        ColaEmail cola = ColaEmail.darInstancia();

        for(int i = 0; i < cola.emailAEnviar.size(); i++){
            EmailAEnviar mail = cola.emailAEnviar.get(i);
            try{
                Email.enviarCorreo(mail.mensaje, mail.destinatarios);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        cola.emailAEnviar.clear();
    }


}
