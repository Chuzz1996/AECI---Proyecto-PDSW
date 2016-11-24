/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.managedbeans;

import edu.eci.pdsw.aeci.services.ServiciosAeci;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2108616
 */
@ManagedBean(name = "cuentaUsuario")
@SessionScoped
public class CuentaUsuarioBean implements Serializable {
    
    public ServiciosAeci rp;
    private String nombre;
    private String apellido;
    private String rol;
    
    private String urlMenuPrincipal;
    private String urlMenuLateral= "Default";
    
    public String getUrlMenuPrincipal() {
        return urlMenuPrincipal;
    }

    public String getUrlMenuLateral() {
        return urlMenuLateral;
    }

    public void setUrlMenuPrincipal(String urlMenuPrincipal) {
        this.urlMenuPrincipal = urlMenuPrincipal;
    }

    public void setUrlMenuLateral(String urlMenuLateral) {
        this.urlMenuLateral = urlMenuLateral;
    }

    public ServiciosAeci getRp() {
        return rp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRol() {
        return rol;
    }
    
}
