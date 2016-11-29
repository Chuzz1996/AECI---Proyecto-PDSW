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
public class Student {
    
    private int id;
    private User user_id;
    private int semester;

    public Student() {
    }
    
    public Student(int Id,User User_id, int Semester) {
        this.id=Id;
        this.user_id=User_id;
        this.semester=Semester;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    

}
