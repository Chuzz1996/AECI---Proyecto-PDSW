/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

import java.sql.Date;

/**
 *
 * @author 2095498
 */
public class Agreement {
    private int id;
    private Date start_Date;
    private Date end_Date;
    private String name;

    public Agreement() {
    }
    
    public Agreement (int Id,Date Start_Date,Date End_Date,String Name){
        id=Id;
        start_Date=Start_Date;
        end_Date=End_Date;
        name=Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date End_Date) {
        this.end_Date = End_Date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
    
}
