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
    
    /**
     * Update a request with a new commentary
     * @param r
     * @param commentary
     * @throws PersistenceException
     */
    public void updateRequestCommentary(Request r, String commentary) throws PersistenceException;
    
    /**
     * Update a request with a new state
     * @param r
     * @param state
     * @throws PersistenceException
     */
    public void updateRequestState(Request r, String state) throws PersistenceException;
    
    /**
     * Add new request to data base
     * @param r
     * @throws PersistenceException
     */
    public void addRequest(Request r)throws PersistenceException;
    
    /**
     * Get Active requests (pending review)
     * @return activeRequests with the pending requests
     * @throws PersistenceException 
     */
    public List<Request> getPendingRequests()throws PersistenceException;
    
}
