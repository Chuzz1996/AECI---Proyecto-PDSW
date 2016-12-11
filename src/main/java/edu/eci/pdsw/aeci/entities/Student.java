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
public class Student {
    
    private int id;
    private User user;
    private int semester;
    
    public Student() {        
    }
    
    public Student(User user, int semester) {
        this.user = user;
        this.semester = semester;
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
     * @return the user_id
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user_id to set
     */
    public void setUser_id(User user) {
        this.user = user;
    }

    /**
     * @return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
}