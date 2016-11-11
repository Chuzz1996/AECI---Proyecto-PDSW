/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.aeci.entities.*;
import java.util.List;

/**
 *
 * @author 2095498
 */
public interface RequestMapper {
    
    public List<Request> getActiveRequests();
    
    public void addRequest(Request r);
    
    public void updateRequest(Request r,String commentary,String state);
    
}
