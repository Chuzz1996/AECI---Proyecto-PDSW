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


public class Account {
    private User id;
    private int password;
    private boolean active;
    private int salt;

    public int getSalt() {
        return salt;
    }

    public void setSalt(int Salt) {
        this.salt = Salt;
    }
    
    public Account() {
    }
    
    public Account(int Id,int password,boolean active){
        
    }
    
    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Account getDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
