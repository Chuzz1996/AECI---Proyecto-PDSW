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
public interface DaoGraduate {
    
    /**
     * 
     * @param graduate
     * @throws PersistenceException 
     */
    public void addGraduate(Graduate graduate)throws PersistenceException;
    
}
