/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.services;

import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.javamail.core.Email;
import edu.eci.pdsw.aeci.javamail.core.EmailConfiguration;
import edu.eci.pdsw.aeci.javamail.core.EmailSender;
import edu.eci.pdsw.aeci.javamail.core.SimpleEmail;
import edu.eci.pdsw.aeci.javamail.core.SimpleEmailSender;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author estudiante
 */
public class ServicioEnvioCorreos {
    
    
    /*
    Correo y contrase;a actualmente de pruebas
    Correo = pruebapdsw@gmail.com 
    passwordCorreo = holamundo;
    */
    public void aprobado(User destinatario, Request solicitud){
        
    }
    
    public void rechazado(User destinarario, Request solicitud){
        
    }
    
    
    public void EnviarCorreo(String nombre,String correo, String comentario){
        /*boolean envio = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(CorreoFuente, passwordCorreoFuente);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CorreoFuente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject(nombre);
            message.setText(comentario);
            Transport.send(message);
            envio = true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }return envio;*/
        final String from = "aeci@gmail.com";
        final String to = correo;
        final String subject = nombre;
        final String message = comentario;

        Email email = new SimpleEmail(from, to, subject, message);
        EmailSender sender = new SimpleEmailSender(new EmailConfiguration());
        try {
            sender.send(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
