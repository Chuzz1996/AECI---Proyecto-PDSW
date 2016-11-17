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
public interface DaoProgram {
    
    /**
     * Returns the program given the id
     * @param id the program's id
     * @return Returns the program given the id
     * @throws PersistenceException if id is null
     */
    public Program getProgram(int id) throws PersistenceException;
    
}
