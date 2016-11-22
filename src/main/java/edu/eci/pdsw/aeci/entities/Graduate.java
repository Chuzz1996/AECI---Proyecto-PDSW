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
    private int user_id;

    public Graduate() {
    }
   
    public Graduate(int Id,String Charge,String Employer,String address,String phone,int User_id){
         id=Id;
         charge=Charge;
         employer=Employer;
         office_address=address;
         office_phone=phone;
         user_id=User_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getOffice_address() {
        return office_address;
    }

    public void setOffice_address(String office_address) {
        this.office_address = office_address;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

  
    
}
