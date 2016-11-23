/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.managedbeans;

/***
importar aca las clases que necesiten
import edu.eci.pdsw.samples.aeci.;

***/
import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeciDAO;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author hcadavid
 */
@ManagedBean(name = "solicitudAfiliacion")
@SessionScoped

public class SolicitudAfiliacionBean implements Serializable{

        
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String Celular;
    private String telefonoFijo;
    private String correo;
    private int Carrera;
    private String AnoGraduacion;
    private int Periodo;
    private Date fechaNacimiento;
    public static ServiciosAeci  Rp = ServiciosAeci.getInstance();
    
    private String semestre;
    private String NombreEmpresa;
    private String Cargo;
    private String DireccionEmpresa;
    private String TelefonoEmpresa;
    private Rol role;
    
    /**
     * Agrega la solicitud de las personas
     */
    public void enviarSolicitud(){
        try{
            int yearGraduate = Integer.parseInt(AnoGraduacion);
            int id = Integer.parseInt(Cedula);
            try{
                Calendar fecha = new GregorianCalendar();
                java.util.Date fechaDeEnvio  = fecha.getTime();
                Program programa = Rp.getProgram(Carrera);
                Rol rol = Rp.getRol(1);
                User newUser = new User(id, Nombre, Apellido, correo, telefonoFijo, Celular, programa, yearGraduate, Periodo, fechaNacimiento,rol);
                Rp.addUser(newUser);
                Request request = new Request(newUser, 2);
                Rp.addRequest(request);
            }catch(ExcepcionServiciosAeci ex){
                System.out.println("SE CAGO "+ex.getMessage());

            }
        }catch(NumberFormatException ex){
            System.out.println("Dato Agregado no es numerico");
        }
        
    }
        
    /**
     * @return the Cedula
     */
    public String getCedula() {
        return Cedula;
    }

    /**
     * @param Cedula the Cedula to set
     */
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    /**
     * @return the Celular
     */
    public String getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    /**
     * @return the telefonoFijo
     */
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    /**
     * @param telefonoFijo the telefonoFijo to set
     */
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the Carrera
     */
    public int getCarrera() {
        return Carrera;
    }

    /**
     * @param Carrera the Carrera to set
     */
    public void setCarrera(int Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * @return the AnoGraducacion
     */
    public String getAnoGraducacion() {
        return AnoGraduacion;
    }

    /**
     * @param AnoGraducacion the AnoGraducacion to set
     */
    public void setAnoGraducacion(String AnoGraducacion) {
        this.AnoGraduacion = AnoGraducacion;
    }

    /**
     * @return the Periodo
     */
    public int getPeriodo() {
        return Periodo;
    }

    /**
     * @param Periodo the Periodo to set
     */
    public void setPeriodo(int Periodo) {
        this.Periodo = Periodo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the NombreEmpresa
     */
    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    /**
     * @param NombreEmpresa the NombreEmpresa to set
     */
    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    /**
     * @return the Cargo
     */
    public String getCargo() {
        return Cargo;
    }

    /**
     * @param Cargo the Cargo to set
     */
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    /**
     * @return the DireccionEmpresa
     */
    public String getDireccionEmpresa() {
        return DireccionEmpresa;
    }

    /**
     * @param DireccionEmpresa the DireccionEmpresa to set
     */
    public void setDireccionEmpresa(String DireccionEmpresa) {
        this.DireccionEmpresa = DireccionEmpresa;
    }

    /**
     * @return the TelefonoEmpresa
     */
    public String getTelefonoEmpresa() {
        return TelefonoEmpresa;
    }

    /**
     * @param TelefonoEmpresa the TelefonoEmpresa to set
     */
    public void setTelefonoEmpresa(String TelefonoEmpresa) {
        this.TelefonoEmpresa = TelefonoEmpresa;
    }

}
