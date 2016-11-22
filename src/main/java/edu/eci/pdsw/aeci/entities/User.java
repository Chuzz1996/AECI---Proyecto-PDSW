/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author 2095498
 */
public class User {

    private int id,yearGraduate,period;
    private String firstName,lastName,email,cellphone,phone;
    private Program program;
    private Date birthDate;
    private Rol role;

    public User() {
    }
    
    public User( int id,String firstName,String lastName,String email,String phone,String cellphone,Program program, int yearGraduate, int period, Date birthDate, Rol role) throws ExcepcionServiciosAeci{
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        //revisarCorreo(email);
        this.email=email;
        this.phone=phone;
        this.cellphone=cellphone;
        this.program=program;
        this.yearGraduate=yearGraduate;
        this.period = period;
        this.birthDate = birthDate;
        this.role = role;
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
     * @return the role
     */
    public Rol getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Rol role) {
        this.role = role;
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
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the celphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the celphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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
    public int getPeriod() {
        return period;
    }

    /**
     * @param period the periodo to set
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setFechaDeNacimiento(Date birthDate) {
        this.birthDate = birthDate;
    }

    
    
}
