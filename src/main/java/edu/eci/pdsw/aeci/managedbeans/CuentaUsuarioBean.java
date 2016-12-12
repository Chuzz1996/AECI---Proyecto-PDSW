/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.managedbeans;

import edu.eci.pdsw.aeci.seguridad.ShiroLoginBean;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.UploadedFile;
import java.sql.Blob;

/**
 *
 * @author 2108616
 */
@ManagedBean(name = "cuentaUsuario")
@SessionScoped
public class CuentaUsuarioBean implements Serializable {

    
    
    
    
    private static ServiciosAeci rp = ServiciosAeci.getInstance();
    private String nombre;
    private String apellido;
    private String rol;
    private String paymentNumber;
    private byte[] receipt;
    
    private String urlMenuPrincipal;
    private String urlMenuLateral= "Default";
    
    public CuentaUsuarioBean(){
        
    }
    /**
    *Inicio injection 
    **/
    @ManagedProperty(value="#{loginBean}")
    private ShiroLoginBean login;
    /**
     * 
     * @param messageBean 
     */ 
    public void setLogin(ShiroLoginBean messageBean) {
	this.login = messageBean;
    }
    
    
    /**
     * @return the rp
     */
    public ServiciosAeci getRp() {
        return rp;
    }

    /**
     * @param rp the rp to set
     */
    public void setRp(ServiciosAeci rp) {
        this.rp = rp;
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
     * @return the urlMenuPrincipal
     */
    public String getUrlMenuPrincipal() {
        return urlMenuPrincipal;
    }

    /**
     * @param urlMenuPrincipal the urlMenuPrincipal to set
     */
    public void setUrlMenuPrincipal(String urlMenuPrincipal) {
        this.urlMenuPrincipal = urlMenuPrincipal;
    }

    /**
     * @return the urlMenuLateral
     */
    public String getUrlMenuLateral() {
        return urlMenuLateral;
    }

    /**
     * @param urlMenuLateral the urlMenuLateral to set
     */
    public void setUrlMenuLateral(String urlMenuLateral) {
        this.urlMenuLateral = urlMenuLateral;
    }
    
    /**
     * @return the paymentNumber
     */
    public String getPaymentNumber() {
        return paymentNumber;
    }

    /**
     * @param paymentNumber the paymentNumber to set
     */
    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }
    
    /**
     * @return the Receipt
     */
    public byte[] getReceipt() {
        return receipt;
    }

    /**
     * @param Receipt the Receipt to set
     */
    public void setReceipt(byte[] Receipt) {
        this.receipt = Receipt;
    }
    
    /**
     * Sube y registra el pago de la afiliacion
     */
    public void RegistrarPago(){
        if(receipt!=null){
            
        }
    }
     
}
