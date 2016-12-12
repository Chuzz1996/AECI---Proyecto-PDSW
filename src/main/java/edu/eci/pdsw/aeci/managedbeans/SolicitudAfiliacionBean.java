package edu.eci.pdsw.aeci.managedbeans;

/***
importar aca las clases que necesiten
import edu.eci.pdsw.samples.aeci.;

***/
import edu.eci.pdsw.aeci.entities.Graduate;
import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.Student;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServicioEnvioCorreos;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeciDAO;
import java.io.Serializable;
import java.sql.Date;
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
    private java.sql.Date fechaNacimiento;
    public static ServiciosAeci  Rp = ServiciosAeci.getInstance();
    
    private int semestre;
    private String NombreEmpresa;
    private String cargo;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private java.lang.Long role;
    private String respuesta;
    
    public SolicitudAfiliacionBean(){
        this.respuesta = "No se ha enviado la solicitud, hace falta llenar algun dato obligatorio";
        
    }

       
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
                Rol rol = Rp.getRol((int)(long)role);
                User newUser = new User(id, Nombre, Apellido, correo, telefonoFijo, Celular, programa, yearGraduate, Periodo, fechaNacimiento,rol);
                Rp.addUser(newUser);
                Request request = new Request(newUser, 2);
                if((int)(long)role == 1){
                    Graduate graduate = new Graduate(cargo,NombreEmpresa,direccionEmpresa,telefonoEmpresa,newUser);
                    Rp.addGraduate(graduate);
                }else if((int)(long)role == 2){
                    Student student = new Student(newUser,semestre);
                    Rp.addStudent(student);
                }
                Rp.addRequest(request);
                ServicioEnvioCorreos sp = new ServicioEnvioCorreos();
                sp.EnvioDeSolicitud();
                setRespuesta("Su solicitud fue enviar, la respuesta se le hara llegar al correo");
            }catch(ExcepcionServiciosAeci ex){
                setRespuesta("No se ha enviado la solicitud, existe algun error en los datos ingresados");                
            }
        }catch(NumberFormatException ex){
            setRespuesta("No se ha enviado la solicitud, existe algun error en los datos ingresados");
            System.out.println("Dato Agregado no es numerico");
            ex.printStackTrace();
        }
    }
    
    /**
     * 
     * @param idRole
     * @throws ExcepcionServiciosAeci 
     */
    public void setRole(java.lang.Long idRole) throws ExcepcionServiciosAeci {       
        this.role = idRole;
    }

    /**
     * 
     * @return 
     */
    public Long getRole() {
        return role;
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
    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(java.util.Date fechaNacimiento) {
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
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
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the Cargo to set
     */
    public void setCargo(String cargo) {
        System.out.println("CargoSet: "+cargo);
        this.cargo = cargo;
    }

    /**
     * @return the direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * @param direccionEmpresa the DireccionEmpresa to set
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * @return the telefonoEmpresa
     */
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     * @param telefonoEmpresa the TelefonoEmpresa to set
     */
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
