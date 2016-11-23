/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.aeci.managedbeans;

/***
importar aca las clases que necesiten
import edu.eci.pdsw.samples.aeci.;

***/
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author 
 */
@ManagedBean(name = "cuentaAdministrador")
@SessionScoped
public class CuentaAdministradorBean implements Serializable{
   
    public ServiciosAeci  rp;
    private String nombre;
    private String apellido;
    private String rol;
    
    //Process requests
    private Request request;    
    private String currentCommentary, currentState;       
    
    //menus
    private String urlMenuPrincipal;
    private String urlMenuLateral= "Default";

    public String getUrlMenuPrincipal() {
        System.out.println(urlMenuLateral);
        return urlMenuPrincipal;
    }

    public String getUrlMenuLateral() {
        System.out.println(urlMenuLateral);
        return urlMenuLateral;
    }

    public void setUrlMenuPrincipal(String urlMenuPrincipal) {
        this.urlMenuPrincipal = urlMenuPrincipal;  
        System.out.println("Segunda "+urlMenuLateral);
    }

    public void setUrlMenuLateral(String urlMenuLateral) {
        System.out.println("Segunda "+urlMenuLateral);
        this.urlMenuLateral = urlMenuLateral;    
        
    }
    
        
    public CuentaAdministradorBean() {
        rp = ServiciosAeci.getInstance();
    }
    
    //Process requests
    public Request getRequest() {
        return request;        
    }
      

    public List<Request> getPendingRequests() throws ExcepcionServiciosAeci {
        return rp.getPendingRequests();
    }  

    public void setRequest(Request currentRequest) {
        this.request = request;
    }
    
    public void updateRequest() throws ExcepcionServiciosAeci{
        rp.updateRequest(request, currentCommentary, currentState);
    }
           
     /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * 
     */
    public void procesarAfiliacion(){
        
    }
    
    /**
     * 
     */
    public void GenerarReportes(){
    
    }
    
    
}
