/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

import java.util.Date;

/**
 *
 * @author 2095498
 */
public class Request {
    
    private String commentary, state;
    private Date date;
    private User user;
    
    public Request (User user){
        this.commentary = "";
        this.state = "E";
        this.date = new Date();
        this.user= user;
    }
    
    /**
     * @return the user that mades the request
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the commentary
     */
    public String getCommentary() {
        return commentary;
    }

    /**
     * @param commentary the commentary to set
     */
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
