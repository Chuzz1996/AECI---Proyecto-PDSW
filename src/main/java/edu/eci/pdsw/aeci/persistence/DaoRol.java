/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence;

import edu.eci.pdsw.aeci.entities.Rol;

/**
 *
 * @author estudiante
 */
public interface DaoRol {
    
    public Rol getDAORol(int id)throws PersistenceException;
}
