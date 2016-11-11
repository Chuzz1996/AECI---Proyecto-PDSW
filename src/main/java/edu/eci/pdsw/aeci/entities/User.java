/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import java.util.Date;

/**
 *
 * @author 2095498
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private String celphone;
    private Program program;
    private int yearGraduate;
    private int periodo;
    private Date fechaDeNacimiento;
    
    public User( int Id,String FirstName,String LastName,String Email,int Phone,String Celphone,Program programa, int YearGraduate, int periodo, Date fechaDeNacimiento) throws ExcepcionServiciosAeci{
        this.id=Id;
        this.firstName=FirstName;
        this.lastName=LastName;
        revisarCorreo(Email);
        this.email=Email;
        this.phone=Phone;
        this.celphone=Celphone;
        this.program=programa;
        this.yearGraduate=YearGraduate;
        this.periodo = periodo;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void revisarCorreo(String Email) throws ExcepcionServiciosAeci{
        String[] revisarCorreoValido = Email.split("@");
        if(revisarCorreoValido.length < 2){
            throw new ExcepcionServiciosAeci("No es un correo");
        }else if(revisarCorreoValido[1].equals("mail.escuelaing.edu.co")){
            throw new ExcepcionServiciosAeci("No puede ser correo institucional");
        }String[] segundaRevisionCorreo = revisarCorreoValido[1].split(".");
        if(segundaRevisionCorreo.length < 2){
            throw new ExcepcionServiciosAeci("No es un correo");
        }
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) throws ExcepcionServiciosAeci {
        revisarCorreo(email);
        this.email = email;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return the celphone
     */
    public String getCelphone() {
        return celphone;
    }

    /**
     * @param celphone the celphone to set
     */
    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    /**
     * @return the program
     */
    public Program getProgram() {
        return program;
    }

    /**
     * @param program the program to set
     */
    public void setProgram(Program program) {
        this.program = program;
    }

    /**
     * @return the yearGraduate
     */
    public int getYearGraduate() {
        return yearGraduate;
    }

    /**
     * @param yearGraduate the yearGraduate to set
     */
    public void setYearGraduate(int yearGraduate) {
        this.yearGraduate = yearGraduate;
    }

    /**
     * @return the periodo
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @param fechaDeNacimiento the fechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    
    
}
