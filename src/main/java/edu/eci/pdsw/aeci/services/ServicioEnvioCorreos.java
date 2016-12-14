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
    
    public String CorreoFuente = "pruebapdsw@gmail.com";
    public String passwordCorreoFuente = "holamundo";
    
    /*
    Correo y contrase;a actualmente de pruebas
    Correo = pruebapdsw@gmail.com 
    passwordCorreo = holamundo;
    */
    
    /**
     * 
     * @param destinatario The email of destiny
     * @param solicitud the approved request
     */
    public void aprobado(User destinatario, Request solicitud){
        String comentario="Buenas tardes Ingeniero(a) "+destinatario.getFirstName()+" "+destinatario.getLastName()+"\n";
        comentario+="\n Se le informa que su solicitud a la asociacion de egresado de la Escuela Colombiana de Ingenieria ha sido aprobada";
        comentario+="\n"+solicitud.getCommentary()+"\n Se le informa que para ingresa su usuario y contraseña actual son su numero de cedula. \n";
        comentario+=" \nAtentamente AECI.";
        this.EnviarCorreo(destinatario.getFirstName()+" "+destinatario.getLastName(), destinatario.getEmail(), comentario);
    }
    
    /**
     * 
     * @param destinatario the person who receives the email
     */
    public void recordatorio(User destinatario){
        String comentario="Buenas tardes Ingeniero(a) "+destinatario.getFirstName()+" "+destinatario.getLastName()+"\n";
        comentario="\n Se le informa que su solicitud esta por vencerse proximamente";
        comentario+=" por lo cual le aconsejamos renovarla proximamente, para más información de como renovarla puede consultar nuestra página.";
        comentario+="\n \nAtentamente AECI.";
        this.EnviarCorreo(destinatario.getFirstName()+" "+destinatario.getLastName(), destinatario.getEmail(), comentario);
    }
    
    /**
     * 
     * @param destinatario the person who receives the email
     * @param solicitud the rejected request
     */
    public void rechazado(User destinatario, Request solicitud){
        String comentario="Buenas tardes Ingeniero(a) "+destinatario.getFirstName()+" "+destinatario.getLastName()+"\n";
        comentario+="\n Se le informa que su solicitud a la asociacion de egresado de la Escuela Colombiana de Ingenieria ha sido rechazada";
        comentario="por:\n"+solicitud.getCommentary()+"\nEsperamos el envío de su solicitud en una próxima ocasión";
        comentario+="\nAtentamente AECI";
        this.EnviarCorreo(destinatario.getFirstName()+" "+destinatario.getLastName(), destinatario.getEmail(), comentario);
    }
    
    /**
     * 
     * Informa que ha llegado una nueva solicitud
     * @param usuario The user who sent the request
     * @param date the date that was sent the request
     */
    public void EnvioDeSolicitud(User usuario,Date date){
        String comentario="Buenas tardes Administrador \n";
        comentario="Se le informa que la persona "+usuario.getFirstName()+" "+usuario.getLastName()+" ha hecho una solicitud ";
        comentario+= "para el ingreso a la asociacion el dia "+date+", te recomendamos revisarla directamente en la página";
        comentario+=" de la asociacion. \n\n";
        comentario+="Atentamente los Desarrolladores de la aplicacion =).";
        this.EnviarCorreo("ADMINISTRADOR", CorreoFuente, comentario);
    }
    
    /**
     * 
     * @param nombre The name of the addressee
     * @param correo The email
     * @param comentario The commentary of the email
     */
    public void EnviarCorreo(String nombre,String correo, String comentario){
        
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
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        /*final String from = "aeci@gmail.com";
        final String to = correo;
        final String subject = nombre;
        final String message = comentario;

        Email email = new SimpleEmail(from, to, subject, message);
        EmailSender sender = new SimpleEmailSender(new EmailConfiguration());
        try {
            sender.send(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/
    }
}
