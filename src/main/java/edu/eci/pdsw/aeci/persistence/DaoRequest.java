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
     * Update a request with a new state and commentary
     * @param r the request to be changed
     * @param state The current sate
     * @param commentary commentary for the change of the sate
     * @throws PersistenceException if state or commentary are null
     */
    public void updateRequest(Request r, String state, String commentary) throws PersistenceException;
    
    /**
     * Add new request to data base
     * @param r request
     * @throws PersistenceException if identification of request is null
     */
    public void addRequest(Request r)throws PersistenceException;
    
    /**
     * Get Active requests (pending review)
     * @return activeRequests with the pending requests
     * @throws PersistenceException if there is error with the data base
     */
    public List<Request> getPendingRequests()throws PersistenceException;
    
}
