/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

/**
 *
 * @author 2095498
 */
public class Graduate {


    private int id;
    private String charge;
    private String employer;
    private String office_address;
    private String office_phone;
    private User user_id;

    public Graduate() {
    }
   
    public Graduate(String Charge,String Employer,String address,String phone,User User_id){
         this.charge=Charge;
         this.employer=Employer;
         this.office_address=address;
         this.office_phone=phone;
         this.user_id=User_id;
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
     * @return the charge
     */
    public String getCharge() {
        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(String charge) {
        this.charge = charge;
    }

    /**
     * @return the employer
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * @param employer the employer to set
     */
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    /**
     * @return the office_address
     */
    public String getOffice_address() {
        return office_address;
    }

    /**
     * @param office_address the office_address to set
     */
    public void setOffice_address(String office_address) {
        this.office_address = office_address;
    }

    /**
     * @return the office_phone
     */
    public String getOffice_phone() {
        return office_phone;
    }

    /**
     * @param office_phone the office_phone to set
     */
    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    /**
     * @return the user_id
     */
    public User getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
    
}
