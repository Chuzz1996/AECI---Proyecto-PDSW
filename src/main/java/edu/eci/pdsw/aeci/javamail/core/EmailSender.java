package edu.eci.pdsw.aeci.javamail.core;

import javax.mail.MessagingException;

public interface EmailSender {

    void send(Email email) throws MessagingException;

}
