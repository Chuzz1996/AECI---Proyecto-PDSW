/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.seguridad;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.security.auth.Subject;

/**
 *
 * @author felipelosada
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class Login implements Serializable{

    private String username;
    private String password;
    private Boolean rememberMe;
    
    
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
    
}
