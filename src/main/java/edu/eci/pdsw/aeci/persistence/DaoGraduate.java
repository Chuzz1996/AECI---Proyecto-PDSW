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
public interface DaoGraduate {
    
    /**
     * Adds a new graduate.
     * @param graduate the new graduate
     * @throws PersistenceException if occurs any error
     */
    public void addGraduate(Graduate graduate)throws PersistenceException;
    
    /**
     * A list of all the current graduates.
     * @return All the current graduates.
     * @throws PersistenceException if occurs any error
     */
    public List<Graduate> getGraduates() throws PersistenceException;
    
}
