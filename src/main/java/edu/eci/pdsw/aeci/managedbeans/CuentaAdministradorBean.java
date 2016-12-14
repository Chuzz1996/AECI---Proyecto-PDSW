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
import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoAccount;
import edu.eci.pdsw.aeci.seguridad.ShiroLoginBean;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServicioEnvioCorreos;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aeci-Team
 */
@ManagedBean(name = "cuentaAdministrador")
@SessionScoped
public class CuentaAdministradorBean implements Serializable{
   
    public static ServiciosAeci  rp = ServiciosAeci.getInstance();
    private String nombre;
    private String apellido;
    private String rol;
    
    //Process requests
    private Request request;    
    private String currentCommentary, currentState;       
    private int solicitud;
    
    //Menu
    private List<Request> solicitudesPendientes;

    private String solicitudActual;  
   
    //Reportes por vencer
    private List<User> usuariosPorVencer;
    private User usuarioActual;

        
    //Pagos pendientes
    private List<User> userVencidos;
    
    private User userVencido;
 
    public String error;
    
    //Por vencerse
    
    public List<Membership> getUsuariosPorVencerse(){
        List<Membership> membership = null;
        try {  
            membership = rp.getSolicitudesPorVencerse();
        } catch (ExcepcionServiciosAeci ex) {
            error = ex.getMessage();
            ShowError();
        }
        return (membership);
    }
    
    public void setUserVencidos(List<User> userVencidos) {
        this.userVencidos = userVencidos;
    }

    public void setUserVencido(User userVencido) {
        this.userVencido = userVencido;
    }
    
    public List<User> getUserVencidos() {
        return userVencidos;
    }

    public User getUserVencido() {
        return userVencido;
    }
    
    
        
    public CuentaAdministradorBean() {
        this.setSolicitudesPendientes();
    }
    
    public void setUsuariosPorVencer(List<User> usuariosPorVencer) {
        this.usuariosPorVencer = usuariosPorVencer;
    }

    public void setUsuarioActual(User usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public List<User> getUsuariosPorVencer() {
        return usuariosPorVencer;
    }

    public User getUsuarioActual() {
        return usuarioActual;
    }  
    
    /**
     * Retorna el usuario que hizo la solicitud.
     * @return user
     */
    public User getDetailsRequest() {
        return getRequest().getUser();        
    }
    
    public void ShowError(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error!", error));
    }
    
    /***
     * Procesa la solicitud. 
     * @throws ExcepcionServiciosAeci Si ocurre algun error actualizando el request
     */
    public void processRequest() throws ExcepcionServiciosAeci{
        rp.updateRequest(getRequest(), currentCommentary, currentState);
    }
    
    public void updateRequest() throws ExcepcionServiciosAeci{
        rp.updateRequest(getRequest(), currentCommentary, currentState);
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
     * @return the solicitudesPendientes
     */
    public List<Request> getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    /**
     * 
     */
    public void setSolicitudesPendientes() {
        try{
            this.solicitudesPendientes = rp.getPendingRequests();
        }catch(ExcepcionServiciosAeci ex){
            error = ex.getMessage();
            ShowError();
        }        
    }
        
    
    
    
    /**
     * @return the solicitudActual
     */
    public String getSolicitudActual() {
        return solicitudActual;
    }

    /**
     * @param solicitudActual the solicitudActual to set
     */
    public void setSolicitudActual(String solicitudActual) {
        this.solicitudActual = solicitudActual;
    }
    
    
    /**
     * Consultar usuario
     * @return the url
     */
    public String checkUsuario(){ 
        String url = null;
        try{
            int revision = Integer.parseInt(solicitudActual);
            boolean bandera = false;
            for(Request x:solicitudesPendientes){
                if(x.getId()==revision){
                    this.setRequest(x);
                    url = "SolicitudesPendientesUsuarios.xhtml?faces-redirect=true";
                    bandera = true;
                    break;
                }
            }
            if(!bandera){
                throw new ExcepcionServiciosAeci("No se ha encontrado la solicitud");
            }        
        }catch(ExcepcionServiciosAeci ex){
            error = ex.getMessage();
            ShowError();
        }catch(NumberFormatException w){
            error = w.getMessage();
            ShowError();
        }return (url);
       
    }
    
    /**
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.request = request;
    }
    
    /**
     * @return the solicitud
     */
    public int isSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(int solicitud) {
        this.solicitud = solicitud;
    }
    
    /**
     * Cambia estado de solicitud 
     * @return Returns the new direction of the page
     */
    public String changeRequest(){
        try{
            ServicioEnvioCorreos sc = new ServicioEnvioCorreos();
            System.out.println(request.getUser().getFirstName() + "  -  "+ request.getUser().getLastName());
            rp.updateUser(request.getUser().getId(), request.getUser());
            if(solicitud==0){
                rp.updateRequest(request,request.getCommentary(), "A");
                Account account = new Account(request.getUser(),500000);
                rp.addAccount(account);
                sc.aprobado(request.getUser(), request);
            }else if(solicitud==1){
                rp.updateRequest(request,request.getCommentary(), "R");
                sc.rechazado(request.getUser(), request);
            }
        }catch(ExcepcionServiciosAeci ex){
            error = ex.getMessage();
            ShowError();
        }
        return ("/Administrador/Solicitudes/SolicitudesAfilPendientes?faces-redirect=true");
    }
    
    
}
