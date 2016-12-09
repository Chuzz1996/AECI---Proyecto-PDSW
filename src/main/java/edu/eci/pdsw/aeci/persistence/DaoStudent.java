/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence;

import edu.eci.pdsw.aeci.entities.*;

/**
 *
 * @author 2095498
 */
public interface DaoStudent {
    
    /**
     * 
     * @param student
     * @throws PersistenceException 
     */
    public void addStudent(Student student)throws PersistenceException;
    
}
