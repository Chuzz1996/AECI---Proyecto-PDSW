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
public interface DaoMembership {
    
    /**
     * 
     * @param membership the membership to be added
     * @throws PersistenceException if occurs any error
     */
    public void addMembership(Membership membership)throws PersistenceException;
    
    /**
     * 
     * @param membership the membership to be updated
     * @throws PersistenceException if occurs any error
     */
    public void updatePayment(Membership membership)throws PersistenceException;
    
    /**
     * 
     * @return lista de solicitudes por vencerse
     * @throws PersistenceException if occurs any error
     */
    public List<Membership> getSolicitudesPorVencerse()throws PersistenceException;
    
    /**
     * 
     * @return lista de afiliaciones vencidas
     * @throws PersistenceException if occurs any error
     */
    public List<Membership> getAfiliacionesVencidas()throws PersistenceException;
}
