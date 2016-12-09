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
    private String password;
    private boolean active;
    private int salt;

    
    
    public Account() {
    }
    
    public Account(int Id,int password,boolean active){
        
    }
    
    

    public Account getDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the id
     */
    public User getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(User id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the salt
     */
    public int getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(int salt) {
        this.salt = salt;
    }

}
