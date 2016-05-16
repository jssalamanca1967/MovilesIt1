package co.edu.uniandes.movilesit1.mensajeria;

/**
 * Created by John on 11/04/2016.
 */

import android.app.Activity;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Email {

    public static void enviarCorreo(String mensaje, String[] destinatarios) throws Exception {

        final String username = "securecamerainstaller@gmail.com";
        final String password = "contrasenia.27";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        String destino = "";

        Address[] destinos = new Address[destinatarios.length];

        for(int i = 0; i < destinatarios.length; i++){

            destinos[i] = InternetAddress.parse(destinatarios[i])[0];

        }

        if(destinatarios.length == 0){
            throw new Exception("No ha adicionado ningún destinatatio");
        }

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    destinos);
            message.setSubject("Informe instalación");
            message.setText(mensaje);


            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw e;
        }
    }

}
