/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.seguridad;

import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author felipelosada
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class ShiroLoginBean implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(ShiroLoginBean.class);
    private static ServiciosAeci rp = ServiciosAeci.getInstance();
    private String username;
    private String password;
    private Boolean rememberMe;
    private User personaLog;
    
    /**
     * 
     * @return return the subject
     */
    public Subject getSubject(){
        return SecurityUtils.getSubject();
    }
    
    public User getLoggedUser() throws ExcepcionServiciosAeci{
        
        return null;
    }
    
    /**
     * 
     * @param password The password to encrypt
     * @return the password encrypted
     */
    public static String generateHash(String password){
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashIterations(500000);
        hashService.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        
        
        hashService.setPrivateSalt(new SimpleByteSource("myprivatesalt"));
        hashService.setGeneratePublicSalt(true);
        
        DefaultPasswordService passwordService = new DefaultPasswordService();
        passwordService.setHashService(hashService);
        String encryptedPassword = passwordService.encryptPassword(password);
        
        return encryptedPassword;
    }
    
    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
    
    /**
     * Try and authenticate the user
     */
    public void doLogin() {
        Subject subject = SecurityUtils.getSubject();
        
        UsernamePasswordToken token = new UsernamePasswordToken(getUsername(), getPassword(), getRememberMe()); 
        try {
            subject.login(token);
            if (subject.hasRole("Administrador")) {
                System.out.println("Lol - admin");
                PersonaActual();
                FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador/index.xhtml");
            }
            else if( subject.hasRole("Estudiante") || subject.hasRole("Graduado") ){
                System.out.println("Lol - est o grad");
                PersonaActual();
                FacesContext.getCurrentInstance().getExternalContext().redirect("Usuario/index.xhtml");
            }
            else {
                System.out.println("Lol - otra cosa");
                FacesContext.getCurrentInstance().getExternalContext().redirect("open/index.xhtml");
            }
        }
        catch (UnknownAccountException ex) {
            System.out.println("Error - 1");
            facesError("El usuario no se encuentra registrado. Por favor, verifique los datos");
            log.error(ex.getMessage(), ex);
        }
        catch (IncorrectCredentialsException ex) {
            System.out.println("Error - 2");
            facesError("Datos erróneos. Por favor, inténtelo otra vez.");
            log.error(ex.getMessage(), ex);
        }
        catch (LockedAccountException ex) {
            System.out.println("Error - 3");
            facesError("Su cuenta ha sido bloqueada. Por favor, inténtelo más tarde");
            log.error(ex.getMessage(), ex);
        }
        catch (AuthenticationException | IOException ex) {
            System.out.println("Error - 4");
            facesError("Error inesperado: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
        finally {
            token.clear();
        }
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rememberMe
     */
    public Boolean getRememberMe() {
        return rememberMe;
    }

    /**
     * @param rememberMe the rememberMe to set
     */
    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    /**
     * @return the personaLog
     */
    public User getPersonaLog() {
        return personaLog;
    }

    /**
     * @param personaLog the personaLog to set
     */
    public void setPersonaLog(User personaLog) {
        this.personaLog = personaLog;
    }
    
    /**
     * 
     */
    public void PersonaActual(){
        try{
            personaLog = rp.getUser(Integer.parseInt(username));
        }catch(ExcepcionServiciosAeci ex){
            System.out.println("QUE PUTAS");
        }
    }
}
