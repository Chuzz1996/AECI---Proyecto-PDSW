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
import edu.eci.pdsw.aeci.entities.User;
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
    
    //Menu
    private List<Request> solicitudesPendientes;
      
    
        
    public CuentaAdministradorBean() {
        rp = ServiciosAeci.getInstance();
        this.setSolicitudesPendientes();
    }
    
    //Process requests
    public Request getRequest() {
        return request;        
    }
    
    /**
     * Retorna el usuario que hizo la solicitud.
     * @return user
     */
    public User getDetailsRequest() {
        return request.getUser();        
    }
    
    /***
     * Procesa la solicitud. 
     * @throws ExcepcionServiciosAeci 
     */
    public void processRequest() throws ExcepcionServiciosAeci{
        rp.updateRequest(request, currentCommentary, currentState);
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
    
    /**
     * @return the solicitudesPendientes
     */
    public List<Request> getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    /**
     * @param solicitudesPendientes the solicitudesPendientes to set
     */
    public void setSolicitudesPendientes() {
        try{
            this.solicitudesPendientes = rp.getPendingRequests();
        }catch(ExcepcionServiciosAeci ex){
            System.out.println("EN CUENTA ADMINISTRADOR"+ex.getMessage());
        }
    }
    
    private int solicitudActual;
    private User usuarioActual;
    private Request solicitud;
    
    /**
     * @return the solicitudActual
     */
    public int getSolicitudActual() {
        return solicitudActual;
    }

    /**
     * @param solicitudActual the solicitudActual to set
     */
    public void setSolicitudActual(int solicitudActual) {
        this.solicitudActual = solicitudActual;
    }
    
    /**
     * Consultar usuario
     */
    public void checkUsuario(){
        try{
            for(Request x:solicitudesPendientes){
                if(x.getId()==solicitudActual){
                    usuarioActual = x.getUser();
                    solicitud = x;
                    break;
                }
            }
        }catch(Exception ex){
            System.out.println("No existe un usuario con ese id");
        }
    }
    
}
