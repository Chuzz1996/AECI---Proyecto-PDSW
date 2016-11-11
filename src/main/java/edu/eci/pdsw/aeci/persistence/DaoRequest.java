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
public interface DaoRequest {
    
    public void updateRequest()throws PersistenceException;
    
    public void addRequest()throws PersistenceException;
    
    public List<Request> getActiveRequests()throws PersistenceException;
    
}
