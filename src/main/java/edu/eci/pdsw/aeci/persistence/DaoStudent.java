/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence;

import edu.eci.pdsw.aeci.entities.*;
import java.util.List;

/**
 *
 * @author 2095498
 */
public interface DaoStudent {
    
    /**
     * Add a new student.
     * @param student the new student.
     * @throws PersistenceException if occurs any error
     */
    public void addStudent(Student student) throws PersistenceException;
    
    /**
     * A list of all the current students.
     * @return All the current students.
     * @throws PersistenceException if occurs any error
     */
    public List<Student> getStudents() throws PersistenceException;
    
    /**
     * sets the new photo in the database
     * @param student the student with the new photo
     * @throws PersistenceException if occurs any error
     */
    public void addCarnet(Student student)throws PersistenceException;
    
}
